package com.danielgranass.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordForgot extends AppCompatActivity {

    private EditText emailadress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgot);

        emailadress = findViewById(R.id.signin_entereMail);

        Button senden = findViewById(R.id.btnSend);
        Button backToMain = findViewById(R.id.btnBack);

        senden.setOnClickListener(view -> sendMail());
        backToMain.setOnClickListener(view -> getGoBackToMain());

    }

    private void getGoBackToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void sendMail(){
        String pw = "1234";
        String toAdrsss = emailadress.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{toAdrsss});
        intent.putExtra(Intent.EXTRA_TEXT, pw);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an eMail"));
    }
}