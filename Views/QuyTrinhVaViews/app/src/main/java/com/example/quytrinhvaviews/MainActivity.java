package com.example.quytrinhvaviews;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Thuộc Tính (attribute)
    TextView txtNoiDung;
    Button btnClickMe;


    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hienThi();
    }

    //Method
    public void hienThi(){
        //ánh xạ
        txtNoiDung = findViewById(R.id.textViewNoiDung);
        btnClickMe = findViewById(R.id.buttonClickMe);
        //Viết code
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNoiDung.setText("Anime");
            }
        });
    }
}