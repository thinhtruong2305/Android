package com.example.intentexplicitmodauapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondaryActivity extends AppCompatActivity {
    Button btnSecondary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        btnSecondary = (Button) findViewById(R.id.buttonSecondary);

        btnSecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondaryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "Secondary onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "Secondary onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "Secondary onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "Secondary onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "Secondary onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "Secondary onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "Secondary onRestart");
    }
}