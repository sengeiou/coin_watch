package com.terry.watch;

import android.app.Application;
import android.content.Intent;

import com.android.util.LContext;
import com.android.util.scheduler.task.ScheduleTaskManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.terry.watch.task.ApiTask;
import com.terry.watch.task.ApiTask2;
import com.terry.watch.task.CoreService;
import com.terry.watch.task.ProgroundService;

/**
 * @author 张全
 */
public class App extends Application {

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(R.color.colorPrimary, R.color.c_131413);//全局设置主题颜色
            return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//          return new MaterialHeader(context).setColorSchemeResources(android.R.color.holo_blue_bright,
//                    android.R.color.holo_green_light,
//                    android.R.color.holo_orange_light,
//                    android.R.color.holo_red_light);
        });
    }


    @Override
    public void onCreate() {
        super.onCreate();

        LContext.init(this,true);
        ScheduleTaskManager.getInstance().addTask(new ApiTask());
        ScheduleTaskManager.getInstance().addTask(new ApiTask2());

        try{
            startService(new Intent(this, CoreService.class));
            startService(new Intent(this, ProgroundService.class));
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}
