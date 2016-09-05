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
import com.example.dllo.openeyes.model.bean.AccordBean;
import com.example.dllo.openeyes.model.bean.AuthorDetailBean;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.view.CenterTextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by dllo on 16/8/23.
 */
public class AuthorDetailDateAdapter extends RecyclerView.Adapter<AuthorDetailDateAdapter.ImageHolder> {
    private Context context;
    private ArrayList<AuthorDetailBean.ItemListBean> datas;
    private OnRecyclerViewClickListener onRecyclerViewClickListener;

    public AuthorDetailDateAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(ArrayList<AuthorDetailBean.ItemListBean> datas) {
        this.datas = datas;

//        Log.d("AuthorDetailDateFragmen", "bean.getItemList():" + datas.get(0).getData().getDescription());


        notifyDataSetChanged();
    }

    public void setOnRecyclerViewClickListener(OnRecyclerViewClickListener onRecyclerViewClickListener) {
        this.onRecyclerViewClickListener = onRecyclerViewClickListener;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.item_author_date_detail,parent,false);
        ImageHolder holder=new ImageHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        String coverUrl=datas.get(position).getData().getCover().getFeed();
        String cateStr = "#" + datas.get(position).getData().getCategory();
        DecimalFormat df = new DecimalFormat("00");
        String m = df.format(datas.get(position).getData().getDuration() / 60);
        String s = df.format(datas.get(position).getData().getDuration() % 60);
        holder.titleTv.setText(datas.get(position).getData().getTitle());
        holder.nameTv.setText(datas.get(position).getData().getAuthor().getName());
        holder.durationTv.setText(cateStr + "  /  " + m + "′ " + s + "″");
        PicassoInstance.getsInstance().setImage(coverUrl,holder.coverIv);

//        //获取屏幕宽度
//        int height = ScreenUtilsInstance.getsInstance().getScreenHeight(context);
//        //将dp转换成px
//        int px = DensityUtils.dp2px(context, 115);
//        //获取控件的布局
//        ViewGroup.LayoutParams layoutParams = holder.coverIv.getLayoutParams();
//        //修改布局中的属性
//        layoutParams.height = (height - px) / 2;
//        //重新设置修改后的布局给控件
//        holder.coverIv.setLayoutParams(layoutParams);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        private ImageView coverIv;
        private TextView titleTv, durationTv, nameTv;

        public ImageHolder(View itemView) {
            super(itemView);
            coverIv = (ImageView) itemView.findViewById(R.id.author_date_detail_cover);
            titleTv = (TextView) itemView.findViewById(R.id.author_date_detail_title);
            durationTv = (TextView) itemView.findViewById(R.id.author_date_detail_duration);
            nameTv = (TextView) itemView.findViewById(R.id.author_date_detail_name);
        }
    }
}
