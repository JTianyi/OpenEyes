package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.example.dllo.openeyes.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/19.
 */
public class PopReAdapter extends RecyclerView.Adapter<PopReAdapter.PopHolder> {
    private JSONArray arrayList;
    private Context context;
    private OnRecyclerViewClickListener listener;

    public PopReAdapter setListener(OnRecyclerViewClickListener listener) {
        this.listener = listener;
        return this;
    }

    public PopReAdapter(Context context) {
        this.context = context;
    }

    public PopReAdapter setArrayList(JSONArray arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public PopHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PopHolder holder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_search_pop_re,parent,false);
        holder=new PopHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final PopHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=holder.getAdapterPosition();
                listener.OnRecyclerViewClick(pos);
            }
        });
        holder.entryTV.setText((String)arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class PopHolder extends RecyclerView.ViewHolder{
        private TextView entryTV;
        public PopHolder(View itemView) {
            super(itemView);
            entryTV = (TextView) itemView.findViewById(R.id.pop_re_entry_tv);
        }
    }
}
