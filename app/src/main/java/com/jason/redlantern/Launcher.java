package com.jason.redlantern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.hoang8f.widget.FButton;

public class Launcher extends AppCompatActivity {

    Button btnLogin, btnSignUp, btnGuest;
    boolean loggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        btnLogin = (FButton)findViewById(R.id.btnLogin);
        btnSignUp = (FButton)findViewById(R.id.btnSignUp);
        btnGuest = (FButton)findViewById(R.id.btnGuest);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(Launcher.this, Login.class);
                startActivity(login);

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(Launcher.this, SignUp.class);
                startActivity(signUp);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Launcher.this, Main.class);
                startActivity(home);
            }
        });

    }
}
