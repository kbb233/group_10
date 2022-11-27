package com.example.group_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group_10.Profile.CreateProfile;

public class ProfileActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            ProfileActivity.class.getSimpleName();
    EditText etName, etGradYear, etCurrentMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initChatbtn();
        initMainbtn();
        initEventbtn();

        etName = findViewById(R.id.editTextName);
        etGradYear = findViewById(R.id.editTextGradYear);
        etCurrentMe = findViewById(R.id.editText_currentMe);
        Button createProfile = findViewById(R.id.createProfile);
        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String year = etGradYear.getText().toString().trim();
                String currentMe = etCurrentMe.getText().toString().trim();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("year", year);
                bundle.putString("currentMe", currentMe);
                Intent intent = new Intent(ProfileActivity.this, CreateProfile.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void initMainbtn(){
        ImageButton mainbtn = findViewById(R.id.Main_Button);
        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    public void initEventbtn(){
        ImageButton eventbtn = findViewById(R.id.Event_Button);
        eventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,EventActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    public void initChatbtn(){
        ImageButton profilebtn = findViewById(R.id.Chat_Button);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,ChatActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}

