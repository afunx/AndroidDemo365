package com.afunx.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * when tap back:
 * 12-13 14:35:08.865  21858-21858/com.afunx.activitylifecycle E/MainActivity﹕ 1. onCreate()
 * 12-13 14:35:08.869  21858-21858/com.afunx.activitylifecycle E/MainActivity﹕ 2. onStart()
 * 12-13 14:35:08.869  21858-21858/com.afunx.activitylifecycle E/MainActivity﹕ 4. onResume()
 * 12-13 14:35:12.975  21858-21858/com.afunx.activitylifecycle E/MainActivity﹕ 5. onPause()
 * 12-13 14:35:13.315  21858-21858/com.afunx.activitylifecycle E/MainActivity﹕ 7. onStop()
 * 12-13 14:35:13.315  21858-21858/com.afunx.activitylifecycle E/MainActivity﹕ 9. onDestroy()
 * <p/>
 * when tap home and then come back to the Activity:
 * 12-13 14:35:51.110  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 1. onCreate()
 * 12-13 14:35:51.122  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 2. onStart()
 * 12-13 14:35:51.122  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 4. onResume()
 * 12-13 14:36:01.728  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 5. onPause()
 * 12-13 14:36:01.732  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 6. onSaveInstanceState()
 * 12-13 14:36:01.732  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 7. onStop()
 * 12-13 14:36:10.265  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 8. onRestart()
 * 12-13 14:36:10.266  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 2. onStart()
 * 12-13 14:36:10.267  22242-22242/com.afunx.activitylifecycle E/MainActivity﹕ 4. onResume()
 * <p/>
 * when change language:
 * 12-13 14:37:18.303  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 1. onCreate()
 * 12-13 14:37:18.310  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 2. onStart()
 * 12-13 14:37:18.310  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 4. onResume()
 * 12-13 14:37:21.325  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 5. onPause()
 * 12-13 14:37:21.328  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 6. onSaveInstanceState()
 * 12-13 14:37:21.328  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 7. onStop()
 * 12-13 14:37:44.426  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 9. onDestroy()
 * 12-13 14:37:44.429  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 1. onCreate()
 * 12-13 14:37:44.429  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 1.1 onCreate() savedInstanceState data: content
 * 12-13 14:37:44.432  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 2. onStart()
 * 12-13 14:37:44.432  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 3. onRestoreInstanceState() data: content
 * 12-13 14:37:44.432  22994-22994/com.afunx.activitylifecycle E/MainActivity﹕ 4. onResume()
 */
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private void log(String msg) {
        Log.e(TAG, msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("1. onCreate()");
        if (savedInstanceState != null) {
            log("1.1 onCreate() savedInstanceState data: " + savedInstanceState.getString("data"));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        log("2. onStart()");
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        log("3. onRestoreInstanceState() data: " + savedInstanceState.get("data"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        log("4. onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        log("5. onPause()");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        log("6. onSaveInstanceState()");
        outState.putString("data", "content");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        log("7. onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        log("8. onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        log("9. onDestroy()");
        super.onDestroy();
    }
}
