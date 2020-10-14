package com.example.rentmandu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    ImageView img;
    TextView lowertv;

    Animation topAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img=(ImageView) findViewById(R.id.firstpageimage);
        lowertv=(TextView) findViewById(R.id.lowertv);
        img.setAnimation(topAnim);
        lowertv.setAnimation(bottomAnim);
        img.animate().alpha(4000).setDuration(0);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent dsp=new Intent(FirstActivity.this,MainActivity.class);
                startActivity(dsp);
                finish();

            }
        },4000);
    }
}