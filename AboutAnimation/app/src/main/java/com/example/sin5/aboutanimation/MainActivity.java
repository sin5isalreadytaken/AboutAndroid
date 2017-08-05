package com.example.sin5.aboutanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.alphaanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlphaAnimation aa = new AlphaAnimation(0,1);
//                aa.setDuration(2000);
//                v.startAnimation(aa);

                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.aa));
            }
        });

        findViewById(R.id.rotateanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ra));
            }
        });

        findViewById(R.id.translateanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.ta));
            }
        });

        findViewById(R.id.scaleanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.sa));
            }
        });

        findViewById(R.id.setanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation a = AnimationUtils.loadAnimation(MainActivity.this, R.anim.seta);
                a.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "end", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Toast.makeText(MainActivity.this, "repeat", Toast.LENGTH_SHORT).show();
                    }
                });
                v.startAnimation(a);
            }
        });

        findViewById(R.id.customanimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAnimation ca = new CustomAnimation();
                ca.setDuration(1000);
                v.startAnimation(ca);
            }
        });
    }
}
