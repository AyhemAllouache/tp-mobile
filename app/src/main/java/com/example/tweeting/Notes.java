package com.example.tweeting;

import java.util.Date;

public class Notes {
    String note,user;
    String tweetDate;
    int idImage;

    public Notes(String note,String user, String tweetDate, int idImage) {
        this.note = note;
        this.user = user;
        this.tweetDate = tweetDate;
        this.idImage = idImage;
    }

    public String getNote() {
        return note;
    }

    public String getUser() {
        return user;
    }

    public String getTweetDate() {
        return tweetDate;
    }

    public int getIdImage() {
        return idImage;
    }
}
