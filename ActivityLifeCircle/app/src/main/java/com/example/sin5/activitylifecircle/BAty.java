package com.example.sin5.activitylifecircle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BAty extends AppCompatActivity {
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baty);
        System.out.println("b create");
        TextView tv = (TextView) findViewById(R.id.textView);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
//        User user = (User)i.getSerializableExtra("user");
        User user = i.getParcelableExtra("user");
        System.out.println(String.format("Name:%s Name1:",bundle.getString("name", "noexist"),bundle.getString("name1", "noexist")));
        tv.setText(user.getName() + user.getAge());

        et = (EditText) findViewById(R.id.editText);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data", et.getText().toString());
                setResult(1,i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("b start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("b resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("b pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("b stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("b restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("b destroy");
    }
}
