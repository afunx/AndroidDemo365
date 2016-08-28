package com.afunx.activitylaunchmode.demos;

import android.content.Context;

import com.afunx.activitylaunchmode.activities.Action;
import com.afunx.activitylaunchmode.activities.ActivityA;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public class StandModeTestcase {
    public static void demo0(Context context){

        // A
        Action actionA = new Action(-1, ActivityA.class);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionA);
        ModeTestcaseUtil.execute(context, actionList);
        // it will crash
//        ModeTestcaseUtil.execute(context.getApplicationContext(),actionList);
    }
}
