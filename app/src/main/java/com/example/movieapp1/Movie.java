package com.example.movieapp1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int img;
    private String title;
    private String desc;

    public Movie(int img, String title, String desc){
        this.img = img;
        this.title = title;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.title);
        dest.writeString(this.desc);
    }

    protected Movie(Parcel in) {
        this.img = in.readInt();
        this.title = in.readString();
        this.desc = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
