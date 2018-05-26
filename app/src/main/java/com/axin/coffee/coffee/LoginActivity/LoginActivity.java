package com.axin.coffee.coffee.LoginActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.VideoView;

import com.axin.coffee.coffee.R;

public class LoginActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private VideoView mVideoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        initVideoView();
    }

    private void initVideoView() {
        //设置屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mqr));
        //设置相关的监听
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnCompletionListener(this);
    }

    //播放准备
    @Override
    public void onPrepared(MediaPlayer mp) {
        //开始播放
        mVideoView.start();
    //    mHandler.postDelayed(runnable, TIME);
    }

    //播放结束
    @Override
    public void onCompletion(MediaPlayer mp) {
        //开始播放
        mVideoView.start();
    }
}

