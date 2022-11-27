package com.example.group_10.Chat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group_10.R;

public class OpenProfile extends AppCompatActivity {

    private TextView textName;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_profile);

        user = getIntent().getExtras().get("user_name").toString();

        textName = (TextView) findViewById(R.id.displayName);
        textName.setText(user);


    }

}
