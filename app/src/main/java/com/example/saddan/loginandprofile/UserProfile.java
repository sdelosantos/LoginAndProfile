package com.example.saddan.loginandprofile;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import data.User;
import data.UserResource;

public class UserProfile extends AppCompatActivity {

    TextView txtUserName;
    TextView txtUserEmail;
    TextView txtFollower;
    TextView txtFollowing;
    TextView txtCantFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        txtUserName  = (TextView)findViewById(R.id.UserName);
        txtUserEmail = (TextView)findViewById(R.id.UserEmail);
        txtFollower  = (TextView)findViewById(R.id.followers);
        txtFollowing = (TextView)findViewById(R.id.following);
        txtCantFotos = (TextView)findViewById(R.id.photos);


    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            // GET USER INFO
            String id = getIntent().getExtras().getString("UserID");
            int UserId = Integer.parseInt(id);
            User user = UserResource.getUserById(UserId);

            // SET VALUES
            txtUserName.setText(user.name);
            txtUserEmail.setText(user.email);
            txtFollower.setText(String.valueOf(user.cantFollower));
            txtFollowing.setText(String.valueOf(user.cantFollowing));
            txtCantFotos.setText(String.valueOf(user.cantPhotos));
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
