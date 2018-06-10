package com.example.saddan.loginandprofile;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import data.User;
import data.UserResource;

public class UserProfile extends AppCompatActivity {

    TextView txtUserName;
    TextView txtUserEmail;
    TextView txtFollower;
    TextView txtFollowing;
    TextView txtCantFotos;

    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        txtUserName  = (TextView)findViewById(R.id.UserName);
        txtUserEmail = (TextView)findViewById(R.id.UserEmail);
        txtFollower  = (TextView)findViewById(R.id.followers);
        txtFollowing = (TextView)findViewById(R.id.following);
        txtCantFotos = (TextView)findViewById(R.id.photos);
        currentUser = new User();

    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            // GET USER INFO
            String id = getIntent().getExtras().getString("UserID");
            int UserId = Integer.parseInt(id);
            currentUser = UserResource.getUserById(UserId);

            // SET VALUES
            txtUserName.setText(currentUser.name);
            txtUserEmail.setText(currentUser.email);
            txtFollower.setText(String.valueOf(currentUser.cantFollower));
            txtFollowing.setText(String.valueOf(currentUser.cantFollowing));
            txtCantFotos.setText(String.valueOf(currentUser.cantPhotos));
        }
        catch (Exception ex){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage(ex.getMessage().toString());
            dlgAlert.setTitle("Error");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.create().show();
        }
    }

    // LOGIN CLICK
    public  void btnShare_Click(View v){
        try {
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBodyText = currentUser.email;
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(intent, "Share Profile"));
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
