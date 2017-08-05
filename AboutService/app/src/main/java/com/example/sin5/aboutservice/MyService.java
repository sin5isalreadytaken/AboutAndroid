package com.example.sin5.aboutservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.telecom.Call;
import android.view.SoundEffectConstants;

public class MyService extends Service {
    private boolean running;
    private String data = "kong";

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
//        return new Binder();
        return new IMyAidlInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String data) throws RemoteException {
                MyService.this.data = data;
            }
        };
    }
    public class Binder extends android.os.Binder{
        public void setData(String data){
            MyService.this.data = data;
        }

        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        running = true;
        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while(running){
                    i++;
                    String str = i + ":" + data;
                    System.out.println(str);
                    if (callback != null){
                        callback.onDataChange(str);
                    }
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
    }

    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public interface Callback{
        void onDataChange(String str);
    }
}
