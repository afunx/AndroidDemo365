package com.afunx.broadcastsimpleusage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static void log(String tag, String msg) {
        Log.e(tag, msg);
    }

    private class MyInnerBroadReceiver extends BroadcastReceiver {

        private static final String TAG = "MyInnerBroadReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            log(TAG, "onReceive()");
        }
    }

    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init broadcast and intent filter
        mBroadcastReceiver = new MyInnerBroadReceiver();
        IntentFilter intentFilter = new IntentFilter("MY_BROADCAST_ACTION");
        intentFilter.addCategory("MY_BROADCAST_CATEGORY");
        // register broadcast
        registerReceiver(mBroadcastReceiver, intentFilter);
        // send broadcast
        Intent intent = new Intent("MY_BROADCAST_ACTION");
        intent.addCategory("MY_BROADCAST_CATEGORY");
        sendBroadcast(intent);
        log(TAG, "sendBroadcast()");
    }

    @Override
    protected void onDestroy() {
        // unregister broadcast
        unregisterReceiver(mBroadcastReceiver);
        super.onDestroy();
    }
}
