package com.terry.watch;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.terry.watch.task.CoreService;
import com.terry.watch.task.ProgroundService;

/**
 * @author 张全
 */
public class LockScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("LockScreenActivity  onCreate");
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_USER_PRESENT);
        registerReceiver(receiver, intentFilter);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("LockScreenActivity  解锁广播");
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
//        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
//        boolean isScreenOn;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//            isScreenOn= powerManager.isInteractive();
//        }else{
//            isScreenOn=powerManager.isScreenOn();
//        }
//        System.out.println("LockScreenActivity...isScreenOn="+isScreenOn);
//        if(isScreenOn){
//            finish();
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
