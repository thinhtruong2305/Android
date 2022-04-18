package com.example.customdialogapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Thuộc tính MainActivity
    TextView txtLogin;
    //Thuộc tính của Dialog
    EditText edtUserName, edtPassWord;
    Button btnLogin, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXaMainActivity();

        thucHien();
    }

    //Phương thức
    //Ánh xạ các thành phần view của mainActivity
    private void anhXaMainActivity(){
        txtLogin = (TextView) findViewById(R.id.textViewLoginFormChinh);
    }

    //Ánh xạ các thành phần view của dialog
    private void anhXaDiaLog(Dialog dialog){
        edtUserName = (EditText) dialog.findViewById(R.id.editTextUserName);
        edtPassWord = (EditText) dialog.findViewById(R.id.editTextPassword);
        btnLogin = (Button) dialog.findViewById(R.id.buttonLogin);
        btnCancel = (Button) dialog.findViewById(R.id.buttonCancel);
    }

    //Hàm này để thực hiện các sự kiện của view trong mainActivity
    private void thucHien(){
        txtLogin.setOnClickListener(v -> dialogLogin());
    }
    //Hàm này để goi dialog
    private void dialogLogin(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.custom_dialog);

        anhXaDiaLog(dialog);
        thucHienDialog(dialog);

        dialog.show();
    }
    //Hàm này để thực hiện các sự kiện của thành phần view trong dialog
    private void thucHienDialog(Dialog dialog){
        btnLogin.setOnClickListener(v -> {
            if(edtUserName.getText().toString().trim().equals("Thinh") && edtPassWord.getText().toString().trim().equals("123"))
                Toast.makeText(MainActivity.this, R.string.text_login_success, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, R.string.text_login_fail, Toast.LENGTH_SHORT).show();
        });

        btnCancel.setOnClickListener(v -> {
            //dùng một trong hai
            //dialog.cancel();
            dialog.dismiss();
        });
    }
}