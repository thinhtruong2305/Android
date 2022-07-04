package com.example.truyennhanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private TextView txtChuoi, txtSo, txtMang, txtDoiTuong, txtBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        anhXa();
        thucHien();
    }

    private void anhXa(){
        txtChuoi = (TextView) findViewById(R.id.textViewKetQuaChuoi);
        txtSo = (TextView) findViewById(R.id.textViewKetQuaSo);
        txtMang = (TextView) findViewById(R.id.textViewKetQuaMang);
        txtDoiTuong = (TextView) findViewById(R.id.textViewKetQuaDoiTuong);
        txtBundle = (TextView) findViewById(R.id.textViewKetQuaBundle);
    }

    private void thucHien() {
        Intent intent = getIntent();

        String chuoi = intent.getStringExtra("duLieuChuoi");
        txtChuoi.append(chuoi);

        int so = intent.getIntExtra("duLieuSo", 0);
        txtSo.append("" + so);

        String[] mang = intent.getStringArrayExtra("duLieuMang");
        StringBuilder strMang = new StringBuilder();
        for(int i = 0; i < mang.length; i++){
            strMang.append(mang[i].toString() + " ");
        }
        txtMang.append(strMang);

        HocSinh hocSinh = (HocSinh) intent.getSerializableExtra("duLieuDoiTuong");
        txtDoiTuong.append(hocSinh.getTen() + " - " + hocSinh.getNgaySinh());

        Bundle bundle = intent.getBundleExtra("duLieuBundle");
        if(bundle != null){
            String chuoiBundle = bundle.getString("chuoi");
            int soBundle = bundle.getInt("so");
            String[] mangBundle = bundle.getStringArray("mang");
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < mangBundle.length; i++){
                str.append(mangBundle[i].toString() + " ");
            }
            HocSinh hocSinhBundle = (HocSinh) bundle.getSerializable("doiTuong");
            txtBundle.append(   chuoiBundle + "\n"
                                + "               " + soBundle + "\n"
                                + "               " + str + "\n"
                                + "               " + hocSinhBundle.getTen() + " - " + hocSinhBundle.getNgaySinh());

        }
    }
}