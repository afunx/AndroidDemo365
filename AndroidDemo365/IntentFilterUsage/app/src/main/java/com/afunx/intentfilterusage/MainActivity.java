package com.afunx.intentfilterusage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startFirstActivity();
//        startSecondActivity();
//        startThirdActivity();
    }

    // explicit start activity
    private void startFirstActivity(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    // implicit start activity by action
    private void startSecondActivity(){
        Intent intent = new Intent();
//        intent.setAction("com.afunx.action.explicit");
        intent.setAction("action");
//        intent.addCategory("category");
        // don't forget add <category android:name="android.intent.category.DEFAULT"/> in <intent-filter>
        // or Android System can't find the intent
        startActivity(intent);
        // Conclusion: intent action should be one of intent-filter, intent category should no more than of intent-filter
    }


    // implicit start activity by data
    private void startThirdActivity(){
        Intent intent = new Intent();
        intent.setType("video/mpeg");
        startActivity(intent);
    }
}
