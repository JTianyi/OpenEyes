package com.example.dllo.openeyes.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dllo on 16/8/18.
 * 打印机效果的文字显示方式
 */
public class TypeTextView extends TextView {
    private Context mContext;
    private String mShowTextString = null;
    private Timer mTypeTimer = null;
    private OnTypeViewListener mOnTypeViewListener = null;
    private static final int TYPE_TIME_DELAY = 1;
    private int mTypeTimeDelay = TYPE_TIME_DELAY; // 打字间隔

    public TypeTextView(Context context) {
        super(context);
        initTypeTextView(context);
    }

    public TypeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeTextView(context);

    }

    public TypeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeTextView(context);
    }

    public void setOnTypeViewListener(OnTypeViewListener onTypeViewListener) {
        mOnTypeViewListener = onTypeViewListener;
    }

    public void start(final String textString) {
        start(textString, TYPE_TIME_DELAY);
    }

    public void start(final String textString, final int typeTimeDelay) {
        if (TextUtils.isEmpty(textString) || typeTimeDelay < 0) {
            return;
        }
        post(new Runnable() {
            @Override
            public void run() {
                mShowTextString = textString;
                mTypeTimeDelay = typeTimeDelay;
                setText("");
                startTypeTimer();
                if (null != mOnTypeViewListener) {
                    mOnTypeViewListener.onTypeStart();
                }
            }
        });
    }

    private void initTypeTextView(Context context) {
        mContext = context;
    }

    private void startTypeTimer() {
        stopTypeTimer();
        mTypeTimer = new Timer();
        mTypeTimer.schedule(new TypeTimerTask(), mTypeTimeDelay);
    }

    private void stopTypeTimer() {
        if (null != mTypeTimer) {
            mTypeTimer.cancel();
            mTypeTimer = null;
        }
    }

    class TypeTimerTask extends TimerTask {
        @Override
        public void run() {
            post(new Runnable() {
                @Override
                public void run() {
                    if (getText().toString().length() < mShowTextString.length()) {
                        setText(mShowTextString.substring(0, getText().toString().length() + 1));
                        startTypeTimer();
                    } else {
                        stopTypeTimer();
                        if (null != mOnTypeViewListener) {
                            mOnTypeViewListener.onTypeOver();
                        }
                    }
                }
            });
        }
    }

    public interface OnTypeViewListener {
        void onTypeStart();

        void onTypeOver();
    }
}
