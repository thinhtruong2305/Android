package com.example.propressbarapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    ProgressBar pbDownload;
    Button btnDownload;

    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        thucHien();
    }

    //method
    public void anhXa(){
        pbDownload = findViewById(R.id.progressBarDownload);
        btnDownload = findViewById(R.id.buttonDownload);
    }
    public void thucHien(){
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //10000 là 10 giây -> tổng thời gian đếm ngược
                //1000 là 1 giây -> thời gian lặp lại một hành động nào đó
                CountDownTimer timer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pbDownload.getProgress();
                        if(current >= pbDownload.getMax())
                            current = 0;
                        pbDownload.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this, "Hoàn thành", Toast.LENGTH_LONG).show();
                    }
                }.start();
            }
        });
    }
}