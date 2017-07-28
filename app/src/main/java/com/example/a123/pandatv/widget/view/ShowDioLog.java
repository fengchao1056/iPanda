package com.example.a123.pandatv.widget.view;


import android.app.Dialog;
import android.content.Context;

import com.example.a123.pandatv.R;

public class ShowDioLog {
    public  static ShowDioLog showDioLog;
    private ShowDioLog(){}
    private Dialog loadDialog;
    public static ShowDioLog getInstance(){
        if(showDioLog==null) {
            synchronized (ShowDioLog.class){
                if(showDioLog==null) {
                    showDioLog=new ShowDioLog();
                }
            }

        }
        return showDioLog;
    }
 public  ShowDioLog show(Context context){
      loadDialog=new Dialog(context, R.style.dialog);
      loadDialog.setContentView(R.layout.diolog);
     //点击外部是否关闭
     loadDialog.setCanceledOnTouchOutside(false);
     loadDialog.show();
     return this;

 }
 public ShowDioLog dismiss(){
     if(loadDialog!=null) {
         loadDialog.dismiss();
     }
     return this;
 }
}
