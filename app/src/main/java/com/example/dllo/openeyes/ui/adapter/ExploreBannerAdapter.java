package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.ExploreBannerBean;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.ModuleUtilsInstance;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;

/**
 * Created by mac on 16/8/22.
 * 轮播图探索的适配器
 *
 * @author wangweijian
 */
public class ExploreBannerAdapter extends PagerAdapter {
    private ExploreBannerBean exploreBannerBean;
    private Context context;
    private ImageView exploreIv;
    private TextView exploreTitleTv, exploreCategoryTv, exploreMinutesTv, exploreSecondsTv, exploreDescriptionTv;
    private RelativeLayout exploreRel;

    public ExploreBannerAdapter(Context context) {
        this.context = context;
    }

    public void setExploreBannerBean(ExploreBannerBean exploreBannerBean) {
        this.exploreBannerBean = exploreBannerBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return exploreBannerBean.getItemList().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //获取屏幕宽高
        final int screenWidth = ScreenUtilsInstance.getsInstance().getScreenWidth(context);
        final int screenHeight = ScreenUtilsInstance.getsInstance().getScreenHeight(context);
        //获取行布局一些属性
        View view = LayoutInflater.from(context).inflate(R.layout.item_explore, container, false);
        exploreIv = (ImageView) view.findViewById(R.id.explore_iv);
        exploreTitleTv = (TextView) view.findViewById(R.id.explore_title_tv);
        exploreCategoryTv = (TextView) view.findViewById(R.id.explore_category_tv);
        exploreMinutesTv = (TextView) view.findViewById(R.id.explore_minutes_tv);
        exploreSecondsTv = (TextView) view.findViewById(R.id.explore_seconds_tv);
        exploreDescriptionTv = (TextView) view.findViewById(R.id.explore_description_tv);
        exploreRel = (RelativeLayout) view.findViewById(R.id.item_explore_rel);
        //获取传来的数据
        ExploreBannerBean.ItemListBean.DataBean bean = exploreBannerBean.getItemList().get(position).getData();
        //设置上去
        exploreTitleTv.setText(bean.getTitle());
        exploreCategoryTv.setText("#" + bean.getCategory() + "  /  ");
        exploreMinutesTv.setText(bean.getDuration() / 60 + "′");
        exploreSecondsTv.setText(bean.getDuration() / 60 + "″");
        exploreDescriptionTv.setText(bean.getDescription());
        PicassoInstance.getsInstance().setImage(bean.getCover().getFeed(), exploreIv);

        exploreRel.setOnTouchListener(new View.OnTouchListener() {
            int lastX, lastY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int ea = event.getAction();


                switch (ea) {
                    case MotionEvent.ACTION_DOWN:

                        lastX = (int) event.getRawX();//获取触摸事件触摸位置的原始X坐标
                        lastY = (int) event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) event.getRawX() - lastX;
                        int dy = (int) event.getRawY() - lastY;

                        int l = v.getLeft() + dx;
                        int b = v.getBottom() + dy;
                        int r = v.getRight() + dx;
                        int t = v.getTop() + dy;

                        //下面判断移动是否超出屏幕
                        if (l < 0) {
                            r = l + v.getWidth();
                        }

                        if (t < 0) {
                            b = t + v.getHeight();
                        }

                        if (r < 0) {
                            r = screenWidth;
                            l = r - v.getWidth();
                        }

                        if (b < 0) {
                            b = screenHeight;
                            t = b - v.getHeight();
                        }
                        v.layout(l, t, r, b);

                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        int twenty = (int) DensityUtils.dp2px(context, 20);
                        int forty = (int) DensityUtils.dp2px(context, 40);
                        int height = ModuleUtilsInstance.getsInstance().getModuleHeight(exploreIv);
                        int width = ModuleUtilsInstance.getsInstance().getModuleWidth(exploreIv);
                        v.layout(twenty, forty, width + twenty, height + forty);
                }

                return true;
            }
        });
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
