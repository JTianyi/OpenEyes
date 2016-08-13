package com.example.dllo.openeyes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mac on 16/8/12.
 */
public class FindAdapter extends BaseAdapter {
    private ArrayList<FindBean> beanArrayList;
    private Context context;

    public FindAdapter(Context context) {
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<FindBean> beanArrayList) {
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
        FindHolder holder = null;
        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find,parent,false);
            holder = new FindHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (FindHolder) convertView.getTag();
        }
        Picasso.with(context).load(ImgUrls.FIND_URL).into(holder.findIv);
        return convertView;
    }
    class FindHolder {
        private ImageView findIv;
        private TextView findTv;
        public FindHolder(View view) {
            findIv = (ImageView) view.findViewById(R.id.find_iv);
            findTv = (TextView) view.findViewById(R.id.find_tv);
        }
    }
}
