package com.example.trochoichonanhapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //thuộc tính View
    ImageView imgGoc, imgNhan;
    TextView txtDiem;

    //thuộc tính lưu
    SharedPreferences sharedPreferences;

    //thuộc tính khác
    public static ArrayList<String> arrayName;
    int REQUEST_CODE_IMAGE = 123;
    private String tenHinhGoc;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        thucHien();
    }

    private void anhXa(){
        imgGoc = (ImageView) findViewById(R.id.imageViewGoc);
        imgNhan = (ImageView) findViewById(R.id.imageViewNhan);
        txtDiem = (TextView) findViewById(R.id.textViewDiem);

        sharedPreferences = getSharedPreferences("DiemSoGame", MODE_PRIVATE);
        total = sharedPreferences.getInt("luuDiem", 0);
        txtDiem.setText(total + "");

        //lấy mảng tên ảnh
        String[] nameArray = getResources().getStringArray(R.array.listName);
        arrayName = new ArrayList<>(Arrays.asList(nameArray));
        doiHinhGoc();
    }

    private void doiHinhGoc(){
        //trộn mảng và lấy giá trị 4 tương ứng ở mảng là vị trí 3
        Collections.shuffle(arrayName);
        tenHinhGoc = arrayName.get(4);
        int idHinh = getResources().getIdentifier(tenHinhGoc, "drawable", getPackageName());

        //lấy idHinh vừa tìm được gán vô imgGoc
        imgGoc.setImageResource(idHinh);
    }

    private void thucHien(){
        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dùng để lấy thông tin từ một activity khác thông qua intent và request
                startActivityForResult(new Intent(MainActivity.this, ImageActivity.class), REQUEST_CODE_IMAGE);
            }
        });
    }

    //Dùng để lưu điểm số khi người chơi thoát ra
    private void luuDiem(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("luuDiem", total);
        editor.commit();
    }

    //Lấy thông tin đã có từ một activity khác dựa trên các param
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null){
            String tenHinhNhan = data.getStringExtra("tenHinhChon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan, "drawable", getPackageName());
            imgNhan.setImageResource(idHinhNhan);

            if(tenHinhGoc.equals(tenHinhNhan)) {
                Toast.makeText(MainActivity.this, "Chính xác 0v0 + 10 điểm", Toast.LENGTH_SHORT).show();
                total += 10;
                luuDiem();
                new CountDownTimer(2000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        doiHinhGoc();
                    }
                }.start();
            }else{
                Toast.makeText(MainActivity.this, "Sai rồi UvU trừ 5 điểm", Toast.LENGTH_SHORT).show();
                total -= 5;
                luuDiem();
            }
        }
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_CANCELED){
            Toast.makeText(MainActivity.this, "Bạn chưa chọn gì \n Bạn muốn thoát ra xem lại chứ gì !!! -15 điểm", Toast.LENGTH_SHORT).show();
            total -= 15;
            luuDiem();
        }
        txtDiem.setText(total+"");
        super.onActivityResult(requestCode, resultCode, data);
    }

    //Tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Bắt sự kiện chọn item của menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuReload){
            doiHinhGoc();
        }
        return super.onContextItemSelected(item);
    }
}