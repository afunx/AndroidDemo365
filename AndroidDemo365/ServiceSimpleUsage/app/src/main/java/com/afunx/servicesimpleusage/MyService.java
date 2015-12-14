package com.afunx.servicesimpleusage;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    public static final String ACTION = "MyServiceAction";


    private static void log(String msg) {
        Log.e(TAG, msg);
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    private final IBinder binder = new MyBinder();

    @Override
    public void onCreate() {
        log("onCreate()");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("onBind()");
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("onStartCommand() flags = " + flags + ", startId = " + startId);
        return Service.START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        log("onUnbind()");
        return super.onUnbind(intent);
    }

    // when onUnbind() return true, onRebind() will be called instead of onUnbind() next time
    @Override
    public void onRebind(Intent intent) {
        log("onRebind()");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        log("onDestroy()");
        super.onDestroy();
    }
}
