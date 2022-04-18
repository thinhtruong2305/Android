package com.example.gridviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    GridView gvHinhAnh;
    ArrayList<HinhAnhPandoru> arrayHinh;
    HinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        adapter = new HinhAnhAdapter(MainActivity.this, R.layout.dong_hinh_anh, arrayHinh);
        gvHinhAnh.setAdapter(adapter);

        thucHien();
    }

    public void anhXa(){
        gvHinhAnh = findViewById(R.id.gridViewPandoru);
        arrayHinh = new ArrayList<>();

        arrayHinh.add(new HinhAnhPandoru("Ảnh 1", R.drawable.download));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 2", R.drawable.download_1));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 3", R.drawable.download_2));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 4", R.drawable.download_3));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 5", R.drawable.download_4));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 6", R.drawable.download_5));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 7", R.drawable.images));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 8", R.drawable.images_1));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 9", R.drawable.images_2));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 10", R.drawable.images_3));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 11", R.drawable.images_4));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 12", R.drawable.images_5));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 13", R.drawable.images_6));
        arrayHinh.add(new HinhAnhPandoru("Ảnh 14", R.drawable.images_7));
    }

    public void thucHien(){
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayHinh.get(position).getTen(), Toast.LENGTH_LONG).show();
            }
        });
    }
}