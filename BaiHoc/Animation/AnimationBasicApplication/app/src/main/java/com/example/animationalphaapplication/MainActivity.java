package com.example.animationalphaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //thuộc tính View
    ImageView imgAlpha, imgRotate, imgScale, imgTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAlpha = (ImageView) findViewById(R.id.imageViewAlpha);
        imgRotate = (ImageView) findViewById(R.id.imageViewRotate);
        imgScale = (ImageView) findViewById(R.id.imageViewScale);
        imgTranslate = (ImageView) findViewById(R.id.imageViewTranslate);

        Animation animationAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        Animation animationRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);

        imgAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationAlpha);
            }
        });
        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationRotate);
            }
        });
        imgScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationScale);
            }
        });
        imgTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationTranslate);
            }
        });
    }
}