package com.example.dllo.openeyes.selection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/13.
 */
public class SelectionReAdapter extends RecyclerView.Adapter<SelectionReAdapter.SelectionReHolder> {
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean> arrayList;
    private Context context;

    public SelectionReAdapter(Context context) {
        this.context = context;
    }

    public SelectionReAdapter setArrayList(ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean> arrayList) {
        this.arrayList = arrayList;
        return this;
    }

    @Override
    public SelectionReHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SelectionReHolder holder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_selection_re,parent,false);
        holder=new SelectionReHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SelectionReHolder holder, int position) {
        holder.typeTV.setText(arrayList.get(position).getCategory());
        holder.durationTV.setText(arrayList.get(position).getDuration()+"");
        holder.titleTV.setText(arrayList.get(position).getTitle());
        PicassoInstance.getsInstance().setImage(arrayList.get(position).getCover().getFeed(),holder.bacIV);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class SelectionReHolder extends RecyclerView.ViewHolder{
        private ImageView bacIV;
        private TextView titleTV,durationTV,typeTV;
        public SelectionReHolder(View itemView) {
            super(itemView);
            bacIV = (ImageView) itemView.findViewById(R.id.selection_re_bac_iv);
            titleTV = (TextView) itemView.findViewById(R.id.selection_re_title_tv);
            typeTV = (TextView) itemView.findViewById(R.id.selection_re_type_tv);
            durationTV = (TextView) itemView.findViewById(R.id.selection_re_duration_tv);
        }
    }
}
