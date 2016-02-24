package com.afunx.aidlsimpleusage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.afunx.aidlsimpleusage.IMyAidlInterface;

/**
 * 02-24 23:38:10.341    2282-2282/com.afunx.aidlsimpleusage:remote E/MyAidlService﹕ MyAidlService()
 * 02-24 23:38:10.342    2282-2282/com.afunx.aidlsimpleusage:remote E/MyAidlService﹕ onBind()
 * 02-24 23:38:11.302    2282-2298/com.afunx.aidlsimpleusage:remote E/MyAidlService﹕ basicTypes anInt = 1, aLong = 2, aBoolean = false, aFloag = 3.0, aDouble = 4.0, aString = 5
 */
public class MyAidlService extends Service {

    private static final String TAG = "MyAidlService";

    private static void log(String message) {
        Log.e(TAG, message);
    }

    private IBinder mBinder = new IMyAidlInterface.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            log("basicTypes anInt = " + anInt + ", aLong = " + aLong + ", aBoolean = " + aBoolean + ", aFloag = " + aFloat + ", aDouble = " + aDouble
                    + ", aString = " + aString);
        }
    };


    public MyAidlService() {
        log("MyAidlService()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("onBind()");
        return mBinder;
    }
}
