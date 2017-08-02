package com.example.a123.pandatv.widget.manager;


import android.database.sqlite.SQLiteDatabase;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.widget.manager.green.Collect;
import com.example.a123.pandatv.widget.manager.green.DaoManger;
import com.example.a123.pandatv.widget.manager.green.DaoMaster;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Dbmanager {
    private static Dbmanager dbmanager;
    private Dbmanager(){}

    public static Dbmanager  getInstance(){

        if(dbmanager==null) {
            synchronized (Dbmanager.class){
                if(dbmanager==null) {
                    dbmanager=new Dbmanager();
                }
            }

        }
        return dbmanager;

    }
       public  void insert(Collect s){
           SQLiteDatabase write = DaoManger.getInstance(App.context).write();
           DaoMaster daoMaster=new DaoMaster(write);
           daoMaster.newSession().insert(s);
       }


    public  void insert(String title,String text,String playtime,String url,String image,boolean fase ){
        Collect collect=new Collect();
        collect.setImage(image);
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前时间
        playtime = sdf.format(date);
        collect.setPlaytime(playtime);
        collect.setTitle(title);
        collect.setText(text);
        collect.setFase(fase);
        collect.setUrl(url);
        insert(collect);
    }

    public  void delete(Collect s){
        SQLiteDatabase write = DaoManger.getInstance(App.context).write();
        DaoMaster daoMaster=new DaoMaster(write);
        daoMaster.newSession().delete(s);
    }
    public   void updete(Collect collect){
        SQLiteDatabase write = DaoManger.getInstance(App.context).write();
        DaoMaster daoMaster=new DaoMaster(write);
        daoMaster.newSession().update(collect);
    }
    public  List<Collect> list (){
        SQLiteDatabase reader = DaoManger.getInstance(App.context).reader();
           DaoMaster daoMaster=new DaoMaster(reader);
            List<Collect> arraylist = daoMaster.newSession().getCollectDao().queryBuilder().list();

        return arraylist;
    }
}
