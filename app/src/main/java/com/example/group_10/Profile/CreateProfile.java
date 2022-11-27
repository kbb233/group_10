package com.example.group_10.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group_10.ProfileActivity;
import com.example.group_10.R;

public class CreateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String year = bundle.getString("year");
            String currentMe = bundle.getString("currentMe");
            TextView tvName = findViewById(R.id.textView_name);
            TextView tvGradYear = findViewById(R.id.textView_gradYear);
            TextView tvCurrentMe = findViewById(R.id.textView_currentMe);
            tvName.setText(name);
            tvGradYear.setText(year);
            tvCurrentMe.setText(currentMe);
        }
    }

    public void Share(View view) {
        Intent intent = new Intent(this, ShareProfile.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}