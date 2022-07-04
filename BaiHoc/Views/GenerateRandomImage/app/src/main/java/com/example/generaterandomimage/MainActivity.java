package com.example.generaterandomimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout manHinh;
    ArrayList<Integer> arrayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khaiBao();
        chuyenAnhNgauNhien();
    }

    public void khaiBao(){
        manHinh = findViewById(R.id.linearLayoutManHinh);
        arrayImage = new ArrayList<>();
        arrayImage.add(R.drawable.anh_nen);
        arrayImage.add(R.drawable.anh_nen_2);
        arrayImage.add(R.drawable.anh_nen_3);
    }
    public void chuyenAnhNgauNhien(){
        Random random = new Random();
        int viTri = random.nextInt(arrayImage.size());

        manHinh.setBackgroundResource(arrayImage.get(viTri));
    }
}