package com.example.thuchanhdrawableapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    EditText edtHoTen, edtEmail, edtsoDienThoai;
    Button btnXacNhan;
    TextView txtThongTin;

    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        thucHien();
    }

    //Phương thức
    private void anhXa(){
        //Edit text
        edtHoTen = (EditText) findViewById(R.id.editTextHoTen);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtsoDienThoai = (EditText) findViewById(R.id.editTextSoDienThoai);
        //Button
        btnXacNhan = (Button) findViewById(R.id.buttonXacNhan);
        //text view
        txtThongTin = (TextView) findViewById(R.id.textViewThongTin);
    }
    private void thucHien(){
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String soDienThoai = edtsoDienThoai.getText().toString().trim();
                txtThongTin.setText(getString(R.string.text_chaoBan) + ": " + hoTen +
                        "\n" + getString(R.string.text_email) + ": " + email +
                        "\n" + getString(R.string.text_soDienThoai) + ": " + soDienThoai);
            }
        });
    }
}