package com.example.quiz;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;

public class AnimationClass {
    private ImageButton imageButton;

    private void getAnimation(){
        Animation animation = new AlphaAnimation(0,1);
        animation.setDuration(1);
        animation.setRepeatMode(1);
        animation.setInterpolator(new LinearInterpolator());
        imageButton.startAnimation(animation);
    }

    public void setButton(ImageButton imageButton){
        this.imageButton = imageButton;
        this.getAnimation();
    }
}
