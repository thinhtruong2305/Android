package com.example.dataresultapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryActivity extends AppCompatActivity {
    //Thuộc tính
    EditText edtName;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        edtName = (EditText) findViewById(R.id.editTextName);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("Name", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}