package com.danielgranass.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SigninFailed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faild_signin);
        Button btn_back = findViewById(R.id.back);
        btn_back.setOnClickListener(View -> goBackToMain());

        Intent intent = getIntent();
        String valueUserName = intent.getStringExtra("Username");
        String valueUserPassword = intent.getStringExtra("Password");
    }

    private void goBackToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}