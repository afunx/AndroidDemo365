package com.afunx.fragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


/**
 * 12-18 00:02:39.091  21253-21253/com.afunx.fragmentlifecycle E/MainActivity﹕      onCreate()
 * 12-18 00:02:39.105  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onAttach()
 * 12-18 00:02:39.105  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onCreate()
 * 12-18 00:02:39.105  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onCreateView()
 * 12-18 00:02:39.108  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onActivityCreated()
 * 12-18 00:02:39.109  21253-21253/com.afunx.fragmentlifecycle E/MainActivity﹕      onStart()
 * 12-18 00:02:39.109  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onStart()
 * 12-18 00:02:39.109  21253-21253/com.afunx.fragmentlifecycle E/MainActivity﹕      onResume()
 * 12-18 00:02:39.109  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onResume()
 * 12-18 00:02:41.496  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onPause()
 * 12-18 00:02:41.496  21253-21253/com.afunx.fragmentlifecycle E/MainActivity﹕      onPause()
 * 12-18 00:02:41.817  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onStop()
 * 12-18 00:02:41.817  21253-21253/com.afunx.fragmentlifecycle E/MainActivity﹕      onStop()
 * 12-18 00:02:41.817  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onDestroyView()
 * 12-18 00:02:41.817  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onDestroy()
 * 12-18 00:02:41.817  21253-21253/com.afunx.fragmentlifecycle E/MyFragment﹕    onDetach()
 * 12-18 00:02:41.817  21253-21253/com.afunx.fragmentlifecycle E/MainActivity﹕      onDestroy()
 */
public class MainActivity extends Activity {


    private static final String TAG = "MainActivity";

    private static void log(String msg) {
        Log.e(TAG, msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        log("onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        log("onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        log("onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        log("onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        log("onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        log("onDestroy()");
        super.onDestroy();
    }
}
