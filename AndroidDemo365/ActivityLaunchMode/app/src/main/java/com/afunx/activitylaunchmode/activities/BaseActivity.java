package com.afunx.activitylaunchmode.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.afunx.activitylaunchmode.R;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public abstract class BaseActivity extends Activity{

    protected abstract String getTag();

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(getTag(), "onNewIntent()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(getTag());

        Log.i(getTag(), "onCreate()");
        ArrayList<Action> actionList = getIntent().getParcelableArrayListExtra(Action.KEY_ACTION_LIST);
//        Log.i(getTag(), "onCreate():"+actionList);
        if (actionList!=null && !actionList.isEmpty()){
            Action action = actionList.remove(0);
            action.execute(this,actionList);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getTag(), "onDestroy()");
//        ArrayList<Action> actionList = getIntent().getParcelableArrayListExtra("actionList");
//        Log.i(getTag(), "onDestroy():"+actionList);
    }
}
