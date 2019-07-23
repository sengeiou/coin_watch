package com.terry.watch.task;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.android.util.LContext;
import com.terry.watch.MainActivity;
import com.terry.watch.R;

/**
 * @author 张全
 */
public class ProgroundService extends Service {
    final String channelId = "1";
    private NotificationManager notificationManager;
    private NotificationCompat.Builder mBuilder;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startForground();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    private void initNotification() {
        if (null != notificationManager) {
            return;
        }
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

    private void startForground() {
        initNotification();
        Intent intent = new Intent(LContext.getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(LContext.getContext(), 0, intent,
                0);
        mBuilder.setContentTitle("肥仔比特币")
                .setContentText("监听肥仔的操作,如果服务被系统关闭，请重新打开APP")
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent);
        Notification notify = mBuilder.build();
        startForeground(1, notify);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }
}
