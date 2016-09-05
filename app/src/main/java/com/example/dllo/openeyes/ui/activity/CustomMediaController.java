package com.example.dllo.openeyes.ui.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.tools.BitmapUtil;
import com.example.dllo.openeyes.tools.RandomUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.vov.vitamio.widget.MediaController;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */
public class CustomMediaController extends MediaController {
    private Context mContext;
    private View mVolumeBrightnessLayout;
    private ImageView mOperationBg;
    private ImageView mOperationPercent;
    private AudioManager mAudioManager;
    private int mMaxVolume;

    private int mVolume = -1;
    private float mBrightness = -1f;
    private GestureDetector mGestureDetector;

    PlayVideoActivity activity;
    private ImageView mediacontroller_snapshot;
    private ImageView mediacontroller_previous;
    private ImageView mediacontroller_next;
    private ImageView mediacontroller_screen_fit;
    private ImageView changeVideoIV,normalVideoIV,highVideoIV;
    private ImageView backIV;
    private TextView batteryText,titleTV,backlatestTV;
    private BatteryBroadcastReciver reciver;
    private boolean flag=true;



    /**
     * public static final int VIDEO_LAYOUT_ORIGIN
     * 缩放参数，原始画面大小。
     * 常量值：0
     * <p>
     * public static final int VIDEO_LAYOUT_SCALE
     * 缩放参数，画面全屏。
     * 常量值：1
     * <p>
     * public static final int VIDEO_LAYOUT_STRETCH
     * 缩放参数，画面拉伸。
     * 常量值：2
     * <p>
     * public static final int VIDEO_LAYOUT_ZOOM
     * 缩放参数，画面裁剪。
     * 常量值：3
     */
    private String[] strDialogs = new String[]{"100%", "全屏", "拉伸", "裁剪"};
    private int[] imgs = new int[]{R.mipmap.mediacontroller_sreen_size_100, R.mipmap.mediacontroller_screen_fit, R.mipmap.mediacontroller_screen_size, R.mipmap.mediacontroller_sreen_size_crop};
    private int mCurrentPageSize = 2;

    private TextView currenttime_tv;

