package com.example.sin5.aboutlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        System.out.println("general log");
//        System.err.println("error log");
        Log.e(TAG, "error");
        Log.w(TAG, "warnging");
        Log.i(TAG, "info");
        Log.d(TAG, "debug");
        Log.v(TAG, "tips");
    }
}
