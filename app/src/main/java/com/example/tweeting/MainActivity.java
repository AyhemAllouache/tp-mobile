package com.example.tweeting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add_tweet);
        recyclerView = findViewById(R.id.myView);
        List<Notes> notes = new ArrayList<>();
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(currentDate);
//        notes.add(new Notes("hello world","Ayhem","2023",R.drawable.ayhem));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();

                // Inflate the dialog layout
                View dialogView = inflater.inflate(R.layout.form, null);


                EditText setTweet = dialogView.findViewById(R.id.inputTweet);

                // Set the dialog view
                builder.setView(dialogView);

                // Set the dialog title
//                builder.setTitle("ADD Note");

                // Set the positive button action
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the entered text from the edit text
                        String text = setTweet.getText().toString();
                        notes.add(new Notes(text,"Ayhem","2023",R.drawable.ayhem));
                        recyclerView.setLayoutManager(new LinearLayoutManager((MainActivity.this)));
                        recyclerView.setAdapter(new NotesAdapter(notes));
                        // Show a toast with the entered text
                        Toast.makeText(MainActivity.this, "Text entered: " + text, Toast.LENGTH_SHORT).show();
                    }
                });

                // Set the negative button action
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                });
                builder.show();

            }
        });

    }
}