package com.example.switchapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch swtWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khaiBao();
        thucHien();
    }

    public void khaiBao(){
        swtWifi = findViewById(R.id.SwitchWifi);
    }
    public void thucHien(){
        swtWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Bạn đã mở wifi",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Bạn đã mở wifi",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}