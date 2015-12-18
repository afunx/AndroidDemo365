package com.afunx.fragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment {

    private static final String TAG = "MyFragment";

    private static void log(String msg) {
        Log.e(TAG, msg);
    }

    @Override
    public void onAttach(Activity activity) {
        log("onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        log("onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        log("onCreateView()");
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        log("onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        log("onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        log("onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        log("onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        log("onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        log("onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        log("onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        log("onDetach()");
        super.onDetach();
    }

}
