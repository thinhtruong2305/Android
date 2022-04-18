package com.example.generaterandomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //Thuộc tính
    TextView txtDisplayNumber;
    Button btnRandomNumber;
    EditText edtMax;
    EditText edtMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        anhXa();
        // thực hiện
        randomNumber();
    }

    //method
    public void randomNumber(){
        btnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
               if(edtMax.length() == 0 || edtMin.length() == 0){
                   int number = (int) (Math.random() * 1000) / 10;
                   txtDisplayNumber.setText(new StringBuilder().append("The number is: ").append(number));
                   Toast.makeText(MainActivity.this,"Tự động random trong khoảng 100 - 0",Toast.LENGTH_SHORT).show();
               }else{
                   int max = Integer.parseInt(edtMax.getText().toString());
                   int min = Integer.parseInt(edtMin.getText().toString());
                   int number = random.nextInt(max - min + 1) + min;
                   txtDisplayNumber.setText(new StringBuilder().append("The number is: ").append(number));
               }
            }
        });
    }
    public void anhXa(){
        txtDisplayNumber = findViewById(R.id.textView_Number);
        btnRandomNumber = findViewById(R.id.buttonRandom);
        edtMax = findViewById(R.id.editTextMax);
        edtMin = findViewById(R.id.editTextMin);
    }
}