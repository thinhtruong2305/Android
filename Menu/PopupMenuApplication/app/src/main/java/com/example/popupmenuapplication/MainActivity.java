package com.example.popupmenuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        btnMenu = (Button) findViewById(R.id.buttonShowPopup);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    //Phương thức
    //Hiển thị menu
    private void showMenu(){
        PopupMenu menu = new PopupMenu(this, btnMenu);
        menu.getMenuInflater().inflate(R.menu.popup_menu, menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                suKienChonItemMenu(item.getItemId());
                return false;
            }
        });
        menu.show();
    }

    //lấy id menu để thực hiện sự kiện
    private void suKienChonItemMenu(int id){
        if(id == R.id.menuThem)
            btnMenu.setText("Menu Thêm");
        if(id == R.id.menuXoa)
            btnMenu.setText("Menu Xóa");
        if(id == R.id.menuCapNhat)
            btnMenu.setText("Menu Cập Nhật");
    }
}