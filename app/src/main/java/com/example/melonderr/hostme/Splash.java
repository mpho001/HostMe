package com.example.melonderr.hostme;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Object;
import android.view.animation.AnimationUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;

public class Splash extends AppCompatActivity {
private TextView tv;
private ImageView iv;
//    AnimationUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread(){
            public void run()
            {
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
            }
                finally {
                                startActivity(intent);
                }
            }
        };
         timer.start();
    }
}
