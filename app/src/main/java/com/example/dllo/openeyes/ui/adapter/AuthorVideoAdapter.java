package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.RecyclableImageView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by dllo on 16/8/15.
 */
public class AuthorVideoAdapter extends RecyclerView.Adapter<AuthorVideoAdapter.VideoHolder> {
    private Context context;
    private ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> datas;
    private OnRecyclerViewClickListener onRecyclerViewClickListener;

    public AuthorVideoAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setOnRecyclerViewClickListener(OnRecyclerViewClickListener onRecyclerViewClickListener) {
        this.onRecyclerViewClickListener = onRecyclerViewClickListener;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_author_video_bean_for_client, parent, false);
        VideoHolder holder = new VideoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final VideoHolder holder, int position) {
        holder.titleTv.setText(datas.get(position).getData().getTitle());
        holder.categoryTv.setText("#"+datas.get(position).getData().getCategory());
        DecimalFormat df = new DecimalFormat("00");
        String m=df.format(datas.get(position).getData().getDuration()/60);
        String s=df.format(datas.get(position).getData().getDuration()%60);
        holder.durationTv.setText(m+"′ "+s+"″");
        PicassoInstance.getsInstance().setImage(datas.get(position).getData().getCover().getFeed(),holder.coverImg);

        //横划图片的点击事件
        holder.coverImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=holder.getAdapterPosition();
                onRecyclerViewClickListener.OnRecyclerViewClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class VideoHolder extends RecyclerView.ViewHolder {
        TextView titleTv, categoryTv, durationTv;
        RecyclableImageView coverImg;

        public VideoHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.author_video_bean_for_client_title);
            categoryTv = (TextView) itemView.findViewById(R.id.author_video_bean_for_client_category);
            durationTv = (TextView) itemView.findViewById(R.id.author_video_bean_for_client_duration);
            coverImg = (RecyclableImageView) itemView.findViewById(R.id.author_video_bean_for_client_cover_feed);
        }
    }

}
