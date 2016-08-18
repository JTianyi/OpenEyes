package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.tools.PicassoInstance;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 *
 * @author jiangtianyi
 */
public class AuthorAdapter extends BaseAdapter {
    private Context context;
    private AuthorFragmentBean bean;
    private final int TYPE_LEFT_ALIGN_TEXT_HEADER = 0, TYPE_BRIEF_CARD = 1, TYPE_BLANK_CARD = 2,
            TYPE_VIDEO_COLLECTION_WITH_BRIEF = 3, TYPE_COUNT = 4;
    private AuthorVideoAdapter videoAdapter;


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
    public View getView(int position, View convertView, ViewGroup parent) {
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
                break;
            case TYPE_BLANK_CARD:


                break;
            case TYPE_VIDEO_COLLECTION_WITH_BRIEF:
                videoHolder.descriptionTv.setText(bean.getItemList().get(position).getData().getHeader().getDescription());
                videoHolder.titleTv.setText(bean.getItemList().get(position).getData().getHeader().getTitle());
                videoHolder.subTitleTv.setText(bean.getItemList().get(position).getData().getHeader().getSubTitle());
                PicassoInstance.getsInstance().setImage(bean.getItemList().get(position).getData().getHeader().getIcon(), videoHolder.iconImg);
                videoAdapter = new AuthorVideoAdapter(context);
                videoAdapter.setDatas((ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean>) bean.getItemList().get(position).getData().getItemList());
                videoHolder.recyclerView.setAdapter(videoAdapter);
                videoHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
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

        public BriefCardHolder(View view) {
            iconImg = (CircleImageView) view.findViewById(R.id.author_brief_card_icon);
            titleTv = (TextView) view.findViewById(R.id.author_brief_card_title);
            subTitleTv = (TextView) view.findViewById(R.id.author_brief_card_subTitle);
            descriptionTv = (TextView) view.findViewById(R.id.author_brief_card_description);
        }
    }

    class VideoCollectionWithBriefHolder {
        private CircleImageView iconImg;
        private TextView titleTv, subTitleTv, descriptionTv;
        private RecyclerView recyclerView;

        public VideoCollectionWithBriefHolder(View view) {
            iconImg = (CircleImageView) view.findViewById(R.id.author_video_collection_with_brief_icon);
            titleTv = (TextView) view.findViewById(R.id.author_video_collection_with_brief_title);
            subTitleTv = (TextView) view.findViewById(R.id.author_video_collection_with_brief_subTitle);
            descriptionTv = (TextView) view.findViewById(R.id.author_video_collection_with_brief_description);
            recyclerView = (RecyclerView) view.findViewById(R.id.author_video_collection_with_brief_recyclerview);
        }
    }


}