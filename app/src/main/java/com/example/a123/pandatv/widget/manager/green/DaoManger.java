package com.example.a123.pandatv.widget.manager.green;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DaoManger {
    private  static DaoMaster.DevOpenHelper helper;
    private static  DaoManger manger=null;
    public DaoManger(Context mcontext){
        helper=  new DaoMaster.DevOpenHelper(mcontext,"name1");
    }
    public  static   DaoManger getInstance(Context c){
        if(manger==null) {
            synchronized (DaoManger.class){
                if(manger==null) {
                    manger=new DaoManger(c);
                }
            }
        }
        return  manger;
    }
    public SQLiteDatabase write(){
        return helper.getWritableDatabase();
    }
    public SQLiteDatabase reader(){
        return helper.getReadableDatabase();
    }

}
