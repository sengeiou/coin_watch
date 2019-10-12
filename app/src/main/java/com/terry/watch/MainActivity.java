package com.terry.watch;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.terry.watch.task.CoreService;
import com.terry.watch.task.ProgroundService;

/**
 * @author 张全
 */
public class MainActivity extends AppCompatActivity {
    public static final String MOVE_TO_BACK = "moveToBack";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //肥仔
        findViewById(R.id.user_banner1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserActivity.start(MainActivity.this, Constant.UID_FVS);
            }
        });
        //欧阳拽白
        findViewById(R.id.user_banner2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserActivity.start(MainActivity.this, Constant.UID_OUYANG);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        boolean moveToBack = intent.getBooleanExtra(MOVE_TO_BACK, false);
        System.out.println("MainActivity ...onNewIntent  moveToBack=" + moveToBack);

        startService(new Intent(this, CoreService.class));
        startService(new Intent(this, ProgroundService.class));

        if (moveToBack) {
            moveTaskToBack(true);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void finish() {
        super.finish();
        System.out.println("MainActivity  finish");
    }

}
