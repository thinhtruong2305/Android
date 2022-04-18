package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    ListView lvWaifu;
    ArrayList<Waifu> arrayWaifu;
    WaifuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        adapter = new WaifuAdapter(this, R.layout.dong_waifu, arrayWaifu);
        lvWaifu.setAdapter(adapter);
    }

    private void anhXa() {
        lvWaifu = findViewById(R.id.listViewWaifu);
        arrayWaifu = new ArrayList<>();

        arrayWaifu.add(new Waifu("Kurumi", "Là một người con gái nặng tình", R.drawable.kurumi_cute));
        arrayWaifu.add(new Waifu("Miku", "Là một cô ca sĩ ảo", R.drawable.miku));
        arrayWaifu.add(new Waifu("Yuno", "Một con yandere chính hiệu", R.drawable.yuno));
        arrayWaifu.add(new Waifu("Reina", "Một cô gái trong một bộ truyện r-18", R.drawable.reina));
        arrayWaifu.add(new Waifu("Mirai", "Một cô gái hậu đậu dễ thương", R.drawable.mirai));
        arrayWaifu.add(new Waifu("Kurumi", "Là một người con gái nặng tình", R.drawable.kurumi_cute));
        arrayWaifu.add(new Waifu("Miku", "Là một cô ca sĩ ảo", R.drawable.miku));
        arrayWaifu.add(new Waifu("Yuno", "Một con yandere chính hiệu", R.drawable.yuno));
        arrayWaifu.add(new Waifu("Reina", "Một cô gái trong một bộ truyện r-18", R.drawable.reina));
        arrayWaifu.add(new Waifu("Mirai", "Một cô gái hậu đậu dễ thương", R.drawable.mirai));
        arrayWaifu.add(new Waifu("Kurumi", "Là một người con gái nặng tình", R.drawable.kurumi_cute));
        arrayWaifu.add(new Waifu("Miku", "Là một cô ca sĩ ảo", R.drawable.miku));
        arrayWaifu.add(new Waifu("Yuno", "Một con yandere chính hiệu", R.drawable.yuno));
        arrayWaifu.add(new Waifu("Reina", "Một cô gái trong một bộ truyện r-18", R.drawable.reina));
        arrayWaifu.add(new Waifu("Mirai", "Một cô gái hậu đậu dễ thương", R.drawable.mirai));
    }
}