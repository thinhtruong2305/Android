package com.example.intentexplicitmodauapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = (Button) findViewById(R.id.button);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "Main onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "Main onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "Main onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "Main onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "Main onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "Main onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "Main onRestart");
    }
}