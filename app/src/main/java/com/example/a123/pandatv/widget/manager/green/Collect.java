package com.example.a123.pandatv.widget.manager.green;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Collect {
    @Id(autoincrement = true)
    private Long Id;
    private String title;
    private String text;
    private String playtime;
    private String image;
    private String url;
   private boolean fase;
@Generated(hash = 2080064959)
public Collect(Long Id, String title, String text, String playtime,
        String image, String url, boolean fase) {
    this.Id = Id;
    this.title = title;
    this.text = text;
    this.playtime = playtime;
    this.image = image;
    this.url = url;
    this.fase = fase;
}
@Generated(hash = 1726975718)
public Collect() {
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
public String getUrl() {
    return this.url;
}
public void setUrl(String url) {
    this.url = url;
}
public boolean getFase() {
    return this.fase;
}
public void setFase(boolean fase) {
    this.fase = fase;
}

}
