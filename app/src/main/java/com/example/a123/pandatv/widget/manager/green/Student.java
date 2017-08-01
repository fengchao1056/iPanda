package com.example.a123.pandatv.widget.manager.green;


public class Student {
    private String title;
    private String text;
    private String playtime;
    private String image;

    public Student(String title, String text, String playtime, String image) {
        this.title = title;
        this.text = text;
        this.playtime = playtime;
        this.image = image;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", playtime='" + playtime + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
