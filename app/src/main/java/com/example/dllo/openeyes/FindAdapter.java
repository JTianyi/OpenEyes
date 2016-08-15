package com.example.dllo.openeyes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.selection.PicassoInstance;
import com.youth.banner.Banner;
import java.util.ArrayList;

/**
 * Created by mac on 16/8/12.
 */
public class FindAdapter extends BaseAdapter {
    private ArrayList<FindBean> beanArrayList;
    private Context context;
    private final int TYPE_BANNER = 0,TYPE_SQUARE = 1,TYPE_RECTANGLE =2,TYPE_COUNT = 3;
    private String []bannerImgUrls = {"","","",""};

    public FindAdapter(Context context) {
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<FindBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_BANNER;
        }else if(position==2){
            return TYPE_RECTANGLE;
        }else {
            return TYPE_SQUARE;
        }
    }

    @Override
    public int getCount() {
        return beanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FindSquareHolder squareHolder = null;
        FindRectangleHolder rectangleHolder = null;
        FindBannerHolder bannerHolder = null;
        int type = getItemViewType(position);
        if (convertView ==null){
            switch (type){
                case TYPE_BANNER:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_find_banner,parent,false);
                    bannerHolder = new FindBannerHolder(convertView);
                    convertView.setTag(bannerHolder);
                    break;
                case TYPE_RECTANGLE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_find_rectangle,parent,false);
                    rectangleHolder = new FindRectangleHolder(convertView);
                    convertView.setTag(rectangleHolder);
                    break;
                case TYPE_SQUARE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_find_square,parent,false);
                    squareHolder = new FindSquareHolder(convertView);
                    convertView.setTag(squareHolder);
                    break;
            }
        }else {
            switch (type){
                case TYPE_BANNER:
                    bannerHolder = (FindBannerHolder) convertView.getTag();
                    break;
                case TYPE_RECTANGLE:
                    rectangleHolder = (FindRectangleHolder) convertView.getTag();
                    break;
                case TYPE_SQUARE:
                    squareHolder = (FindSquareHolder) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case TYPE_BANNER:
                for (int i = 0; i < beanArrayList.get(position).getItemList().get(0).getData().getBannerList().size(); i++) {
                 bannerImgUrls[i] = beanArrayList.get(position).getItemList().get(0).getData().getBannerList().get(i).getData().getImage();
                }
                //设置指示器(小圆点)
                bannerHolder.banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
                //设置位置
                bannerHolder.banner.setIndicatorGravity(Banner.CENTER);
                bannerHolder.banner.setImages(bannerImgUrls);
                break;
            case TYPE_RECTANGLE:
                PicassoInstance.getsInstance().setImage(beanArrayList.get(position).getItemList().get(3).getData().,rectangleHolder.rectangleIv);
                break;
            case TYPE_SQUARE:
                PicassoInstance.getsInstance().setImage(NetUrls.FIND_URL,squareHolder.findSquareIv);
                for (int i = 0; i < beanArrayList.get(position).getItemList().size(); i++) {
                squareHolder.findSquareTv.setText(beanArrayList.get(position).getItemList().get(i).getData());

                }
        }
        return convertView;
    }
    class FindSquareHolder {
        private ImageView findSquareIv;
        private TextView findSquareTv;
        public FindSquareHolder(View view) {
            findSquareIv = (ImageView) view.findViewById(R.id.find_square_iv);
            findSquareTv = (TextView) view.findViewById(R.id.find_square_tv);
        }
    }
    class FindRectangleHolder{
        private ImageView rectangleIv;
        public FindRectangleHolder(View view) {
            rectangleIv = (ImageView) view.findViewById(R.id.find_rectangle_iv);
        }
    }
    class FindBannerHolder{
        private Banner banner;
        public FindBannerHolder(View view) {
            banner = (Banner) view.findViewById(R.id.find_banner);
        }
    }
}
