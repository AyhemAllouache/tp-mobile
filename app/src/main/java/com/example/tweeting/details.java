package com.example.tweeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class details extends AppCompatActivity {
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String user = getIntent().getStringExtra("user");
        String content = getIntent().getStringExtra("content");
        String date = getIntent().getStringExtra("date");
        TextView user1 =findViewById(R.id.username) ,content1=findViewById(R.id.content),date1 =findViewById(R.id.pub_date);
        user1.setText(user);
        content1.setText(content);
        date1.setText(date);

        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
        Button btn = findViewById(R.id.voice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    t1.speak(content,TextToSpeech.QUEUE_FLUSH,null);
                }

        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        t1.stop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        t1.stop();
    }
}