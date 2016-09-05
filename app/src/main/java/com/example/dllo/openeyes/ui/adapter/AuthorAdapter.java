package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.ui.activity.AuthorDetailActivity;
import com.example.dllo.openeyes.ui.activity.AuthorVideoActivity;
import com.example.dllo.openeyes.ui.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 *作者页面的ListView的adapter
 * @author jiangtianyi
 */
public class AuthorAdapter extends BaseAdapter {
    private Context context;
    private AuthorFragmentBean bean;
    private final int TYPE_LEFT_ALIGN_TEXT_HEADER = 0, TYPE_BRIEF_CARD = 1, TYPE_BLANK_CARD = 2,
            TYPE_VIDEO_COLLECTION_WITH_BRIEF = 3, TYPE_COUNT = 4;

    public AuthorAdapter(Context context) {
        this.context = context;
    }

    public void setBean(AuthorFragmentBean bean) {
        this.bean = bean;
        notifyDataSetChanged();


    }

    @Override
    public int getItemViewType(int position) {
        if (bean.getItemList().get(position).getType().equals("leftAlignTextHeader")) {
            return TYPE_LEFT_ALIGN_TEXT_HEADER;
        } else if (bean.getItemList().get(position).getType().equals("briefCard")) {
            return TYPE_BRIEF_CARD;
        } else if (bean.getItemList().get(position).getType().equals("blankCard")) {
            return TYPE_BLANK_CARD;
        } else {
            return TYPE_VIDEO_COLLECTION_WITH_BRIEF;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return bean.getItemList().size() > 0 && bean.getItemList() != null ? bean.getItemList().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return bean.getItemList().size() > 0 && bean.getItemList() != null ? bean.getItemList().get(position) : null;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LeftAlignTextHeaderHolder headerHolder = null;
        BriefCardHolder briefCardHolder = null;
        VideoCollectionWithBriefHolder videoHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_LEFT_ALIGN_TEXT_HEADER:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_author_left_align_text_header, parent, false);
                    headerHolder = new LeftAlignTextHeaderHolder(convertView);
                    convertView.setTag(headerHolder);
                    break;
                case TYPE_BRIEF_CARD:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_author_brief_card, parent, false);
                    briefCardHolder = new BriefCardHolder(convertView);
                    convertView.setTag(briefCardHolder);
                    break;
                case TYPE_BLANK_CARD:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_author_blank_card, parent, false);
                    break;
                case TYPE_VIDEO_COLLECTION_WITH_BRIEF:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_author_video_collection_with_brief, parent, false);
                    videoHolder = new VideoCollectionWithBriefHolder(convertView);
                    convertView.setTag(videoHolder);
                    break;
            }


        } else {
            switch (type) {
                case TYPE_LEFT_ALIGN_TEXT_HEADER:
                    headerHolder = (LeftAlignTextHeaderHolder) convertView.getTag();
                    break;
                case TYPE_BRIEF_CARD:

                    briefCardHolder = (BriefCardHolder) convertView.getTag();
                    break;
                case TYPE_BLANK_CARD:

                    break;
                case TYPE_VIDEO_COLLECTION_WITH_BRIEF:
                    videoHolder = (VideoCollectionWithBriefHolder) convertView.getTag();
                    break;
            }

        }

        switch (type) {
            case TYPE_LEFT_ALIGN_TEXT_HEADER:
                String text = bean.getItemList().get(position).getData().getText();
                String textL = "";
                for (int i = 0; i < text.length(); i++) {
                    textL = textL + text.substring(i, i + 1) + " ";
                }
                headerHolder.text.setText(textL);
                break;
            case TYPE_BRIEF_CARD:
                briefCardHolder.descriptionTv.setText(bean.getItemList().get(position).getData().getDescription());
                briefCardHolder.titleTv.setText(bean.getItemList().get(position).getData().getTitle());
                briefCardHolder.subTitleTv.setText(bean.getItemList().get(position).getData().getSubTitle());
                PicassoInstance.getsInstance().setImage(bean.getItemList().get(position).getData().getIcon(), briefCardHolder.iconImg);
                briefCardHolder.briefRel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,AuthorDetailActivity.class);
                        intent.putExtra("id",bean.getItemList().get(position).getData().getId());
                        intent.putExtra("des",bean.getItemList().get(position).getData().getDescription());
                        intent.putExtra("name",bean.getItemList().get(position).getData().getTitle());
                        intent.putExtra("namebar",bean.getItemList().get(position).getData().getTitle());
                        intent.putExtra("icon",bean.getItemList().get(position).getData().getIcon());
                        context.startActivity(intent);
                    }
                });
                break;


            case TYPE_BLANK_CARD:
                int px = DensityUtils.dp2px(context,bean.getItemList().get(position).getData().getHeight());
                //获取控件的布局
                ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
                //修改布局中的属性
                layoutParams.height = px;
                //重新设置修改后的布局给控件
                convertView.setLayoutParams(layoutParams);
                break;
            case TYPE_VIDEO_COLLECTION_WITH_BRIEF:

                videoHolder.descriptionTv.setText(bean.getItemList().get(position).getData().getHeader().getDescription());
                videoHolder.titleTv.setText(bean.getItemList().get(position).getData().getHeader().getTitle());
                videoHolder.subTitleTv.setText(bean.getItemList().get(position).getData().getHeader().getSubTitle());
                PicassoInstance.getsInstance().setImage(bean.getItemList().get(position).getData().getHeader().getIcon(), videoHolder.iconImg);
                final AuthorVideoAdapter videoAdapter = new AuthorVideoAdapter(context);
                final ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean>datas;
                final AuthorFragmentBean.ItemListBean.DataBean dataBean;
                datas=bean.getItemList().get(position).getData().getItemList();
                dataBean=bean.getItemList().get(position).getData();
                videoAdapter.setDatas(datas);
                videoHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                videoHolder.recyclerView.setAdapter(videoAdapter);
                videoHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,AuthorDetailActivity.class);