    private Handler mDismissHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mVolumeBrightnessLayout.setVisibility(View.GONE);
            }
        }
    };
    private long pos;
    private AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean playInfoBean;

    public CustomMediaController(Context context) {
        super(context);
        this.mContext = context;
        activity = (PlayVideoActivity) context;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mMaxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mGestureDetector = new GestureDetector(mContext, new VolumeBrightnesGestureListener());

    }

    @Override
    protected View makeControllerView() {
        return ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                inflate(getResources().getIdentifier("mediacontroller", "layout", mContext.getPackageName()), this);
    }

    @Override
    protected void initOtherView() {
        mediacontroller_snapshot = (ImageView) mRoot.findViewById(R.id.mediacontroller_snapshot);
        mediacontroller_previous = (ImageView) mRoot.findViewById(R.id.mediacontroller_previous);
        mediacontroller_next = (ImageView) mRoot.findViewById(R.id.mediacontroller_next);
        mediacontroller_screen_fit = (ImageView) mRoot.findViewById(R.id.mediacontroller_screen_fit);
        changeVideoIV= (ImageView) mRoot.findViewById(R.id.change_video_iv_default);
        normalVideoIV=(ImageView) mRoot.findViewById(R.id.change_video_normal);
        highVideoIV=(ImageView) mRoot.findViewById(R.id.change_video_high);
        titleTV= (TextView) mRoot.findViewById(R.id.file_name);
        backlatestTV=(TextView) mRoot.findViewById(R.id.back_latest_pos_tv);
        playInfoBean = activity.getIntent().getParcelableExtra("playInfo");

        titleTV.setText(playInfoBean.getTitle());
        batteryText= (TextView) mRoot.findViewById(R.id.download_precent_tv);
        backIV= (ImageView) mRoot.findViewById(R.id.back_iv);
        switch (playInfoBean.getPlayInfo().size()){
            case 1:
                break;
            case 2:
                changeVideoIV.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flag){
                            highVideoIV.setVisibility(VISIBLE);
                            flag=false;
                        }else {
                            highVideoIV.setVisibility(GONE);
                            flag=true;
                        }

                    }
                });
                final String highUrl=playInfoBean.getPlayInfo().get(1).getUrl();
                highVideoIV.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            pos = mPlayer.getCurrentPosition();
                            changeVideoIV.setImageResource(R.mipmap.action_high_mode);
                            activity.getVideoView().setVideoURI(Uri.parse(highUrl));

                    }
                });
                break;
            case 3:
                changeVideoIV.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flag){
                            highVideoIV.setVisibility(VISIBLE);
                            normalVideoIV.setVisibility(VISIBLE);
                            flag=false;
                        }else {
                            highVideoIV.setVisibility(GONE);
                            normalVideoIV.setVisibility(GONE);
                            flag=true;
                        }
                    }
                });
                final String normalUrl=playInfoBean.getPlayInfo().get(1).getUrl();
                normalVideoIV.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pos = mPlayer.getCurrentPosition();
                        activity.getVideoView().setVideoURI(Uri.parse(normalUrl));
                        changeVideoIV.setImageResource(R.mipmap.action_normal_mode);

                    }
                });
                final String highurl=playInfoBean.getPlayInfo().get(2).getUrl();
                highVideoIV.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pos = mPlayer.getCurrentPosition();
                        activity.getVideoView().setVideoURI(Uri.parse(highurl));
                        changeVideoIV.setImageResource(R.mipmap.action_high_mode);

                    }
                });


                break;
        }
        backlatestTV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getVideoView().fallowTo(pos);
            }
        });
        backIV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.unregisterReceiver(reciver);
                activity.finish();
            }
        });

        reciver=new CustomMediaController.BatteryBroadcastReciver();
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        activity.registerReceiver(reciver, intentFilter);


        mediacontroller_snapshot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap currentFrame = activity.getCurrentFrame();
                //保存到本地
                String picturnPath = activity.getExternalCacheDir() + File.separator + RandomUtil.getRandomLetters(6) + ".jpg";
                boolean saveSuccess = BitmapUtil.saveBitmap(currentFrame, new File(picturnPath));
                if (saveSuccess) {
                    Toast.makeText(mContext, "截屏保存到" + picturnPath, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "截屏失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mediacontroller_previous.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.reverseVideo();
            }
        });
        mediacontroller_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.speedVideo();
            }
        });
        mediacontroller_screen_fit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentPageSize++;
                if (mCurrentPageSize > 3) {
                    mCurrentPageSize = 0;
                }
                Toast.makeText(mContext, strDialogs[mCurrentPageSize], Toast.LENGTH_SHORT).show();
                mediacontroller_screen_fit.setBackground(getResources().getDrawable(imgs[mCurrentPageSize]));
                activity.setVideoPageSize(mCurrentPageSize);
            }
        });
        currenttime_tv = (TextView) mRoot.findViewById(R.id.currenttime_tv);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                currenttime_tv.setText(simpleDateFormat.format(date));
                handler.postDelayed(this, 500);
            }
        };
        handler.postDelayed(runnable, 500);

        mVolumeBrightnessLayout = mRoot.findViewById(R.id.operation_volume_brightness);
        mOperationBg = (ImageView) mRoot.findViewById(R.id.operation_bg);
        mOperationPercent = (ImageView) mRoot.findViewById(R.id.operation_percent);
        mRoot.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mGestureDetector.onTouchEvent(event)) {
                    return true;
                }
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        endGesture();
                        break;
                }
                return false;
            }
        });

    }



    private void endGesture() {
        mVolume = -1;
        mBrightness = -1f;
        // 隐藏
        mDismissHandler.removeMessages(0);
        mDismissHandler.sendEmptyMessageDelayed(0, 500);
    }


    private class VolumeBrightnesGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float mOldX = e1.getX(), mOldY = e1.getY();
            int y = (int) e2.getRawY();
            Display disp = ((Activity) mContext).getWindowManager().getDefaultDisplay();
            int windowWidth = disp.getWidth();
            int windowHeight = disp.getHeight();
            if (mOldX > windowWidth * 4.0 / 5) {
                onVolumeSlide((mOldY - y) / windowHeight);
                return true;
            } else if (mOldX < windowWidth / 5.0) {
                onBrightnessSlide((mOldY - y) / windowHeight);
                return true;
            }
            return false;
        }
    }

    /**
     * 声音高低
     *
     * @param percent
     */
    private void onVolumeSlide(float percent) {
        if (mVolume == -1) {
            mVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            if (mVolume < 0)
                mVolume = 0;

            mOperationBg.setImageResource(R.mipmap.video_volumn_bg);
            mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
        }

        int index = (int) (percent * mMaxVolume) + mVolume;
        if (index > mMaxVolume)
            index = mMaxVolume;
        else if (index < 0)
            index = 0;

        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);
        ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
        lp.width = findViewById(R.id.operation_full).getLayoutParams().width * index / mMaxVolume;
        mOperationPercent.setLayoutParams(lp);
    }

    /**
     * 处理屏幕亮暗
     *
     * @param percent
     */
    private void onBrightnessSlide(float percent) {
        if (mBrightness < 0) {
            mBrightness = ((Activity) mContext).getWindow().getAttributes().screenBrightness;
            if (mBrightness <= 0.00f)
                mBrightness = 0.50f;
            if (mBrightness < 0.01f)
                mBrightness = 0.01f;

            mOperationBg.setImageResource(R.mipmap.video_brightness_bg);
            mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
        }
        WindowManager.LayoutParams lpa = ((Activity) getContext()).getWindow().getAttributes();
        lpa.screenBrightness = mBrightness + percent;
        if (lpa.screenBrightness > 1.0f)
            lpa.screenBrightness = 1.0f;
        else if (lpa.screenBrightness < 0.01f)
            lpa.screenBrightness = 0.01f;
        ((Activity) mContext).getWindow().setAttributes(lpa);

        ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
        lp.width = (int) (findViewById(R.id.operation_full).getLayoutParams().width * lpa.screenBrightness);
        mOperationPercent.setLayoutParams(lp);
    }
    public class BatteryBroadcastReciver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                //得到系统当前电量
                int level = intent.getIntExtra("level", 0);
                //取得系统总电量
                int total = intent.getIntExtra("scale", 100);
                batteryText.setText((level * 100) / total + "%");
            }
        }
    }


}