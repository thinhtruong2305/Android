package com.example.radiobuttonapplication;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Thuộc tính
    RadioGroup radioGroupTime;
    RadioButton rdSang, rdTrua, rdToi;
    Button btnXacNhan;

    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        thucHien();
    }

    //Method
    public void anhXa(){
        radioGroupTime = findViewById(R.id.radioGroupTime);
        rdSang = findViewById(R.id.radioButtonSang);
        rdTrua = findViewById(R.id.radioButtonTrua);
        rdToi = findViewById(R.id.radioButtonToi);
        btnXacNhan = findViewById(R.id.buttonXacNhan);
    }
    public void thucHien(){
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buoi = "Giờ là";
                if(rdSang.isChecked())
                    buoi += " buổi sáng";
                if(rdTrua.isChecked())
                    buoi += " buổi trưa";
                if(rdToi.isChecked())
                    buoi += " buổi tối";
                Toast.makeText(MainActivity.this, buoi, Toast.LENGTH_LONG).show();
            }
        });
    }
}