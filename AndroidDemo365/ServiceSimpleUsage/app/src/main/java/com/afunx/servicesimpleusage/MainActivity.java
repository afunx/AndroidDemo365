package com.afunx.servicesimpleusage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private MyService mService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            log("onServiceConnected()");
            mService = ((MyService.MyBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            log("onServiceDisconnected()");
            mService = null;
        }
    };


    private static void log(String msg) {
        Log.e(TAG, msg);
    }

    // start service explicit
    private void startServiceExplicit() {
        log("startServiceExplicit()");
        Intent service = new Intent(this, MyService.class);
        startService(service);
    }

    // stop service explicit
    private void stopServiceExplicit() {
        log("stopServiceExplicit()");
        Intent service = new Intent(this, MyService.class);
        stopService(service);
    }

    // start service implicit
    private void startServiceImplicit() {
        log("startServiceImplicit()");
        Intent service = new Intent(MyService.ACTION);
        // After Android 5.0, Service Intent must be explicit or set the intent's package name
        service.setPackage(getPackageName());
        startService(service);
    }

    // stop service implicit
    private void stopServiceImplicit() {
        log("stopServiceImplicit()");
        Intent service = new Intent(MyService.ACTION);
        // After Android 5.0, Service Intent must be explicit or set the intent's package name
        service.setPackage(getPackageName());
        stopService(service);
    }

    // bind service explicit
    private void bindServiceExplicit() {
        log("bindServiceExplicit()");
        Intent service = new Intent(this, MyService.class);
        bindService(service, mConnection, Context.BIND_AUTO_CREATE);
    }

    // unbind service explicit
    private void unbindServiceExplicit() {
        log("unbindServiceExplicit()");
        unbindService(mConnection);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindServiceExplicit();
    }

    @Override
    protected void onDestroy() {
        unbindServiceExplicit();
        super.onDestroy();
    }
}
