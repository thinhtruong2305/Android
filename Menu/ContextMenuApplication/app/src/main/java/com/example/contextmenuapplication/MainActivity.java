package com.example.contextmenuapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    Button btnChonMau;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        //Đăng kí view cho context
        registerForContextMenu(btnChonMau);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Chọn màu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        suKienChonItemMenu(item.getItemId());
        return super.onContextItemSelected(item);
    }

    //Phương thức
    private void anhXa(){
        btnChonMau = (Button) findViewById(R.id.buttonChonMau);
        manHinh = (ConstraintLayout) findViewById(R.id.contraintLayoutManHinh);
    }

    private void suKienChonItemMenu(int id){
        if(id == R.id.menuVang)
            manHinh.setBackgroundColor(Color.YELLOW);
        if(id == R.id.menuDo)
            manHinh.setBackgroundColor(Color.RED);
        if(id == R.id.menuXanhDuong)
            manHinh.setBackgroundColor(Color.BLUE);
    }
}