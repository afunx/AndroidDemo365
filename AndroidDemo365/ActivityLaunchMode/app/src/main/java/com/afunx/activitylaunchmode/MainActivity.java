package com.afunx.activitylaunchmode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.afunx.activitylaunchmode.demos.SingleInstanceModeTestcase;
import com.afunx.activitylaunchmode.demos.SingleTaskModeTestcase;
import com.afunx.activitylaunchmode.demos.SingleTopModeTestcase;
import com.afunx.activitylaunchmode.demos.StandModeTestcase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static final String STAND_MODE  = StandModeTestcase.class.getName();

    private static final String SINGLE_TOP_MODE = SingleTopModeTestcase.class.getName();

    private static final String SINGLE_TASK_MODE = SingleTaskModeTestcase.class.getName();

    private static final String SINGLE_INSTANCE_MODE = SingleInstanceModeTestcase.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finish();

        executeTestcase(SINGLE_INSTANCE_MODE,0);
    }

    private void executeTestcase(String launchMode,int caseValue){
        try {
            Class clazz = Class.forName(launchMode);
            Class[] argsClass = new Class[1];
            argsClass[0] = Context.class;
            Method method = clazz.getMethod("demo"+caseValue,argsClass);
            method.invoke(null,this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
