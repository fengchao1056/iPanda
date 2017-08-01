package com.example.a123.pandatv.widget.manager.green;


import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Collect implements Parcelable {
    @Id(autoincrement = true)
    private Long Id;
     private String title;
    private String text;
    private String playtime;
    private String image;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.Id);
        dest.writeString(this.title);
        dest.writeString(this.text);
        dest.writeString(this.playtime);
        dest.writeString(this.image);
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPlaytime() {
        return this.playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collect() {
    }

    protected Collect(Parcel in) {
        this.Id = (Long) in.readValue(Long.class.getClassLoader());
        this.title = in.readString();
        this.text = in.readString();
        this.playtime = in.readString();
        this.image = in.readString();
    }

    @Generated(hash = 1724424149)
    public Collect(Long Id, String title, String text, String playtime, String image) {
        this.Id = Id;
        this.title = title;
        this.text = text;
        this.playtime = playtime;
        this.image = image;
    }

    public static final Parcelable.Creator<Collect> CREATOR = new Parcelable.Creator<Collect>() {
        @Override
        public Collect createFromParcel(Parcel source) {
            return new Collect(source);
        }

        @Override
        public Collect[] newArray(int size) {
            return new Collect[size];
        }
    };
}
