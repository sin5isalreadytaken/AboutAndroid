package com.example.sin5.activitylifecircle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("create");
        tv = (TextView) findViewById(R.id.textView2);

        findViewById(R.id.startb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", "namestr");
                Intent i = new Intent(MainActivity.this, BAty.class);
                i.putExtras(bundle);
                i.putExtra("user", new User("a",10));
//                startActivity(i);
                startActivityForResult(i, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tv.setText(""+data.getStringExtra("data"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("destroy");
    }
}
