package com.example.sin5.aboutservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent;
    private EditText etData;
    private MyService.Binder binder;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, MyService.class);

        etData = (EditText) findViewById(R.id.etData);
        tv = ( TextView) findViewById(R.id.tvOut);

        findViewById(R.id.startbutton).setOnClickListener(this);
        findViewById(R.id.stopbutton).setOnClickListener(this);
        findViewById(R.id.bindbutton).setOnClickListener(this);
        findViewById(R.id.unbindbutton).setOnClickListener(this);
        findViewById(R.id.syncbutton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startbutton:
                intent.putExtra("data", etData.getText().toString());
                startService(intent);
                break;
            case R.id.stopbutton:
                stopService(intent);
                break;
            case R.id.bindbutton:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbindbutton:
                unbindService(this);
                break;
            case R.id.syncbutton:
                if (binder != null){
                    binder.setData(etData.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("bind success");
        binder = (MyService.Binder) service;
        binder.getService().setCallback(new MyService.Callback() {
            @Override
            public void onDataChange(String str) {
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data", str);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv.setText(msg.getData().getString("data"));
        }
    };
}
