package com.example.menukhoitaoapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Sự kiện chọn item trên menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.suKienChonItemMenu(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    private void suKienChonItemMenu(int id){
        if(id == R.id.menuFind)
            Toast.makeText(MainActivity.this,"Bạn chọn Find",Toast.LENGTH_LONG).show();
        if(id == R.id.menuShare)
            Toast.makeText(MainActivity.this,"Bạn chọn Share",Toast.LENGTH_LONG).show();
        if(id == R.id.menuSetting)
            Toast.makeText(MainActivity.this,"Bạn chọn Setting",Toast.LENGTH_LONG).show();
        if(id == R.id.menuContact)
            Toast.makeText(MainActivity.this,"Bạn chọn Contact và có 2 cách contact bên trong",Toast.LENGTH_LONG).show();
        if(id == R.id.menuChildContactEmail)
            Toast.makeText(MainActivity.this,"Bạn chọn Contact bằng Email",Toast.LENGTH_LONG).show();
        if(id == R.id.menuChildContactPhone)
            Toast.makeText(MainActivity.this,"Bạn chọn Contact bằng Phone",Toast.LENGTH_LONG).show();
    }
}