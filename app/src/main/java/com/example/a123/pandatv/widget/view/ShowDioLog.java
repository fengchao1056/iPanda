package com.example.a123.pandatv.widget.view;


import android.app.Dialog;
import android.content.Context;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.widget.manager.ToastManager;

public class ShowDioLog  {
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
     if(loadDialog!=null&&loadDialog.isShowing()) {
         loadDialog.dismiss();
     }else {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(3000);
                 } catch (InterruptedException e) {
                     loadDialog.dismiss();
                 }

                 loadDialog.dismiss();
                 App.context.runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         ToastManager.show("似乎没有网络了");
                     }
                 });
             }
         }).start();

     }


     return this;
 }

}
