package com.example.rentmandu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView=(CardView) findViewById(R.id.findService);

        videoView=(VideoView) findViewById(R.id.video_view);
        String videoPath= "android.resource://" + getPackageName() + "/" + R.raw.demoforrentmandu;
        Uri uri=Uri.parse(videoPath);
        videoView.setVideoPath(String.valueOf(uri));
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
}