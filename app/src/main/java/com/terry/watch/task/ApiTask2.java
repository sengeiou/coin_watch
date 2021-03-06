package com.terry.watch.task;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

import com.android.util.LContext;
import com.android.util.scheduler.task.ScheduleTask;
import com.terry.watch.Constant;
import com.terry.watch.UserActivity;
import com.terry.watch.R;
import com.terry.watch.entitiy.HomeResponse;
import com.terry.watch.entitiy.PositionResponse;
import com.terry.watch.http.UserClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 欧阳拽白
 *
 * @author 张全
 */
public class ApiTask2 extends ScheduleTask {
    final String channelId = "2";
    private NotificationManager notificationManager;
    private NotificationCompat.Builder mBuilder;
    private int notifyId = 1;
    private String UID=Constant.UID_OUYANG;


    @Override
    public long getScheduleTime() {
        return 1 * 60 * 1000;
    }

    @Override
    public void doTask() {
        initNotification();
        getPositionList(UID);
    }

    private void initNotification() {
        if (null != notificationManager) {
            return;
        }
        notificationManager = (NotificationManager) LContext.getContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel", NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true); //是否在桌面icon右上角展示小红点
            channel.setLightColor(Color.RED); //小红点颜色
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification(String text) {
        if (text.isEmpty()) return;
        notifyId += 1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            mBuilder = new NotificationCompat.Builder(LContext.getContext(), channelId);
        } else {
            mBuilder = new NotificationCompat.Builder(LContext.getContext());
        }
        Intent intent = UserActivity.getIntent(LContext.getContext(),UID);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(LContext.getContext(), 0, intent,
                0);
        mBuilder.setContentText(text)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        Notification notify = mBuilder.build();
        notificationManager.notify(notifyId, notify);

        //震动提醒
        Vibrator vibrator = (Vibrator) LContext.getContext().getSystemService(Context.VIBRATOR_SERVICE);
        long[] patter = {1000, 1000, 2000, 50};
        vibrator.vibrate(patter, -1);
    }


    //---------------------持仓列表
    private void getPositionList(String uid) {
        Observable.zip(UserClient.getPositionList(uid, "okex"),
                UserClient.getPositionList(uid, "bitmex"),
                new BiFunction<PositionResponse, PositionResponse, HomeResponse>() {
                    @Override
                    public HomeResponse apply(PositionResponse positionResponse, PositionResponse positionResponse2) throws Exception {
                        HomeResponse homeResponse = new HomeResponse();
                        homeResponse.positionResponse = positionResponse;
                        homeResponse.positionResponse2 = positionResponse2;
                        return homeResponse;
                    }
                }
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeResponse>() {
                    @Override
                    public void accept(HomeResponse homeResponse) throws Exception {
                        handlePositionList(homeResponse.positionResponse, 1);
                        handlePositionList(homeResponse.positionResponse2, 2);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError ");
                    }
                });
    }

    Map<String, Integer> lastCoinMap;
    Map<String, Integer> lastCoinMap2;

    static int num;

    private void handlePositionList(PositionResponse positionResponse, int pos) {
        PositionResponse.DataBean data = positionResponse.data;
        if (null == data || null == data.position) {
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

        Map<String, Integer> lastMap;
        String platform = pos == 1 ? "Okex" : "Bitmex";
        if (pos == 1) {
            lastMap = lastCoinMap;
            lastCoinMap = coinMap;
        } else {
            lastMap = lastCoinMap2;
            lastCoinMap2 = coinMap;
        }


//        if (num == 1) {
//               //开仓
////              lastMap.clear();
////              coinMap.put("测试BTC",100);
//
//            //平仓
////            coinMap.remove("BSV 季度·多");
//
//            //加仓或减仓
////            coinMap.put("BSV 季度·多",3000);
//        }
//        num++;

        if (null != lastMap) {
            Set<String> lastCoins = lastMap.keySet();
            Set<String> coins = coinMap.keySet();
            if (lastCoins.isEmpty() && coins.isEmpty()) { //都是空仓
                return;
            }

            StringBuffer content = new StringBuffer();

            //新开仓
            if (lastCoins.isEmpty() && !coins.isEmpty()) {
                content.append("欧阳拽白["+platform+"]新开仓:");
                for (String name : coins) {
                    if (!lastCoins.contains(name)) {
                        content.append(name).append(coinMap.get(name) + "张 ");
                    }
                }
                sendNotification(content.toString());
            }

            content = new StringBuffer();
            if (!lastCoins.isEmpty() && !coins.isEmpty()) {
                for (String name : coins) {
                    if (!lastCoins.contains(name)) {
                        if (content.length() == 0) {
                            content.append("欧阳拽白["+platform+"]新开仓:");
                        }
                        content.append(name).append(coinMap.get(name) + "张 ");
                    }
                }
                sendNotification(content.toString());
            }


            //平仓
            content = new StringBuffer();
            if (!lastCoins.isEmpty() && coins.isEmpty()) { //全部平仓
                content.append("欧阳拽白["+platform+"]全部平仓");
                sendNotification(content.toString());
            }
            content = new StringBuffer();
            if (!lastCoins.isEmpty() && !coins.isEmpty()) {
                for (String name : lastCoins) {
                    if (!coins.contains(name)) {
                        if (content.length() == 0) {
                            content.append("欧阳拽白["+platform+"]平仓:");
                        }
                        content.append(name).append(" ");
                    }
                }
                sendNotification(content.toString());
            }

            //仓位变化  加仓或减仓
            if (!lastCoins.isEmpty() && !coins.isEmpty()) {
                content = new StringBuffer();
                for (String name : coins) {
                    if (coins.contains(name) && lastCoins.contains(name)) {
                        Integer nowValue = coinMap.get(name);
                        Integer lastValue = lastMap.get(name);
                        int diff = Math.abs(nowValue - lastValue);
                        if (diff == 0) {
                            continue;
                        }
                        if (content.length() == 0) {
                            content.append("欧阳拽白["+platform+"]有新操作了：");
                        }
                        if (lastValue > nowValue) { //减仓
                            content.append(name + "减仓" + diff + "张 ");
                        } else if (lastValue < nowValue) { //增仓
                            content.append(name + "加仓" + diff + "张 ");
                        }
                    }
                }
                sendNotification(content.toString());
            }

        }
    }

}
