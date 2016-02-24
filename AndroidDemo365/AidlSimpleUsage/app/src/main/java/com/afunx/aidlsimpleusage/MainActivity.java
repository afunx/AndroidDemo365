package com.afunx.aidlsimpleusage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.afunx.aidlsimpleusage.IMyAidlInterface;

/**
 * 02-24 23:38:10.269    2267-2267/com.afunx.aidlsimpleusage E/MyAidlService﹕ bindService()
 * 02-24 23:38:10.383    2267-2267/com.afunx.aidlsimpleusage E/MyAidlService﹕ onServiceConnected()
 * 02-24 23:38:11.302    2267-2289/com.afunx.aidlsimpleusage E/MyAidlService﹕ 1 serviceRef=com.afunx.aidlsimpleusage.IMyAidlInterface$Stub$Proxy@28aeb920
 * 02-24 23:38:11.302    2267-2289/com.afunx.aidlsimpleusage E/MyAidlService﹕ 2 serviceRef=com.afunx.aidlsimpleusage.IMyAidlInterface$Stub$Proxy@28aeb920
 */
public class MainActivity extends Activity {

    private IMyAidlInterface serviceRef;

    private static final String TAG = "MyAidlService";

    private static void log(String message) {
        Log.e(TAG, message);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            log("onServiceConnected()");
            serviceRef = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceRef = null;
        }
    };

    private void bindService() {
        log("bindService()");
//        Intent intent = new Intent(IMyAidlInterface.class.getName());
        // after Android 5.0, Service intent must be explicit
//        intent.setPackage(getPackageName());

        Intent intent = new Intent(this, MyAidlService.class);

        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void unbindService() {
        if (serviceRef != null) {
            unbindService(serviceConnection);
        }
    }

    private void testAidlService() {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log("1 serviceRef=" + serviceRef);
                try {
                    serviceRef.basicTypes(1, 2, false, 3, 4, "5");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                log("2 serviceRef=" + serviceRef);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
        testAidlService();
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }
}
