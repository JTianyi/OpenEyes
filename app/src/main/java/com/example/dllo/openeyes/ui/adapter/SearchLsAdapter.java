package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.SearchBean;
import com.example.dllo.openeyes.tools.PicassoInstance;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/19.
 */
public class SearchLsAdapter extends BaseAdapter{
    private ArrayList<SearchBean.ItemListBean> arrayList;
    private Context context;

    public SearchLsAdapter(Context context) {
        this.context = context;
    }

    public SearchLsAdapter setArrayList(ArrayList<SearchBean.ItemListBean> arrayList) {
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
        SearchHolder holder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_selection_ls_video,parent,false);
            holder=new SearchHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (SearchHolder) convertView.getTag();
        }
        SearchBean.ItemListBean.DataBean.SearchAuthorBean bean=arrayList.get(position).getData().getAuthor();
        if (bean==null){
            holder.authorNameTV.setText("");
        }else {
            holder.authorNameTV.setText(bean.getName());
        }
        holder.titleTV.setText(arrayList.get(position).getData().getTitle());
        holder.typeTV.setText("#"+arrayList.get(position).getData().getCategory());
        int duration=arrayList.get(position).getData().getDuration();
        int min=duration/60;
        int sec=duration%60;
        if (min<10){
            holder.durationTV.setText("0"+min+"′"+sec+"″");
            if (sec<10){
                holder.durationTV.setText("0"+min+"′"+"0"+sec+"″");
            }
        }else{
            if (sec<10){
                holder.durationTV.setText(min+"′"+"0"+sec+"″");
            }
        }
        PicassoInstance.getsInstance().setImage(arrayList.get(position).getData().getCover().getFeed(),holder.bacIV);

        return convertView;
    }
    class SearchHolder{
        private ImageView bacIV;
        private TextView titleTV, typeTV, durationTV,authorNameTV;

        public SearchHolder(View view) {
            bacIV = (ImageView) view.findViewById(R.id.selection_ls_bac_iv);
            titleTV = (TextView) view.findViewById(R.id.selection_ls_title_tv);
            typeTV = (TextView) view.findViewById(R.id.selection_ls_type_tv);
            durationTV = (TextView) view.findViewById(R.id.selection_ls_duration_tv);
            authorNameTV = (TextView) view.findViewById(R.id.selection_ls_author_name_tv);
        }
    }
}
