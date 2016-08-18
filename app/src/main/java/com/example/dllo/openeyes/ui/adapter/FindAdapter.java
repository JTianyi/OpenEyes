package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< HEAD

=======
>>>>>>> b59d63e94c0b4326fb05257b1804f2f8912d3ae3
import com.example.dllo.openeyes.model.bean.FindBean;
import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.tools.PicassoInstance;
<<<<<<< HEAD


import com.example.dllo.openeyes.tools.DensityUtils;

import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
=======
import com.squareup.picasso.Picasso;
import com.example.dllo.openeyes.tool.DensityUtils;
import com.example.dllo.openeyes.tool.ModuleUtilsInstance;
import com.example.dllo.openeyes.tool.ScreenUtilsInstance;
import java.util.ArrayList;
>>>>>>> b59d63e94c0b4326fb05257b1804f2f8912d3ae3

/**
 * Created by mac on 16/8/12.
 * 发现界面适配器
 */
public class FindAdapter extends BaseAdapter {
    private FindBean findBean;
    private Context context;

    public FindAdapter(Context context) {
        this.context = context;
    }

    public void setFindBean(FindBean findBean) {
        this.findBean = findBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return findBean.getItemList().size();
    }

    @Override
    public Object getItem(int position) {
        return findBean.getItemList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FindSquareHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find_square, parent, false);
            holder = new FindSquareHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (FindSquareHolder) convertView.getTag();
        }

        //如果位置大于3  则显示
//        if (position <4) {
//            //否则使其Gone
//            holder.findSquareIv.setVisibility(View.GONE);
//            holder.findSquareTv.setVisibility(View.GONE);

//        } else {
            holder.findSquareTv.setText(findBean.getItemList().get(position).getData().getTitle());
            PicassoInstance.getsInstance().setImage(findBean.getItemList().get(position).getData().getImage(), holder.findSquareIv);
            //获取屏幕宽度
            int width = ScreenUtilsInstance.getsInstance().getScreenWidth(context);
            //将dp转换成px
            int px = DensityUtils.dp2px(context,1.5f);
            //获取控件的布局
            ViewGroup.LayoutParams layoutParams = holder.findSquareIv.getLayoutParams();
            //修改布局中的属性
            layoutParams.height = (width - px) / 2;
            layoutParams.width = (width-px)/2;
            //重新设置修改后的布局给控件
            holder.findSquareIv.setLayoutParams(layoutParams);
//        if (position<4){
//            holder.findSquareIv.setVisibility(View.GONE);
//            holder.findSquareTv.setVisibility(View.GONE);
//        }
//        }
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

}
