package com.afunx.onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


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
        Intent intent = new Intent(this, TaskProcessActivity.class);
        int requestCode = 1;
        log("startActivityForResult() requestCode = " + requestCode);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        log("onActivityResult requestCode = " + requestCode + ", resultCode = " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
