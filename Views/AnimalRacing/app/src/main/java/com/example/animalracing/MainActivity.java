package com.example.animalracing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    TextView txtDiem;
    CheckBox ckbAnimal1, ckbAnimal2, ckbAnimal3;
    SeekBar skbAnimal1, skbAnimal2, skbAnimal3;
    ImageButton imgBtnPlay;
    int soDiem = 100;

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
        //textView
        txtDiem = findViewById(R.id.textViewDiem);
        //Check box
        ckbAnimal1 = findViewById(R.id.checkBoxAnimal1);
        ckbAnimal2 = findViewById(R.id.checkBoxAnimal2);
        ckbAnimal3 = findViewById(R.id.checkBoxAnimal3);
        //SeekBar
        skbAnimal1 = findViewById(R.id.seekBarAnimal1);
        skbAnimal2 = findViewById(R.id.seekBarAnimal2);
        skbAnimal3 = findViewById(R.id.seekBarAnimal3);
        //image button
        imgBtnPlay = findViewById(R.id.imageButtonPlay);
    }
    public void thucHien(){
        txtDiem.setText(soDiem + "");
        //Đểm ngược thời gian
        CountDownTimer timer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random = new Random();
                int numAnimal1 = random.nextInt(number);
                int numAnimal2 = random.nextInt(number);
                int numAnimal3 = random.nextInt(number);
                //Kiểm tra win
                if(skbAnimal1.getProgress() >= skbAnimal1.getMax()) {
                    this.onFinish();
                    Toast.makeText(MainActivity.this,"Animal One Win", Toast.LENGTH_LONG).show();
                    if(ckbAnimal1.isChecked())
                        soDiem += 15;
                    txtDiem.setText(soDiem + "");
                }
                if(skbAnimal2.getProgress() >= skbAnimal2.getMax()) {
                    this.onFinish();
                    Toast.makeText(MainActivity.this,"Animal Two Win", Toast.LENGTH_LONG).show();
                    if(ckbAnimal2.isChecked())
                        soDiem += 15;
                    txtDiem.setText(soDiem + "");
                }
                if(skbAnimal3.getProgress() >= skbAnimal3.getMax()) {
                    this.onFinish();
                    Toast.makeText(MainActivity.this,"Animal Three Win", Toast.LENGTH_LONG).show();
                    if(ckbAnimal3.isChecked())
                        soDiem += 15;
                    txtDiem.setText(soDiem + "");
                }
                //seekbar progress
                skbAnimal1.setProgress(skbAnimal1.getProgress() + numAnimal1);
                skbAnimal2.setProgress(skbAnimal2.getProgress() + numAnimal2);
                skbAnimal3.setProgress(skbAnimal3.getProgress() + numAnimal3);
            }

            @Override
            public void onFinish() {
                this.cancel();
                soDiem -= 5;
                enabled();
            }
        };
        //Nhấn nút
        imgBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thongBao = "Đặt cược đi thằng lồn";
                if(ckbAnimal1.isChecked() || ckbAnimal2.isChecked() || ckbAnimal3.isChecked()){
                    disabled();
                    skbAnimal1.setProgress(0);
                    skbAnimal2.setProgress(0);
                    skbAnimal3.setProgress(0);
                    timer.start();
                    thongBao = "";
                }
                Toast.makeText(MainActivity.this, thongBao, Toast.LENGTH_LONG).show();
            }
        });
        //Check box check
        ckbAnimal1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ ckbAnimal2.setChecked(false); ckbAnimal3.setChecked(false);}
            }
        });
        ckbAnimal2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ ckbAnimal1.setChecked(false); ckbAnimal3.setChecked(false);}
            }
        });
        ckbAnimal3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ ckbAnimal2.setChecked(false); ckbAnimal1.setChecked(false);}
            }
        });
    }
    public void enabled(){
        //image button
        imgBtnPlay.setEnabled(true);
        //CheckBox
        ckbAnimal1.setEnabled(true);
        ckbAnimal2.setEnabled(true);
        ckbAnimal3.setEnabled(true);
        //Seek bar
        skbAnimal1.setEnabled(true);
        skbAnimal2.setEnabled(true);
        skbAnimal3.setEnabled(true);
    }
    public void disabled(){
        //image button
        imgBtnPlay.setEnabled(false);
        //CheckBox
        ckbAnimal1.setEnabled(false);
        ckbAnimal2.setEnabled(false);
        ckbAnimal3.setEnabled(false);
        //Seek bar
        skbAnimal1.setEnabled(false);
        skbAnimal2.setEnabled(false);
        skbAnimal3.setEnabled(false);
    }
}