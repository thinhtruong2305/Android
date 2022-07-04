package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Thuộc tính
    EditText edtHoVaTen;
    TextView txtDisplay;
    Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        edtHoVaTen = findViewById(R.id.editText_TextHoVaTen);
        txtDisplay = findViewById(R.id.textView_Display);
        btnDisplay = findViewById(R.id.button_ClickDisplay);
        //Thực hiện lệnh
        hienThiEditText();
    }

    //method
    public void hienThiEditText(){
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText(new StringBuilder().append("Hello").append(edtHoVaTen.getText().toString()).toString());
                Toast.makeText(MainActivity.this, edtHoVaTen.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}