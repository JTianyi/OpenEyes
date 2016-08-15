package com.example.dllo.openeyes.selection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.TitleTextView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/13.
 */
public class SelectionLsAdapter extends BaseAdapter {
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> arrayList;
    private Context context;
    private static final int TYPE_TEXT=0;
    private static final int TYPE_VIDEO=1;
    private static final int COUNT=2;

    public SelectionLsAdapter(Context context) {
        this.context = context;
    }

    public SelectionLsAdapter setArrayList(ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        if (arrayList.get(position).getType().equals("video")) {
            return TYPE_VIDEO;
        } else{
            return TYPE_TEXT;
        }
    }

    @Override
    public int getViewTypeCount() {
        return COUNT;
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
        SelectionLsTextHolder textHolder=null;
        int type=getItemViewType(position);
        if (convertView == null) {
            switch (type){
                case TYPE_VIDEO:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_selection_ls_video, parent, false);
                    holder = new SelectionLsHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_TEXT:
                    convertView=LayoutInflater.from(context).inflate(R.layout.item_selection_ls_text,parent,false);
                    textHolder=new SelectionLsTextHolder(convertView);
                    convertView.setTag(textHolder);
                    break;
            }

        } else {
            switch (type){
                case TYPE_VIDEO:
                    holder = (SelectionLsHolder) convertView.getTag();
                    break;
                case TYPE_TEXT:
                    textHolder= (SelectionLsTextHolder) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case TYPE_VIDEO:
                holder.durationTV.setText(arrayList.get(position).getDuration() + "");
                holder.typeTV.setText(arrayList.get(position).getCategory());
                holder.titleTV.setText(arrayList.get(position).getTitle());
                PicassoInstance.getsInstance().setImage(arrayList.get(position).getCover().getFeed(),holder.bacIV);
                break;
            case TYPE_TEXT:
                textHolder.dateTV.setText(arrayList.get(position).getText());
                break;
        }
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
    class SelectionLsTextHolder{
        private TextView dateTV;
        public SelectionLsTextHolder(View view){
            dateTV = (TitleTextView) view.findViewById(R.id.selection_ls_date_tv);
        }
    }
}
