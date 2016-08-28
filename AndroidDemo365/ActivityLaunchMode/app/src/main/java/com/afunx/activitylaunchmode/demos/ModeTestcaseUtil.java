package com.afunx.activitylaunchmode.demos;

import android.content.Context;
import android.content.Intent;

import com.afunx.activitylaunchmode.activities.Action;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public class ModeTestcaseUtil {

    public static void execute(Context context, ArrayList<Action> actionList) {

        if (actionList.isEmpty()) {
            throw new RuntimeException("actionList.isEmpty()");
        }
        Action action = actionList.remove(0);
        int flag = action.getFlag();
        Class target = action.getTarget();

        Intent intent = new Intent(context,target);
        if (flag!=-1) {
            intent.addFlags(flag);
        }

        intent.putParcelableArrayListExtra(Action.KEY_ACTION_LIST, actionList);
        context.startActivity(intent);
    }
}
