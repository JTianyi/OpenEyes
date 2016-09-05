package com.example.dllo.openeyes.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.utils.StringUtils;
import master.flame.danmaku.controller.IDanmakuView;

/**
 * Created by dllo on 16/8/23.
 */
public class PlayVideoActivity extends AppCompatActivity {

    private io.vov.vitamio.widget.VideoView videoView;
    private IDanmakuView mDanmakuView;
    private ImageView mLoadingImg;
    private LinearLayout mLoadingLayout;
    private ObjectAnimator mOjectAnimator;
    private Long currentPosition = (long) 0;
    private boolean needResume;
    CustomMediaController mediaController;
    private Uri uri;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_video);
        mediaController = new CustomMediaController(this);
        Intent intent=getIntent();
        mLoadingLayout=(LinearLayout) findViewById(R.id.loading_LinearLayout);
        videoView = (io.vov.vitamio.widget.VideoView) findViewById(R.id.vv);
        mLoadingImg=(ImageView) findViewById(R.id.loading_image);
        uri = Uri.parse(intent.getStringExtra("playUrl"));
        initvideo();


    }

    private void initvideo() {
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setBufferSize(1024*1024);
        videoView.setVideoChroma(MediaPlayer.VIDEOQUALITY_HIGH);
    }

    public void onResume() {
        super.onResume();
        preparePlayVideo();
        if (mDanmakuView != null && mDanmakuView.isPrepared() && mDanmakuView.isPaused()) {
            mDanmakuView.resume();
        }

    }

    public io.vov.vitamio.widget.VideoView getVideoView() {
        return videoView;
    }


    public void preparePlayVideo() {

        startLoadingAnimator();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                stopLoadingAnimator();

                if (currentPosition > 0) {
                    videoView.seekTo(currentPosition);
                } else {
                    mediaPlayer.setPlaybackSpeed(1.0f);
                }
                startPlay();
            }
        });
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {
                switch (arg1) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        //开始缓存，暂停播放

                        startLoadingAnimator();
                        if (videoView.isPlaying()) {
                            stopPlay();
                            needResume = true;
                        }
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        //缓存完成，继续播放
                        stopLoadingAnimator();
                        if (needResume) startPlay();

                        break;

                }
                return true;
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
            }
        });
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });
        videoView.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(MediaPlayer mp) {
            }
        });
        videoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
            }
        });
    }




    @NonNull
    private void startLoadingAnimator() {
        if(mOjectAnimator==null){
            mOjectAnimator = ObjectAnimator.ofFloat(mLoadingImg, "rotation", 0f, 360f);
        }

        mLoadingLayout.setVisibility(View.VISIBLE);
        mOjectAnimator.setDuration(1000);
        mOjectAnimator.setRepeatCount(-1);
        mOjectAnimator.start();
    }
    public void stopLoadingAnimator() {
        mLoadingLayout.setVisibility(View.GONE);
        mOjectAnimator.cancel();
    }
    private void startPlay() {
        stopLoadingAnimator();
        videoView.start();
    }

    private void stopPlay() {
        videoView.pause();
    }

    public void onPause() {
        super.onPause();
        currentPosition = videoView.getCurrentPosition();
        videoView.pause();
        if (mDanmakuView != null && mDanmakuView.isPrepared()) {
            mDanmakuView.pause();
        }
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(videoView!=null){
            videoView.stopPlayback();
            videoView = null;
        }
        if (mDanmakuView != null) {
            // dont forget release!
            mDanmakuView.release();
            mDanmakuView = null;
        }


    }
    public Bitmap getCurrentFrame() {
        if(videoView!=null){
            MediaPlayer mediaPlayer = videoView.getmMediaPlayer();
            return  mediaPlayer.getCurrentFrame();
        }
        return null;
    }
    public void speedVideo() {
        if(videoView!=null){
            long duration = videoView.getDuration();
            long currentPosition = videoView.getCurrentPosition();
            long goalduration=currentPosition+duration/10;
            if(goalduration>=duration){
                videoView.seekTo(duration);
            }else{
                videoView.seekTo(goalduration);
            }
            Toast.makeText(this, StringUtils.generateTime(goalduration), Toast.LENGTH_SHORT).show();
        }
    }
    public void reverseVideo() {
        if(videoView!=null){
            long duration = videoView.getDuration();
            long currentPosition = videoView.getCurrentPosition();
            long goalduration=currentPosition-duration/10;
            if(goalduration<=0){
                videoView.seekTo(0);
            }else{
                videoView.seekTo(goalduration);
            }
            Toast.makeText(this, StringUtils.generateTime(goalduration), Toast.LENGTH_SHORT).show();
        }
    }
    public void setVideoPageSize(int currentPageSize) {
        if(videoView!=null){
            videoView.setVideoLayout(currentPageSize,0);
        }
    }


}
