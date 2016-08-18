package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.FindNeedBean;
import com.example.dllo.openeyes.tools.PicassoInstance;

import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;

import java.util.ArrayList;

/**
 * Created by mac on 16/8/12.
 * 发现界面适配器
 *
 * @author wangweijian
 */
public class FindAdapter extends BaseAdapter {
    private ArrayList<FindNeedBean> beanArrayList;
    private Context context;

    public FindAdapter(Context context) {
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<FindNeedBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
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
        FindSquareHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find_square, parent, false);
            holder = new FindSquareHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (FindSquareHolder) convertView.getTag();
        }
        holder.findSquareTv.setText(beanArrayList.get(position).getNeedTitle());
        PicassoInstance.getsInstance().setImage(beanArrayList.get(position).getNeedImage(), holder.findSquareIv);
        //获取屏幕宽度
        int width = ScreenUtilsInstance.getsInstance().getScreenWidth(context);
        //将dp转换成px
        int px = DensityUtils.dp2px(context, 1.5f);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParams = holder.findSquareIv.getLayoutParams();
        //修改布局中的属性
        layoutParams.height = (width - px) / 2;
        layoutParams.width = (width - px) / 2;
        //重新设置修改后的布局给控件
        holder.findSquareIv.setLayoutParams(layoutParams);
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
