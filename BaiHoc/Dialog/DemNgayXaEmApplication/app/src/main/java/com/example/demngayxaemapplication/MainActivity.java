package com.example.demngayxaemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText edtNgayThuNhat, edtNgayThuHai;
    private Button btnDemNgay;
    private TextView txtResult;
    private Calendar ngayThuNhat, ngayThuHai;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        thucHien();
    }

    private void anhXa(){
        edtNgayThuNhat = (EditText) findViewById(R.id.editTextNgayThuNhat);
        edtNgayThuHai = (EditText) findViewById(R.id.editTextNgayThuHai);
        btnDemNgay = (Button) findViewById(R.id.buttonDemNgay);
        txtResult = (TextView) findViewById(R.id.textViewKetQua);
    }

    private void thucHien(){
        edtNgayThuNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgayThuNhat();
            }
        });

        edtNgayThuHai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgayThuHai();
            }
        });

        btnDemNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ngayXaEm = (int) ((ngayThuHai.getTimeInMillis() - ngayThuNhat.getTimeInMillis()) / (1000 * 60 * 60 * 24));

                if(ngayXaEm < 0){
                    Toast.makeText(MainActivity.this, "Xin vui lòng nhập lại ngày thứ nhất", Toast.LENGTH_SHORT).show();
                }else{
                    txtResult.setText("Số ngày xa em: " + ngayXaEm);
                }
            }
        });
    }
    private void chonNgayThuNhat(){
        ngayThuNhat = Calendar.getInstance();
        int ngay = ngayThuNhat.get(Calendar.DATE);
        int thang = ngayThuNhat.get(Calendar.MONTH);
        int nam = ngayThuNhat.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ngayThuNhat.set(year, month, dayOfMonth);
                edtNgayThuNhat.setText(dateFormat.format(ngayThuNhat.getTime()));
            }
        }, nam, thang, ngay);

        datePickerDialog.show();
    }
    private void chonNgayThuHai(){
        ngayThuHai = Calendar.getInstance();
        int ngay = ngayThuHai.get(Calendar.DATE);
        int thang = ngayThuHai.get(Calendar.MONTH);
        int nam = ngayThuHai.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ngayThuHai.set(year, month, dayOfMonth);
                edtNgayThuHai.setText(dateFormat.format(ngayThuHai.getTime()));
            }
        }, nam, thang, ngay);

        datePickerDialog.show();
    }
}