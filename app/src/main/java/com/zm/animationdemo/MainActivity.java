package com.zm.animationdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_text;
    Button btn;
    List<String> textList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = findViewById(R.id.tv_text);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAppearanceAnimation();
            }
        });

        textList.add("Hello World!");
        textList.add("Welcome to my blog!");
        textList.add("https://zhangmiao.cc");
        textList.add("Knowledge is power.");
        textList.add("Learn and live.");
        textList.add("可以不成功，但不可以不成长！");
        textList.add("加油💪");
    }

//
//
//    private void displayWholeAnimation() {
//        startAppearanceAnimation();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 1000);
//    }

    private void startAppearanceAnimation() {
        /**
         * 核心类 AnimationSet 顾名思义，可以简单理解为将多种动画放在一个set集合里面
         *    产生渐渐显示+位移动画
         *
         */
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -50.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setDuration(1000);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startDisappearanceAnimation();
                    }
                }, 1500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv_text.startAnimation(animationSet);
        int index = (int) (Math.random() * textList.size());
        tv_text.setText(textList.get(index));
    }

    private void startDisappearanceAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -50.0f, -100.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setDuration(1000);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startAppearanceAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv_text.startAnimation(animationSet);
    }

}
