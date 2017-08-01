package com.example.a123.pandatv.widget.manager;


import android.database.sqlite.SQLiteDatabase;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.widget.manager.green.Collect;
import com.example.a123.pandatv.widget.manager.green.DaoManger;
import com.example.a123.pandatv.widget.manager.green.DaoMaster;

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


    public  void insert(String title,String text,String playtime,String image ){
        SQLiteDatabase write = DaoManger.getInstance(App.context).write();
        DaoMaster daoMaster=new DaoMaster(write);
        Collect collect=new Collect();
        collect.setImage(image);
        collect.setPlaytime(playtime);
        collect.setTitle(title);
        collect.setText(text);
        daoMaster.newSession().insert(collect);
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
    public  List<Collect> list(){
        SQLiteDatabase reader = DaoManger.getInstance(App.context).reader();
           DaoMaster daoMaster=new DaoMaster(reader);
        List<Collect> arraylist = daoMaster.newSession().getCollectDao().queryBuilder().list();
             arraylist.addAll(list());
        return arraylist;
    }
}
