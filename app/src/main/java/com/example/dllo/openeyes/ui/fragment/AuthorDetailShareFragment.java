package com.example.dllo.openeyes.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AccordBean;
import com.example.dllo.openeyes.model.bean.AuthorDetailBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.ui.adapter.AccordShareAdapter;
import com.example.dllo.openeyes.ui.adapter.AuthorDetailDateAdapter;
import com.example.dllo.openeyes.view.CenterTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mac on 16/8/17.
 * 根据分享顺序排序界面
 * @author jiangtianyi
 */
public class AuthorDetailShareFragment extends AbsBaseFragment {
    private AuthorDetailBean bean;
    private AuthorDetailDateAdapter adapter;
    private RecyclerView recyclerView;
    private int id;
//    private CircleImageView iconCirIv;//协调布局的图片
//    private CenterTextView descriptionCenTv;
//    private TextView nameTv, nameBarTv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_author_date_detail;
    }

    @Override
    protected void initViews(View view) {
        recyclerView = byView(R.id.author_detail_recyclerView);
//        iconCirIv = (CircleImageView) getActivity().findViewById(R.id.author_detail_icon);
//        descriptionCenTv = (CenterTextView) getActivity().findViewById(R.id.author_detail_description);
//        nameTv = (TextView) getActivity().findViewById(R.id.author_detail_name);
//        nameBarTv = (TextView) getActivity().findViewById(R.id.author_detail_name_bar);
    }

    @Override
    protected void initDatas() {
        Intent intent = getActivity().getIntent();
        id = intent.getIntExtra("id", 0);
        //加载按时间排序的界面的数据
        addDateData();
    }

    private void addDateData() {

        bean = new AuthorDetailBean();

        OkHttp.getInstance().startRequest(NetUrls.AUTHOR_DETAIL_HEAD_URL + id + NetUrls.AUTHOR_DETAIL_SHARE_URL + NetUrls.AUTHOR_DETAIL_FOOT_URL
                , AuthorDetailBean.class, new OnHttpCallBack<AuthorDetailBean>() {

                    @Override
                    public void onSuccess(AuthorDetailBean response) {
                        bean = response;
                        adapter = new AuthorDetailDateAdapter(context);
                        adapter.setDatas((ArrayList<AuthorDetailBean.ItemListBean>) bean.getItemList());
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView.setAdapter(adapter);
//                        nameTv.setText(bean.getPgcInfo().getName());
//                        nameBarTv.setText(bean.getPgcInfo().getName());
//                        PicassoInstance.getsInstance().setImage(bean.getPgcInfo().getIcon(),iconCirIv);
//                        descriptionCenTv.setText(bean.getPgcInfo().getDescription());

                    }
                    @Override
                    public void onError(Throwable ex) {

                    }
                });
    }
}
