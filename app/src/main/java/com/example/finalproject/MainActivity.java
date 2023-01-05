package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText _txtUser, _txtPass;
    Button _btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        _txtPass=(EditText) findViewById(R.id.txtPass);
        _txtUser=(EditText) findViewById(R.id.txtUser);
        _btnLogin=(Button) findViewById(R.id.btnLogin);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_txtUser.getText().toString().equals("admin") && _txtPass.getText().toString().equals("admin")){
                    Intent intent = new Intent(MainActivity.this, admin.class);
                    startActivity(intent);
                }else if(_txtUser.getText().toString().equals("user") && _txtPass.getText().toString().equals("user")){
                    Intent intent = new Intent(MainActivity.this, user.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}