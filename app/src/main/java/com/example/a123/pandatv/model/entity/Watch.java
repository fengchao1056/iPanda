package com.example.a123.pandatv.model.entity;


import java.io.Serializable;
import java.util.ArrayList;

public class Watch implements Serializable {
    private int time;
    private String total;
    ArrayList<Bean> list = new ArrayList<>();

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Bean> getList() {
        return list;
    }

    public void setList(ArrayList<Bean> list) {
        this.list = list;
    }

    public static class Bean implements Serializable{
        private String pid;
        private String tid;
        private String message;
        private String author;
        private String authorId;
        private String dateline;
        private String locale;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorId() {
            return authorId;
        }

        public void setAuthorId(String authorId) {
            this.authorId = authorId;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }
    }
}
