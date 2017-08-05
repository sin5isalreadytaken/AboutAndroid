package com.example.sin5.aboutintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sin5 on 2016/5/18.
 */
public class MyAty extends Activity {
    public static final String ACTION = "com.example.sin5.aboutintent.intent.action.MyAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);

        findViewById(R.id.gotobaidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")));
            }
        });

    }
}
