package com.example.sin5.aboutanimation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by sin5 on 2016/5/27.
 */
public class CustomAnimation extends Animation {
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
//        interpolatedTime = 3;
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime*30)*30), (float) (Math.cos(interpolatedTime*30)*30));

        super.applyTransformation(interpolatedTime, t);
    }
}
