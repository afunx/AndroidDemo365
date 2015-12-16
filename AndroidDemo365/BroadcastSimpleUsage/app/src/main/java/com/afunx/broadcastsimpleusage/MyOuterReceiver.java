package com.afunx.broadcastsimpleusage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyOuterReceiver extends BroadcastReceiver {

    private static final String TAG = "MyOuterReceiver";

    private static void log(String tag, String msg) {
        Log.e(tag, msg);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        log(TAG, "onReceive()");
    }
}
