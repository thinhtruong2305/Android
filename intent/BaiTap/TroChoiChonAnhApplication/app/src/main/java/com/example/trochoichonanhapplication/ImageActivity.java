package com.example.trochoichonanhapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class ImageActivity extends AppCompatActivity {
    //thuộc tính view
    TableLayout myTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        anhXa();

        thucHien();
    }

    private void anhXa(){
        myTableLayout = (TableLayout) findViewById(R.id.tableLayoutImage);
    }

    private void thucHien(){
        int soDong = 6;
        int soCot = 3;

        Collections.shuffle(MainActivity.arrayName);
        for(int i = 0; i < soDong; i++){
            TableRow tableRow = new TableRow(this);
            for(int j = 0; j < soCot; j++){
                //Tạo View hình và layout param để điều chỉnh chiều dai và cao. Set vào imageView
                ImageView imageView = new ImageView(this);
                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 95, r.getDisplayMetrics());
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);

                //Lấy hình theo vị trí
                int viTri = soCot * i + j ;
                if(viTri < MainActivity.arrayName.size()){
                    int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(viTri), "drawable", getPackageName());
                    imageView.setImageResource(idHinh);

                    //Add view vừa có vào tableRow
                    tableRow.addView(imageView);

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.putExtra("tenHinhChon", MainActivity.arrayName.get(viTri));
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    });
                }
            }
            //Add tableRow vừa có vào tableLayout
            myTableLayout.addView(tableRow);
        }
    }
}