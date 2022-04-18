package com.example.listviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //thuộc tính
    ListView lvMonHoc;
    Button btnThem, btnCapNhat, btnXoa;
    EditText edtTenMonHoc;

    private int viTri = -1;

    //Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> arrayCourse = new ArrayList<String>();
        arrayCourse.add("Android");
        arrayCourse.add("IOS");
        arrayCourse.add("Java");
        arrayCourse.add("ASP.NET");
        arrayCourse.add("C#");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        hienThi(arrayCourse, adapter);
        themMonHoc(arrayCourse, adapter);
        capNhatMonHoc(arrayCourse, adapter);
        xoaMonHoc(arrayCourse, adapter);
    }

    //method
    public void anhXa(){
        lvMonHoc = findViewById(R.id.listViewMonHoc);
        btnThem = findViewById(R.id.buttonThem);
        btnXoa = findViewById(R.id.buttonXoa);
        btnCapNhat = findViewById(R.id.buttonCapNhat);
        edtTenMonHoc = findViewById(R.id.editTextMonHoc);
    }

    public void hienThi(ArrayList<String> arrayCourse, ArrayAdapter adapter){
        lvMonHoc.setAdapter(adapter);
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtTenMonHoc.setText(arrayCourse.get(position));
                viTri = position;
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long click: " + position, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    public void themMonHoc(ArrayList<String> arrayCourse, ArrayAdapter adapter){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edtTenMonHoc.getText().toString();
                arrayCourse.add(monHoc);
                adapter.notifyDataSetChanged();
                edtTenMonHoc.setText(null);
            }
        });
    }

    public void capNhatMonHoc(ArrayList<String> arrayCourse, ArrayAdapter adapter){
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(viTri, edtTenMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                edtTenMonHoc.setText(null);
            }
        });
    }

    public void xoaMonHoc(ArrayList<String> arrayCourse, ArrayAdapter adapter){
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.remove(viTri);
                adapter.notifyDataSetChanged();
                edtTenMonHoc.setText(null);
            }
        });
    }
}