package com.afunx.activitylaunchmode.demos;

import android.content.Context;
import android.content.Intent;

import com.afunx.activitylaunchmode.activities.Action;
import com.afunx.activitylaunchmode.activities.ActivityA;
import com.afunx.activitylaunchmode.activities.ActivityB;
import com.afunx.activitylaunchmode.activities.ActivityC;
import com.afunx.activitylaunchmode.activities.ActivitySingeTask;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public class SingleTaskModeTestcase {
    public static void demo0(Context context){

        // ABCA -> ABC
        Action actionA = new Action(Intent.FLAG_ACTIVITY_NEW_TASK, ActivityA.class);
        Action actionB = new Action(-1, ActivityB.class);
        Action actionC = new Action(-1, ActivityC.class);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionA);
        actionList.add(actionB);
        actionList.add(actionC);
        actionList.add(actionA);

        ModeTestcaseUtil.execute(context, actionList);
    }

    public static void demo1(Context context){

        // ABCA -> A
        // onCreateA() onCreateB() onCreateC() onCreateA() onDestroyA() onDestroyB() onDestroyC()
        Action actionA = new Action(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK, ActivityA.class);
        Action actionB = new Action(-1, ActivityB.class);
        Action actionC = new Action(-1, ActivityC.class);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionA);
        actionList.add(actionB);
        actionList.add(actionC);
        actionList.add(actionA);

        ModeTestcaseUtil.execute(context, actionList);
    }

    public static void demo2(Context context){

        //ActivitySingleTask B C ActivitySingleTask-> ActivitySingleTask
        // onCreateSingleTask() onCreateB() onCreateC() onNewIntentSingleTask() onDestroyB() onDestroyC()
        Action actionActivitySingleTask = new Action(-1,ActivitySingeTask.class);
        Action actionB = new Action(-1, ActivityB.class);
        Action actionC = new Action(-1, ActivityC.class);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionActivitySingleTask);
        actionList.add(actionB);
        actionList.add(actionC);
        actionList.add(actionActivitySingleTask);

        ModeTestcaseUtil.execute(context, actionList);
    }
}
