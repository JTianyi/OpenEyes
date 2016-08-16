package com.example.dllo.openeyes.tools;

import android.widget.ImageView;

import com.example.dllo.openeyes.app.App;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/15.
 */
public class PicassoInstance {
    private static PicassoInstance sPicasso;
    public static PicassoInstance getsInstance(){
        if (sPicasso == null){
            synchronized (PicassoInstance.class){
                if (sPicasso == null){
                    sPicasso =new PicassoInstance();
                }
            }
        }
        return sPicasso;
    }
    public void setImage(String url, ImageView iv){
        Picasso.with(App.getContext())
                .load(url)
                .into(iv);
    }



}
