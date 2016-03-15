package com.afunx.aidlparcelableusage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.Date;

import com.afunx.aidlparcelableusage.IMyAidlInterface;

public class MyAidlService extends Service {

    private MyParcelable mMyParcelable;

    private static final String TAG = "MyAidlService";

    private static void log(String message) {
        Log.e(TAG, message);
    }

    private IBinder mBinder = new IMyAidlInterface.Stub() {

        @Override
        public MyParcelable receiveParcelable() throws RemoteException {
            return mMyParcelable;
        }

        @Override
        public void postParcelable(MyParcelable myParcelable) throws RemoteException {
            mMyParcelable = myParcelable;
        }
    };

    public MyAidlService() {
        log("MyAidlService()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
