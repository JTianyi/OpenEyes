package com.example.dllo.openeyes.tools;

import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by mac on 16/8/15.
 * 获取空间高度工具类
 * @author wangweijian
 */
public class ModuleUtilsInstance {
    private static ModuleUtilsInstance sModuleUtilsInstance;
    private int height;
    private int width;

    public static ModuleUtilsInstance getsInstance(){
        if (sModuleUtilsInstance == null){
            synchronized (ScreenUtilsInstance.class){
                if (sModuleUtilsInstance == null){
                    sModuleUtilsInstance =new ModuleUtilsInstance();
                }
            }
        }
        return sModuleUtilsInstance;
    }
    public int getModuleHeight(final View view){
        final ViewTreeObserver vto = view.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
//                vto.removeOnPreDrawListener(this);
                height = view.getMeasuredHeight();
                return true;
            }
        });
        return height;
    }
    public int getModuleWidth(final View view){
        final ViewTreeObserver vto = view.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
//                vto.removeOnPreDrawListener(this);
                width = view.getMeasuredWidth();
                return true;
            }
        });
        return width;
    }


}
