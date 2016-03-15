package com.afunx.aidlparcelableusage;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.afunx.aidlparcelableusage.IMyAidlInterface;

import java.util.Date;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private IMyAidlInterface mAidlService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mAidlService = IMyAidlInterface.Stub.asInterface(service);
//            System.out.println("mAidlService = " + mAidlService);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mAidlService = null;
        }
    };


    private static void log(String message) {
        Log.e(TAG, message);
    }

    private void bindService() {
        Intent intent = new Intent(this, MyAidlService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void unbindService() {
        unbindService(mServiceConnection);
    }

    private void testService() {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    MyParcelable parcelablePost = new MyParcelable(new Date(), "My Parcelable details", 20.0);
                    mAidlService.postParcelable(parcelablePost);
                    MyParcelable parcelable = mAidlService.receiveParcelable();
                    log("testService() parcelable = " + parcelable);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
        testService();
    }


    @Override
    protected void onDestroy() {
        unbindService();
        super.onDestroy();
    }
}
