package com.example.tweeting;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Notes implements Parcelable {
    String note,user;
    String tweetDate;
    int idImage;

    public Notes(String note,String user, String tweetDate, int idImage) {
        this.note = note;
        this.user = user;
        this.tweetDate = tweetDate;
        this.idImage = idImage;
    }

    public Notes(Parcel in) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

    }
}
