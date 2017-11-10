package com.applicatio.retrorxjavaokhttp;


import android.app.Application;
import android.content.Context;


/**
 * Created by tang on 17/8/17.
 * 应用,主要用来做一下初始化的操作
 */

public class ProApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }

    /**
     * @return
     * 全局的上下文
     */
    public static Context getmContext() {
        return mContext;
    }


}
