package org.wlf.filedownloader_demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.wlf.filedownloader.DownloadFileInfo;
import org.wlf.filedownloader.FileDownloader;
import org.wlf.filedownloader.listener.OnFileDownloadStatusListener;
import org.wlf.filedownloader.listener.OnRetryableFileDownloadStatusListener;

public class Main2Activity extends Activity implements OnRetryableFileDownloadStatusListener{
    TextView progress;
    private String url1="http://apkvod-cnc.wasu.cn/201608081343/58dfc65a4abaf063bc1bcec75e9cc271/pcsan12/mams/vod/201608/05/23/20160805230237150187b10ee_31107621.mp4?k=a57731beed43d5104556668883010196&su=NFK7qhxp8ik5jwAUdfOBvQ==&uid=5192ccf658a9ec96506034db03f4560f&tn=25476259&t=8ca67737ceed524874945b11e7e26028&v=2&src=xw&cid=37&vid=7782578&WS00002=10101&em=3";
    private String url2="http://apkvod-cnc.wasu.cn/201608081343/58dfc65a4abaf063bc1bcec75e9cc271/pcsan12/mams/vod/201608/05/23/20160805230237150187b10ee_31107621.mp4?k=ac2cd19b549aec19387b5429e7fa6acf&su=jVbDdWQ5QTWlMZiyUqTqmg==&uid=36d521e0daf6a33aa959b3f7e6b89b8d&tn=86371348&t=8ca67737ceed524874945b11e7e26028&v=2&src=xw&cid=37&vid=7782578&WS00002=10101&em=3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progress = (TextView) findViewById(R.id.progress);
        FileDownloader.registerDownloadStatusListener(this);

        Button button1 = (Button) findViewById(R.id.start);
        Button button2 = (Button) findViewById(R.id.start1);
        Button pause1 = (Button) findViewById(R.id.pause);
        Button pause2 = (Button) findViewById(R.id.pause1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileDownloader.start(url1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileDownloader.start(url2);
            }
        });
        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileDownloader.pause(url1);
            }
        });
        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileDownloader.pause(url2);
            }
        });
    }

    @Override
    public void onFileDownloadStatusRetrying(DownloadFileInfo downloadFileInfo, int retryTimes) {

    }

    @Override
    public void onFileDownloadStatusWaiting(DownloadFileInfo downloadFileInfo) {

    }

    @Override
    public void onFileDownloadStatusPreparing(DownloadFileInfo downloadFileInfo) {

    }

    @Override
    public void onFileDownloadStatusPrepared(DownloadFileInfo downloadFileInfo) {

    }

    @Override
    public void onFileDownloadStatusDownloading(final DownloadFileInfo downloadFileInfo, float downloadSpeed, long remainingTime) {
        Log.e(downloadFileInfo.getId()+"",downloadFileInfo.getDownloadedSizeLong()+"/"+downloadFileInfo.getFileSizeLong());
    }

    @Override
    public void onFileDownloadStatusPaused(DownloadFileInfo downloadFileInfo) {

    }

    @Override
    public void onFileDownloadStatusCompleted(DownloadFileInfo downloadFileInfo) {

    }

    @Override
    public void onFileDownloadStatusFailed(String url, DownloadFileInfo downloadFileInfo, FileDownloadStatusFailReason failReason) {
        Log.e("error",failReason.getMessage());
    }
}
