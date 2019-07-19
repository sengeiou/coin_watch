package com.terry.watch.task;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

import com.android.util.LContext;
import com.android.util.scheduler.task.ScheduleTask;
import com.terry.watch.MainActivity;
import com.terry.watch.R;
import com.terry.watch.entitiy.ExchangeDetail;
import com.terry.watch.entitiy.FllowReponse;
import com.terry.watch.entitiy.PositionResponse;
import com.terry.watch.http.UserClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 张全
 */
public class ApiTask extends ScheduleTask {
    final String channelId = "1";
    private NotificationManager notificationManager;
    private NotificationCompat.Builder mBuilder;
    private int notifyId = 1;

    @Override
    public long getScheduleTime() {
        return 1 * 60 * 1000;
    }

    @Override
    public void doTask() {

    }

    private void initNotification() {
        notificationManager = (NotificationManager) LContext.getContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel1", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true); //是否在桌面icon右上角展示小红点
            channel.setLightColor(Color.RED); //小红点颜色
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
            mBuilder = new NotificationCompat.Builder(LContext.getContext(), channelId);
            notificationManager.createNotificationChannel(channel);
        } else {
            mBuilder = new NotificationCompat.Builder(LContext.getContext());
        }
    }

    private void sendNotification(String text) {
        notifyId += 1;
        Intent intent = new Intent(LContext.getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(LContext.getContext(), 0, intent,
                0);
        mBuilder.setContentText(text)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        Notification notify = mBuilder.build();
        notificationManager.notify(notifyId, notify);
    }


    private void getFollowList() {
        UserClient.getFllowList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FllowReponse>() {
                    @Override
                    public void accept(FllowReponse fllowReponse) throws Exception {
                        System.out.println("onNext fllowReponse=" + fllowReponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError ");
                    }
                });
    }


    //---------------------持仓列表
    private void getPositionList(String uid) {
        UserClient.getPositionList(uid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PositionResponse>() {
                    @Override
                    public void accept(PositionResponse positionResponse) throws Exception {
                        handlePositionList(positionResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError ");
                    }
                });
    }

    Map<String, Integer> lastCoinMap;

    private void handlePositionList(PositionResponse positionResponse) {
        PositionResponse.DataBean data = positionResponse.data;
        if (null == data || null == data.position || data.position.isEmpty()) {
            //无持仓
            return;
        }
        Map<String, Integer> coinMap = new HashMap<String, Integer>();
        List<PositionResponse.DataBean.PositionBean> positionList = (List<PositionResponse.DataBean.PositionBean>) data.position;
        for (PositionResponse.DataBean.PositionBean coin : positionList) {
            String quantity = coin.quantity; //张数
            String numStr = quantity.replace("张", "");
            Integer num = Integer.valueOf(numStr);
            coinMap.put(coin.title, num);
        }
        Set<String> coins = coinMap.keySet();
        Map<String, Integer> lastMap = lastCoinMap;
        lastCoinMap = coinMap;

        if (null != lastMap) {
            Set<String> lastCoins = lastMap.keySet();
            if (lastCoins.isEmpty() && coins.isEmpty()) { //都是空仓
                return;
            }

            StringBuffer content = new StringBuffer();

            //新开仓
            if (lastCoins.isEmpty() && !coins.isEmpty()) {
                content.append("肥仔新开仓:");
                for (String name : coins) {
                    if (!lastCoins.contains(name)) {
                        content.append(name);
                    }
                }
                sendNotification(content.toString());
            }
            if (!lastCoins.isEmpty() && !coins.isEmpty()) {
                for (String name : coins) {
                    if (!lastCoins.contains(name)) {
                        if (content.length() == 0) {
                            content.append("肥仔新开仓:");
                        }
                        content.append(name);
                    }
                }
                sendNotification(content.toString());
            }


            //平仓
            if (!lastCoins.isEmpty() && coins.isEmpty()) { //全部平仓
                content.append("肥仔全部平仓");
                sendNotification(content.toString());
            }
            if (!lastCoins.isEmpty() && !coins.isEmpty()) {
                for (String name : lastCoins) {
                    if (!coins.contains(name)) {
                        if (content.length() == 0) {
                            content.append("肥仔平仓:");
                        }
                        content.append(name);
                    }
                }
            }

            //仓位变化  加仓或减仓
            if (!lastCoins.isEmpty() && !coins.isEmpty()) {
                for (String name : coins) {
                    Integer nowValue = coinMap.get(name);
                    Integer lastValue = lastMap.get(name);
                    int diff = Math.abs(nowValue = lastValue);
                    if (diff == 0) {
                        continue;
                    }
                    if (content.length() == 0) {
                        content.append("肥仔有新操作了：");
                    }
                    if (lastValue > nowValue) { //减仓
                        content.append("减仓：" + name + diff + "张；");
                    } else if (lastValue < nowValue) { //增仓
                        content.append("加仓：" + name + diff + "张；");
                    }
                }
                if (content.length() > 0) {
                    sendNotification(content.toString());
                }
            }

        }
    }


    //-----------------------持仓详情
    private void getExchangeDetail(String id) {
        UserClient.getChangeDetail(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExchangeDetail>() {
                    @Override
                    public void accept(ExchangeDetail exchangeDetail) throws Exception {
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError ");
                    }
                });
    }
}