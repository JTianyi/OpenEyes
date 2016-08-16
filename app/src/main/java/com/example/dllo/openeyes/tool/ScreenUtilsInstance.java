package com.example.dllo.openeyes.tool;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by mac on 16/8/15.
 * 获取屏幕高度工具类  单位px
 * @author wangweijian
 */
public class ScreenUtilsInstance {
    private static ScreenUtilsInstance sScreenUtilsInstance;
    public static ScreenUtilsInstance getsInstance(){
        if (sScreenUtilsInstance == null){
            synchronized (ScreenUtilsInstance.class){
                if (sScreenUtilsInstance == null){
                    sScreenUtilsInstance =new ScreenUtilsInstance();
                }
            }
        }
        return sScreenUtilsInstance;
    }
    public  int getScreenHeight (Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
    public  int getScreenWidth (Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

}
