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
import com.example.dllo.openeyes.model.bean.AccordBean;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;


/**
 * Created by mac on 16/8/17.
 * 根据分享的适配器
 * @author wangweijian
 */
public class AccordShareAdapter extends BaseAdapter {
    private AccordBean accordBean;
    private Context context;
    private AccordBean.ItemListBean.DataBean dataBean;

    public AccordShareAdapter(Context context) {
        this.context = context;
    }

    public void setAccordBean(AccordBean accordBean) {
        this.accordBean = accordBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return accordBean.getItemList().size();
    }

    @Override
    public Object getItem(int position) {
        return accordBean.getItemList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimeHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_accord, parent, false);
            holder = new TimeHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (TimeHolder) convertView.getTag();
        }
        dataBean = accordBean.getItemList().get(position).getData();
        PicassoInstance.getsInstance().setImage(dataBean.getCover().getFeed(), holder.accordIv);
        holder.accordTitleTv.setText(dataBean.getTitle());
        holder.accordCategoryTv.setText("#" + dataBean.getCategory() + "  /  ");
        holder.accordMinutesTv.setText("0"+ dataBean.getDuration() / 60 + "′");
        holder.accordSecondsTv.setText(dataBean.getDuration() % 60 + "″");
        if (dataBean.getAuthor()!=null) {
            holder.accordNameTv.setText(dataBean.getAuthor().getName());
//            dataBean = accordBean.getItemList().get(position).getData();
        }else {
            holder.accordNameTv.setText("");
        }
        //获取屏幕宽度
        int height = ScreenUtilsInstance.getsInstance().getScreenHeight(context);
        //将dp转换成px
        int px = DensityUtils.dp2px(context, 115);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParams = holder.accordIv.getLayoutParams();
        //修改布局中的属性
        layoutParams.height = (height - px) / 2;
        //重新设置修改后的布局给控件
        holder.accordIv.setLayoutParams(layoutParams);
        return convertView;
    }

    class TimeHolder {
        private ImageView accordIv;
        private TextView accordTitleTv, accordCategoryTv, accordMinutesTv, accordSecondsTv, accordNameTv;

        public TimeHolder(View view) {
            accordIv = (ImageView) view.findViewById(R.id.accord_iv);
            accordTitleTv = (TextView) view.findViewById(R.id.accord_item_title_tv);
            accordCategoryTv = (TextView) view.findViewById(R.id.accord_item_category_tv);
            accordMinutesTv = (TextView) view.findViewById(R.id.accord_item_minutes_tv);
            accordSecondsTv = (TextView) view.findViewById(R.id.accord_item_seconds_tv);
            accordNameTv = (TextView) view.findViewById(R.id.accord_item_name_tv);
        }
    }
}
