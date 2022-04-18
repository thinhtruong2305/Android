package com.example.imageviewapplication;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    ImageView imgHinh;
    ImageButton imgButton;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        chuyenAnh();
    }

    //method
    public void anhXa(){
        imgHinh = findViewById(R.id.imageViewKurumiFace);
        manHinh = findViewById(R.id.manHinh);
        imgButton = findViewById(R.id.imageButtonKurumiFace);
    }
    public void chuyenAnh(){
        imgHinh.setImageResource(R.drawable.anh_kurumi_full_body);
        manHinh.setBackgroundResource(R.drawable.anh_nen);
    }
}