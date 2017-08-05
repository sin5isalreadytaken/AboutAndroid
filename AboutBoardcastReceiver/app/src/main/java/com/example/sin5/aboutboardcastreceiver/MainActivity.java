package com.example.sin5.aboutboardcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sendBtn).setOnClickListener(this);
        findViewById(R.id.registerBtn).setOnClickListener(this);
        findViewById(R.id.unregisterBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendBtn:
//                Intent i = new Intent(this, MyReceiver.class);
                Intent i = new Intent(MyReceiver.ACTION);
                i.putExtra("data", "boardcastreceiver");
//                sendBroadcast(i);
                sendOrderedBroadcast(i, null);
                break;
            case R.id.registerBtn:
                if (receiver == null){
                    receiver = new MyReceiver();
                    registerReceiver(receiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.unregisterBtn:
                if (receiver != null){
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;
        }
    }
    private MyReceiver receiver;
}
