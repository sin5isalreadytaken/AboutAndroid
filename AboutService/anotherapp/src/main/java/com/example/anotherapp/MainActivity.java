package com.example.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sin5.aboutservice.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent;
    private EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
        intent.setComponent(new ComponentName("com.example.sin5.aboutservice", "com.example.sin5.aboutservice.MyService"));
        etData = (EditText) findViewById(R.id.etData);

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
                binder = null;
                break;
            case R.id.syncbutton:
                if (binder != null){
                    try {
                        binder.setData(etData.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("bind service");
        System.out.println(service);

        binder = IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
    private IMyAidlInterface binder = null;
}
