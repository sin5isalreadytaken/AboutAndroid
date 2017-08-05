package com.example.sin5.aboutboardcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.example.sin5.aboutboardcastreceiver.intent.action.MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("got the message" + intent.getStringExtra("data"));
        abortBroadcast();
    }
}
