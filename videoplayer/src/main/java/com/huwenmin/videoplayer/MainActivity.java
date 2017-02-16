package com.huwenmin.videoplayer;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG="MainActivity";
    private VideoView mVideoView;
    private MediaController mMediaController;
    String path= Environment.getExternalStorageDirectory()+"/wasu/download/hd.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplicationContext());
        setContentView(R.layout.activity_main);
        mVideoView= (VideoView) findViewById(R.id.video_view);
        Intent intent =getIntent();
        String action=intent.getAction();
        if (intent.ACTION_VIEW.equals(action)){
            Uri uri=intent.getData();
            Cursor cursor=getContentResolver().query(uri,null,null,null,null);
            if (cursor.moveToFirst()){
                path =cursor.getString(cursor.getColumnIndex("_data"));
            }
        }
        mVideoView.setVideoPath(path);
        mMediaController=new MediaController(this);
        mMediaController.show(3000);
        mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mVideoView.requestFocus();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
