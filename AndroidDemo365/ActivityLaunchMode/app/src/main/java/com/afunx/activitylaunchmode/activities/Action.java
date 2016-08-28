package com.afunx.activitylaunchmode.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by afunx on 16-8-27.
 */
public class Action implements Parcelable{

    public static String KEY_ACTION_LIST = "actionList";

    private int mFlag;

    private Class mTarget;

    public int getFlag() {
        return mFlag;
    }

    public Class getTarget() {
        return mTarget;
    }

    public Action(int flag, Class target) {
        mFlag = flag;
        mTarget = target;
    }

    private Action(Parcel src) {
        mFlag = src.readInt();
        mTarget = (Class)src.readSerializable();
    }

    public void execute(Context context,ArrayList<? extends Parcelable> value) {
        Intent intent = new Intent(context, mTarget);
        if (mFlag != -1) {
            intent.addFlags(mFlag);
        }
        intent.putParcelableArrayListExtra(KEY_ACTION_LIST,value);
        context.startActivity(intent);
    }

    @Override
    public String toString() {
        return "[mFlag="+mFlag+",mTarget="+mTarget.getSimpleName()+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mFlag);
        dest.writeSerializable(mTarget);
    }

    public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() {

        @Override
        public Action createFromParcel(Parcel source) {
            return new Action(source);
        }

        @Override
        public Action[] newArray(int size) {
            return new Action[size];
        }
    };
}