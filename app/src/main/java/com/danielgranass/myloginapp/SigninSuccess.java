package com.danielgranass.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SigninSuccess extends AppCompatActivity {

    private TextView signTopic, yourUsername, yourPassword, textUsername, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_signin);

        signTopic = findViewById(R.id.signinTopic);
        yourUsername = findViewById(R.id.signin_yourUsername);
        yourPassword = findViewById(R.id.signin_yourPassword);
        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);
        Button back = findViewById(R.id.back);

        Intent intent = getIntent();
        String valueUserName = intent.getStringExtra("Username");
        String valueUserPassword = intent.getStringExtra("Password");
        textUsername.setText(valueUserName);
        textPassword.setText(valueUserPassword);
        back.setOnClickListener(view -> backToTheMain());
    }

    private void backToTheMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public TextView getSignTopic() {
        return signTopic;
    }

    public void setSignTopic(TextView signTopic) {
        this.signTopic = signTopic;
    }

    public TextView getYourUsername() {
        return yourUsername;
    }

    public void setYourUsername(TextView yourUsername) {
        this.yourUsername = yourUsername;
    }

    public TextView getYourPassword() {
        return yourPassword;
    }

    public void setYourPassword(TextView yourPassword) {
        this.yourPassword = yourPassword;
    }

    public TextView getTextUsername() {
        return textUsername;
    }

    public void setTextUsername(TextView textUsername) {
        this.textUsername = textUsername;
    }

    public TextView getTextPassword() {
        return textPassword;
    }

    public void setTextPassword(TextView textPassword) {
        this.textPassword = textPassword;
    }
}