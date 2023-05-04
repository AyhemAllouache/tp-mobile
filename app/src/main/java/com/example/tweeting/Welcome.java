package com.example.tweeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {
    ImageView myLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        myLogo = findViewById(R.id.logo2);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.myanim);
        myLogo.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);

    }
}