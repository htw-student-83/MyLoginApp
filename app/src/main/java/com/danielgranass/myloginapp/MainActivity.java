package com.danielgranass.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Deklarieren von Variablen
    private EditText userName, userPassword;
    private TextView forgottenPassword;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisieren von Variablen

        userName = findViewById(R.id.username);
        userPassword = findViewById(R.id.password);
        forgottenPassword = findViewById(R.id.forgotPassword);
        Button confirmInput = findViewById(R.id.btn_confirm);

        //Eventlistiner einfügen
        confirmInput.setOnClickListener(view -> inputIsValid());
}

    private void inputIsValid(){

        if(validInput()){
            //An dieser Stelle soll ein Objekt der Seite SigninSuccess erzeugt und die Seite aufgerufen werdens
            intent = new Intent(this, SigninSuccess.class);
            EditText userNameInput = findViewById(R.id.username);
            EditText passwordInput = findViewById(R.id.password);
            String inputUsername = userNameInput.getText().toString();
            String inputPassword = passwordInput.getText().toString();
            intent.putExtra("Username", inputUsername);
            intent.putExtra("Password", inputPassword);
            startActivity(intent);
        }else{
            //An dieser Stelle soll ein Objekt der Seite Signinfailed erzeugt und die Seite aufgerufen werdens
            intent = new Intent(this, SigninFailed.class);
            startActivity(intent);
        }
    }

    private boolean validInput() {
        if(!userName.getText().toString().isEmpty() && !userPassword.getText().toString().isEmpty()){
            if(userName.getText().toString().equals("Daniel") && userPassword.getText().toString().equals("1234")){
                return true;
            }else{
                return false;
            }
        }
       return false;
    }


    public void forgottenPasswort(View view) {
        //An dieser Stelle soll ein Objekt der Seite Signinfailed erzeugt und die Seite aufgerufen werdens
        intent = new Intent(this, PasswordForgot.class);
        startActivity(intent);
    }

    public TextView getForgottenPassword() {
        return forgottenPassword;
    }

    public EditText getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(EditText userPassword) {
        this.userPassword = userPassword;
    }

    public EditText getUserName() {
        return userName;
    }

    public void setUserName(EditText userName) {
        this.userName = userName;
    }
}