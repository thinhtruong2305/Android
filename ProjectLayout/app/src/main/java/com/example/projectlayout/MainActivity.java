package com.example.projectlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constrain_layout);
    }

    //information_main
    /*public void onBtnClick(View view){
        TextView txtHello = findViewById(R.id.textViewHello);
        EditText editTxt = findViewById(R.id.editTxtName);
        txtHello.setText("Hello "+editTxt.getText().toString());
    }

    public void onBtnRegisterClick(View view){
        TextView txtFirstName = findViewById(R.id.textViewFirstName);
        TextView txtLastName = findViewById(R.id.textViewLastName);
        TextView txtEmail = findViewById(R.id.textViewEmail);

        EditText editTxtFirstName = findViewById(R.id.editTextFirstName);
        EditText editTxtLastName = findViewById(R.id.editTextLastName);
        EditText editTxtEmail = findViewById(R.id.editTextPersonEmailAddress);

        txtFirstName.setText("First Name: " + editTxtFirstName.getText().toString());
        txtLastName.setText("Last Name: " + editTxtLastName.getText().toString());
        txtEmail.setText("Email: "+ editTxtEmail.getText().toString());
    }*/
}