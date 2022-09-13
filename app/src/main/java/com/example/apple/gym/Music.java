package com.example.apple.gym;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 献给我滴贝贝
 */
public class Music extends Activity {
    private ImageView imageView2;// 图片框
    private AnimationDrawable mAnimationDrawable; //图片动画实例


    //因为图片较少，直接卸载onCreate里
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.music);

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.my_animation);//设置资源

        mAnimationDrawable = (AnimationDrawable) imageView2.getDrawable();//获取
        mAnimationDrawable.setOneShot(false);//就一次



    }

    @Override
    protected void onStart() {
        startAnimation();
        super.onStart();
    }



    private void startAnimation() {
        mAnimationDrawable.start(); //启动动画
        //这里先试试静态的
        Animation transAni = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_SELF,0);

        transAni.setDuration(500);
        transAni.setRepeatCount(Animation.INFINITE);
        imageView2.startAnimation(transAni);
    }
}
