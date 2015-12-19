package com.afunx.fragmentsimpleusage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnPrevious;
    private Button mBtnNext;
    private String mFragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // init view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init button
        mBtnPrevious = (Button) findViewById(R.id.btn_previous);
        mBtnPrevious.setOnClickListener(this);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);

        flipFirstFragment();
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnPrevious) {
            flipFragment(false);
        } else if (v == mBtnNext) {
            flipFragment(true);
        }
    }

    private void flipFirstFragment() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        mFragmentTag = "A";
        transaction.add(R.id.framelayout, new FragmentA());
        transaction.commit();
    }

    private void updateFragmentTag(boolean isNext) {
        if (isNext) {
            if (mFragmentTag.equals("A")) {
                mFragmentTag = "B";
            } else if (mFragmentTag.equals("B")) {
                mFragmentTag = "C";
            } else if (mFragmentTag.equals("C")) {
                mFragmentTag = "A";
            } else {
                throw new IllegalStateException();
            }
        } else {
            if (mFragmentTag.equals("A")) {
                mFragmentTag = "C";
            } else if (mFragmentTag.equals("B")) {
                mFragmentTag = "A";
            } else if (mFragmentTag.equals("C")) {
                mFragmentTag = "B";
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private Fragment getFragment() {
        if (mFragmentTag.equals("A")) {
            return new FragmentA();
        } else if (mFragmentTag.equals("B")) {
            return new FragmentB();
        } else if (mFragmentTag.equals("C")) {
            return new FragmentC();
        } else {
            throw new IllegalStateException();
        }
    }

    private void flipFragment(boolean isNext) {
        FragmentManager manager = getFragmentManager();
        updateFragmentTag(isNext);
        Fragment newFragment = getFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.framelayout, newFragment);
        transaction.commit();
    }

}
