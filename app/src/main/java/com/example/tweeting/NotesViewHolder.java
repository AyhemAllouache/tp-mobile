package com.example.tweeting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PublicKey;

public class NotesViewHolder extends RecyclerView.ViewHolder {
    public TextView note;
    public TextView user;
    public TextView date;
    public ImageView image;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }
    public void findViews(View view){
        note = (TextView)view.findViewById(R.id.noteText);
        user = (TextView)view.findViewById(R.id.user);
        date = (TextView)view.findViewById(R.id.date);
        image = (ImageView)view.findViewById(R.id.logo);
    }
    public void setItem(final Notes notes){
        note.setText(notes.getNote());
        user.setText(notes.getUser());
        date.setText((CharSequence) notes.getTweetDate());
        image.setImageResource(notes.getIdImage());
    }
}
