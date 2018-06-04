package com.axin.coffee.coffee.LoginActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.axin.coffee.MainActivity.MainActivity;
import com.axin.coffee.RegisterActivity.RsgisterActivity;
import com.axin.coffee.coffee.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    @BindView(R.id.sig_in)
    Button sigIn;
    @BindView(R.id.register)
    TextView register;
    private VideoView mVideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        initVideoView();
    }

    private void initVideoView() {
        //设置屏幕常亮
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.login_movie));
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


    @OnClick({R.id.sig_in, R.id.register})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.sig_in:
                //Intent intent = new Intent();
                //intent.putExtra("testIntent", "123");
                intent.setClass(LoginActivity.this, MainActivity.class); //设置跳转的Activity
                LoginActivity.this.startActivity(intent);
                break;
            case R.id.register:
                intent.setClass(LoginActivity.this, RsgisterActivity.class); //设置跳转的Activity
                LoginActivity.this.startActivity(intent);
                break;
        }
    }
}

