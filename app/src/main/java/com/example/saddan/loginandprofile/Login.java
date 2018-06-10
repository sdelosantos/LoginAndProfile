package com.example.saddan.loginandprofile;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import data.UserResource;

public class Login extends AppCompatActivity {
    // CONTROLLERS
    private Button btnLogin;
    public EditText txtUserEmail;
    public EditText txtUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtUserEmail = (EditText)findViewById(R.id.UserEmail);
        txtUserPassword = (EditText)findViewById(R.id.UserPassword);
    }

    // LOGIN CLICK
    public  void btnLogin_Click(View v){
        try {
            String email = txtUserEmail.getText().toString();
            String pass = txtUserPassword.getText().toString();

            int id = UserResource.Login(email,pass);
            if(id>0){
                Intent profile = new Intent(this, UserProfile.class);
                profile.putExtra("UserID",String.valueOf(id));
                startActivity(profile);
            }else{
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Wrong password or email [User:deadpool@test.com, password:123456]");
                dlgAlert.setTitle("Login Fail");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.create().show();
            }
        }
        catch (Exception ex){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage(ex.getMessage().toString());
            dlgAlert.setTitle("Error");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.create().show();
        }
    }
}
