package com.example.dllo.openeyes.selection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/13.
 */
public class SelectionLsAdapter extends BaseAdapter {
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> arrayList;
    private Context context;

    public SelectionLsAdapter(Context context) {
        this.context = context;
    }

    public SelectionLsAdapter setArrayList(ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SelectionLsHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selection_ls, parent, false);
            holder = new SelectionLsHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (SelectionLsHolder) convertView.getTag();
        }
        holder.durationTV.setText(arrayList.get(position).getDuration() + "");
        holder.typeTV.setText(arrayList.get(position).getCategory());
        holder.titleTV.setText(arrayList.get(position).getTitle());
        holder.bacIV.setImageResource(R.mipmap.ceshi);
        return convertView;
    }

    class SelectionLsHolder {
        private ImageView bacIV;
        private TextView titleTV, typeTV, durationTV;

        public SelectionLsHolder(View view) {
            bacIV = (ImageView) view.findViewById(R.id.selection_ls_bac_iv);
            titleTV = (TextView) view.findViewById(R.id.selection_ls_title_tv);
            typeTV = (TextView) view.findViewById(R.id.selection_ls_type_tv);
            durationTV = (TextView) view.findViewById(R.id.selection_ls_duration_tv);
        }


    }
}
