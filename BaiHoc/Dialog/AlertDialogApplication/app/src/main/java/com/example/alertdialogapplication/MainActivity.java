package com.example.alertdialogapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrMonHoc;
    ArrayAdapter<String> adapter;
    ListView lvMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.listViewMonHoc);
        arrMonHoc = new ArrayList<String>();
        addArrayMonHoc();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrMonHoc);
        lvMonHoc.setAdapter(adapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                xacNhanXoa(position);
            }
        });
    }

    //Phương thức
    private void addArrayMonHoc(){
        arrMonHoc.add("Java");
        arrMonHoc.add("NodeJS");
        arrMonHoc.add("ASP.NET");
        arrMonHoc.add("C#");
        arrMonHoc.add("JavaScript");
    }

    private void xacNhanXoa(final int position){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Thông báo");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("Bạn chắc chắn có muốn xóa môn học này");

        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrMonHoc.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
}