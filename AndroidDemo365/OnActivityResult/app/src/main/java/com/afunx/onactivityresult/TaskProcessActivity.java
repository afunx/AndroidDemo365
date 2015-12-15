package com.afunx.onactivityresult;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class TaskProcessActivity extends Activity {

    private static final String TAG = "TaskProcessActivity";

    private static void log(String msg) {
        Log.e(TAG, msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_process);
        processRequest();
        finish();
    }

    private void processRequest() {
        int resultCode = 2;
        log("setResult() resultCode = " + resultCode);
        setResult(resultCode);
    }
}