//                        intent.putExtra("header",)
                        intent.putExtra("id",bean.getItemList().get(position).getData().getHeader().getId());
                        intent.putExtra("des",bean.getItemList().get(position).getData().getHeader().getDescription());
                        intent.putExtra("name",bean.getItemList().get(position).getData().getHeader().getTitle());
                        intent.putExtra("namebar",bean.getItemList().get(position).getData().getHeader().getTitle());
                        intent.putExtra("icon",bean.getItemList().get(position).getData().getHeader().getIcon());
                        context.startActivity(intent);
                    }
                });
                videoAdapter.setOnRecyclerViewClickListener(new OnRecyclerViewClickListener() {
                    @Override
                    public void OnRecyclerViewClick(int position) {
                        Intent intent=new Intent(context, AuthorVideoActivity.class);
                        intent.putExtra("videos",dataBean);
                        intent.putExtra("pos", position);
                        context.startActivity(intent);
                    }
                });
                break;
        }
        return convertView;
    }

    class LeftAlignTextHeaderHolder {
        private TextView text;

        public LeftAlignTextHeaderHolder(View view) {
            text = (TextView) view.findViewById(R.id.author_left_align_text_header_text);
        }
    }

    class BriefCardHolder {
        private CircleImageView iconImg;
        private TextView titleTv, subTitleTv, descriptionTv;
        private RelativeLayout briefRel;

        public BriefCardHolder(View view) {
            iconImg = (CircleImageView) view.findViewById(R.id.author_brief_card_icon);
            titleTv = (TextView) view.findViewById(R.id.author_brief_card_title);
            subTitleTv = (TextView) view.findViewById(R.id.author_brief_card_subTitle);
            descriptionTv = (TextView) view.findViewById(R.id.author_brief_card_description);
            briefRel = (RelativeLayout) view.findViewById(R.id.item_author_brief_rel);
        }
    }

    class VideoCollectionWithBriefHolder {
        private CircleImageView iconImg;
        private TextView titleTv, subTitleTv, descriptionTv;
        private RecyclerView recyclerView;
        private RelativeLayout relativeLayout;

        public VideoCollectionWithBriefHolder(View view) {
            iconImg = (CircleImageView) view.findViewById(R.id.author_video_collection_with_brief_icon);
            titleTv = (TextView) view.findViewById(R.id.author_video_collection_with_brief_title);
            subTitleTv = (TextView) view.findViewById(R.id.author_video_collection_with_brief_subTitle);
            descriptionTv = (TextView) view.findViewById(R.id.author_video_collection_with_brief_description);
            recyclerView = (RecyclerView) view.findViewById(R.id.author_video_collection_with_brief_recyclerview);
            relativeLayout= (RelativeLayout) view.findViewById(R.id.author_video_brief_layout);
        }
    }


}
