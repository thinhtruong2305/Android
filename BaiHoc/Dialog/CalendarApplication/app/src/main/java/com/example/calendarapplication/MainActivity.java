package com.example.calendarapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Thuộc tính
    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = (TextView) findViewById(R.id.textViewTime);
        Calendar calendar = Calendar.getInstance();

        //lấy hết
        txtTime.append(calendar.getTime() + "\n");

        //Ngày tháng năm
        txtTime.append(calendar.get(Calendar.DATE) + "\n");
        //Month này đếm từ 0 - 11 tượng trưng cho 12 tháng
        txtTime.append((calendar.get(Calendar.MONTH) + 1) + "\n");
        txtTime.append(calendar.get(Calendar.YEAR) + "\n");
        //Định dạng ngày
        SimpleDateFormat dinhDangNgay = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(dinhDangNgay.format(calendar.getTime()) + "\n");

        //Giờ phút giây
        txtTime.append(calendar.get(Calendar.HOUR) + "\n");
        //Này là hiển thị từ 0 - 23
        txtTime.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");
        txtTime.append(calendar.get(Calendar.MINUTE) + "\n");
        txtTime.append(calendar.get(Calendar.SECOND) + "\n");
        //Định dạng giờ
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("hh:mm:ss a");
        txtTime.append(dinhDangGio.format(calendar.getTime()) + "\n");
    }
}