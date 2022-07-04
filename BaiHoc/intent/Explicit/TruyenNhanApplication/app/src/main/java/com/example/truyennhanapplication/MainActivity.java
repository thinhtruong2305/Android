package com.example.truyennhanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.buttonSendData);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Truyền nhận dữ liệu chuỗi
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                intent.putExtra("duLieuChuoi", "Trương Văn Tiến Thịnh");

                //Truyền nhận dữ liệu số
                intent.putExtra("duLieuSo", 2001);

                //Truyền nhận dữ liệu mảng có thể String array hoặc int array
                String[] mang = {"Android", "IOS"};
                intent.putExtra("duLieuMang", mang);

                //Truyền nhận dữ liệu đối tượng.
                //Lưu ý: lớp đối tượng phải implements Serializable để tránh lỗi.
                HocSinh hocSinh = new HocSinh("Thịnh", 2001);
                intent.putExtra("duLieuDoiTuong", hocSinh);

                //Truyền nhận dữ liệu bundle
                //Bundle như một xe tải đang chở hàng và có rất nhiều món hàng đa dạng kiểu dữ liệu
                Bundle bundle = new Bundle();

                bundle.putString("chuoi", "Trương Văn Tiến Thịnh");
                bundle.putInt("so", 2001);
                bundle.putStringArray("mang", mang);
                bundle.putSerializable("doiTuong", hocSinh);

                intent.putExtra("duLieuBundle", bundle);

                startActivity(intent);
            }
        });
    }
}