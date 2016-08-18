package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.BeforeSelectionBean;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.view.TitleTextView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/17.
 */
public class BeforeSelectionLsAdapter extends BaseAdapter{
    private ArrayList<BeforeSelectionBean.IssueListBean.ItemListBean> arrayList;
    private Context context;
    private static final int TYPE_TEXT=0;
    private static final int TYPE_VIDEO=1;
    private static final int COUNT=2;

    public BeforeSelectionLsAdapter(Context context) {
        this.context = context;
    }

    public BeforeSelectionLsAdapter setArrayList(ArrayList<BeforeSelectionBean.IssueListBean.ItemListBean> arrayList) {
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
    public void addData(BeforeSelectionBean.IssueListBean.ItemListBean bean){
        arrayList.add(bean);
    }

    @Override
    public int getItemViewType(int position) {
        if (arrayList.get(position).getType().equals("textHeader")){
            return TYPE_TEXT;
        }else{
            return TYPE_VIDEO;
        }
    }

    @Override
    public int getViewTypeCount() {
        return COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SelectionLsHolder holder=null;
        SelectionLsTextHolder textHolder=null;
        int type=getItemViewType(position);
        if (convertView==null){
            switch (type){
                case TYPE_VIDEO:
                    convertView= LayoutInflater.from(context).inflate(R.layout.item_selection_ls_video,parent,false);
                    holder=new SelectionLsHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_TEXT:
                    convertView=LayoutInflater.from(context).inflate(R.layout.item_selection_ls_text,parent,false);
                    textHolder=new SelectionLsTextHolder(convertView);
                    convertView.setTag(textHolder);
                    break;
            }
        }else{
            switch (type){
                case TYPE_VIDEO:
                    holder= (SelectionLsHolder) convertView.getTag();
                    break;
                case TYPE_TEXT:
                    textHolder= (SelectionLsTextHolder) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case TYPE_VIDEO:
                BeforeSelectionBean.IssueListBean.ItemListBean.DataBean.BeforeAuthorBean bean=arrayList.get(position).getData().getAuthor();
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
                break;
            case TYPE_TEXT:
                textHolder.dateTV.setTextSize(12);
                textHolder.dateTV.setText(arrayList.get(position).getData().getText());
                break;
        }

        return convertView;
    }
    class SelectionLsHolder {
        private ImageView bacIV;
        private TextView titleTV, typeTV, durationTV,authorNameTV;

        public SelectionLsHolder(View view) {
            bacIV = (ImageView) view.findViewById(R.id.selection_ls_bac_iv);
            titleTV = (TextView) view.findViewById(R.id.selection_ls_title_tv);
            typeTV = (TextView) view.findViewById(R.id.selection_ls_type_tv);
            durationTV = (TextView) view.findViewById(R.id.selection_ls_duration_tv);
            authorNameTV = (TextView) view.findViewById(R.id.selection_ls_author_name_tv);
        }
    }
    class SelectionLsTextHolder{
        private TextView dateTV;
        public SelectionLsTextHolder(View view){
            dateTV = (TitleTextView) view.findViewById(R.id.selection_ls_date_tv);
        }
    }
}
