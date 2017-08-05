package com.example.sin5.activitystartmodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baty);

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(String.format("TaskID: %d\ncurrent activity id: %s", getTaskId(), toString()));
        findViewById(R.id.startb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BAty.this, BAty.class));
            }
        });

        findViewById(R.id.startself).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BAty.this, MainActivity.class));
            }
        });

    }
}
