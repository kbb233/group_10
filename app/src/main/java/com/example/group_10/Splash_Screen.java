package com.example.group_10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {
    //show the image for 2s
    private static int WELCOME_SCREEN_TIMEOUT = 1500;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the full screen windows to show the image
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);

        //create an animation to the image, alpha value from 1 to 0.
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        //fade out start at 0.5s and last for 1s
        fadeOut.setStartOffset(500);
        fadeOut.setDuration(1000);
        ImageView image = findViewById(R.id.welcome_pic);
        image.setAnimation(fadeOut);

        //after 1.5s, intent to the main page
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash_Screen.this,MainActivity.class);
            startActivity(intent);
            finish();
        },WELCOME_SCREEN_TIMEOUT);
    }
}
