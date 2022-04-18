package com.example.sharepreferenceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //thuộc tính View
    EditText edtTaiKhoan, edtmatKhau;
    CheckBox cbRemember;
    Button btnDangNhap;

    //thuộc tính lưu
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        thucHien();
    }

    private void anhXa() {
        edtTaiKhoan = (EditText) findViewById(R.id.editTextTaiKhoan);
        edtmatKhau = (EditText) findViewById(R.id.editTextMatKhau);
        cbRemember = (CheckBox) findViewById(R.id.checkBoxRemember);
        btnDangNhap = (Button) findViewById(R.id.buttonDangNhap);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        edtTaiKhoan.setText(sharedPreferences.getString("taiKhoan", ""));
        edtmatKhau.setText(sharedPreferences.getString("matKhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));
    }

    private void thucHien() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taiKhoan = edtTaiKhoan.getText().toString();
                String matKhau = edtmatKhau.getText().toString();
                if(taiKhoan.equals("thinh") && matKhau.equals("1234")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taiKhoan", taiKhoan);
                        editor.putString("matKhau", matKhau);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}