package com.example.dllo.openeyes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/15.
 */
public class AuthorAdapter extends BaseAdapter {
    private Context context;
    private AuthorBean bean;
    private final int TYPE_LEFT_ALIGN_TEXT_HEADER = 0, TYPE_BRIEF_CARD = 1, TYPE_BLANK_CARD = 2,
            TYPE_VIDEO_COLLECTION_WITH_BRIEF = 3, TYPE_COUNT = 4;
    //TYPE_VIDEO_BEAN_FOR_CLIENT = 4,


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
        int type = getItemViewType(position);
        LeftAlignTextHeaderHolder leftAlignTextHeaderHolder=null;

        if (convertView == null) {
            switch (type) {
                case TYPE_LEFT_ALIGN_TEXT_HEADER:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_author_left_align_text_header, parent, false);
                    leftAlignTextHeaderHolder=new LeftAlignTextHeaderHolder(convertView);
                    convertView.setTag(leftAlignTextHeaderHolder);
                    break;
                case TYPE_BRIEF_CARD:


                    break;
                case TYPE_BLANK_CARD:


                    break;
                case TYPE_VIDEO_COLLECTION_WITH_BRIEF:


                    break;
            }
        }
        return convertView;
    }

    class LeftAlignTextHeaderHolder {
        private TextView text;

        public LeftAlignTextHeaderHolder(View view) {
            text = (TextView) view.findViewById(R.id.author_left_align_text_header_text);
        }
    }



}
