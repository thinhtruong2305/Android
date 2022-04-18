package com.example.drawableclipapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgHinh;
    Button btnHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        ClipDrawable clipDrawable = (ClipDrawable) imgHinh.getDrawable();

        btnHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int currentLevel = clipDrawable.getLevel();
                        if(currentLevel > 10000)
                            currentLevel = 0;
                        imgHinh.setImageLevel(currentLevel + 1000);
                        handler.postDelayed(this,1000);
                    }
                }, 2000);}
        });
    }

    protected void anhXa(){
        imgHinh = (ImageView) findViewById(R.id.imageViewHinh);
        btnHinh = (Button) findViewById(R.id.buttonHinh);
    }
}