package com.example.checkboxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Thuộc tính
    CheckBox ckbAndroid, ckbIOS, ckbJava;
    Button btnXacNhan;

    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        thucHien();
    }

    //method
    public void anhXa(){
        ckbAndroid =(CheckBox) findViewById(R.id.checkBoxAndroid);
        ckbIOS =(CheckBox) findViewById(R.id.checkBoxIOS);
        ckbJava =(CheckBox) findViewById(R.id.checkBoxJava);
        btnXacNhan =(Button) findViewById(R.id.buttonXacNhan);
    }
    public void thucHien(){
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = "Bạn chọn môn học:";
                if(ckbAndroid.isChecked()){
                    monHoc += " Android";
                }
                if(ckbIOS.isChecked()){
                    monHoc += " IOS";
                }
                if(ckbJava.isChecked()){
                    monHoc += " Java";
                }
                Toast.makeText(MainActivity.this, monHoc, Toast.LENGTH_LONG).show();
            }
        });
    }
}