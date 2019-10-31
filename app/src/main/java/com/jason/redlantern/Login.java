package com.jason.redlantern;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jason.redlantern.Model.User;

import info.hoang8f.widget.FButton;

public class Login extends AppCompatActivity {

    EditText editPhone, editPass;
    Button btnLogin;

    public static final String LOGIN_BOOL = "com.jason.redlantern.loginbool";

    public boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editPhone = findViewById(R.id.editPhone);
        editPass = findViewById(R.id.editPass);
        btnLogin = (FButton)findViewById(R.id.btnLogin);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(Login.this);
                mDialog.setMessage("Please wait... ");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(editPhone.getText().toString()).exists()) {

                            mDialog.dismiss();

                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);

                            if (user.getPassword().equals(editPass.getText().toString())) {
                                loggedIn = true;

                                Intent home = new Intent(Login.this, Main.class);
                                home.putExtra(LOGIN_BOOL, loggedIn);
                                Common.currentUser = user;
                                startActivity(home);
                                finish();

                                Toast.makeText(Login.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Login.this, "Password Incorrect", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(Login.this, "User does not exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public boolean getLoggedIn () {
        return loggedIn;
    }
}
