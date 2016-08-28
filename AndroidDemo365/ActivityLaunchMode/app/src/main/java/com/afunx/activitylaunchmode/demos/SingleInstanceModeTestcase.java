package com.afunx.activitylaunchmode.demos;

import android.content.Context;

import com.afunx.activitylaunchmode.activities.Action;
import com.afunx.activitylaunchmode.activities.ActivityB;
import com.afunx.activitylaunchmode.activities.ActivityC;
import com.afunx.activitylaunchmode.activities.ActivitySingleInstance;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public class SingleInstanceModeTestcase {

    public static void demo0(Context context) {

        //ActivitySingleInstance B C ActivitySingleInstance-> B C ActivitySingleInstance
        // onCreateSingleInstance() onCreateB() onCreateC() onNewIntentSingleInstance()

        //ActivitySingleInstance
        Action actionActivitySingleInstance = new Action(-1,ActivitySingleInstance.class);
        Action actionB = new Action(-1, ActivityB.class);
        Action actionC = new Action(-1, ActivityC.class);
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(actionActivitySingleInstance);
        actionList.add(actionB);
        actionList.add(actionC);
        actionList.add(actionActivitySingleInstance);

        ModeTestcaseUtil.execute(context, actionList);
    }
}
