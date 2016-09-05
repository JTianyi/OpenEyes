package com.example.dllo.openeyes.tools;

import android.widget.ImageView;

import com.example.dllo.openeyes.app.App;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

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
    public RequestCreator setImage(String url, ImageView iv){
        Picasso.with(App.getContext())
                .load(url)
                .skipMemoryCache()
                .resize(DensityUtils.dp2px(App.getContext(),200),DensityUtils.dp2px(App.getContext(),150))
               .centerCrop()
                .into(iv);
        return null;
    }



}
