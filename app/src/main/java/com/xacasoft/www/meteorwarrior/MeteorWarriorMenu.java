package com.xacasoft.www.meteorwarrior;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MeteorWarriorMenu extends AppCompatActivity {
    List<Integer> screenW = new ArrayList<Integer>();
    List<Integer> screenH = new ArrayList<Integer>();




    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_meteor_warrior_menu);
        FrameLayout rl = (FrameLayout) findViewById(R.id.base);
        final ImageView s1 = new ImageView(getApplicationContext());
        s1.setImageResource(R.drawable.star4);
        s1.setId(0);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int Swidth = size.x;
        final int Sheight = size.y;
        int i,j;
        for(i=0;i<=12;i++){
            screenW.add( Math.round( (Swidth/12.0f)*i)  );
            screenH.add( Math.round((Sheight/12.0f)*i)  );
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(screenW.get(1),screenW.get(1));
        lp.setMargins(0,screenH.get(2),0,0);
        //Log.d("tagdeb", "Value: " + Float.toString(Sheight));
        s1.setLayoutParams(lp);
        final Animation rotation,rotationo;
        rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        rotationo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotateonly);
        //rotation.setRepeatCount(Animation.INFINITE);
        s1.startAnimation(rotation);
        rl.addView(s1);
        rotation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
            }
        });
    /*
       class starvariety implements Runnable {
            Random r = new Random();
            final int imgId[]={R.drawable.star2,R.drawable.star3,R.drawable.star4};
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(rotation.getDuration());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    final int colors = r.nextInt(3) ;
                    s1.post(new Runnable() {
                        @Override
                        public void run() {
                            s1.setImageResource(imgId[colors]);
                        }
                    });
                }
            };};
        Thread t = new Thread(new starvariety());
        t.start();
        */
        ImageView supp = new ImageView(getApplicationContext());
        supp.setImageResource(R.drawable.hilshad);
        lp = new FrameLayout.LayoutParams(screenW.get(6) , screenH.get(6));
        lp.setMargins(-screenW.get(1),screenH.get(9),0,0);
        supp.setLayoutParams(lp);
        rl.addView(supp);

        ImageView supp2 = new ImageView(getApplicationContext());
        supp2.setImageResource(R.drawable.flamedemon);
        lp = new FrameLayout.LayoutParams(screenW.get(6), screenH.get(6));
        lp.setMargins(screenW.get(7),screenH.get(7),0,0);
        supp2.setLayoutParams(lp);
        rl.addView(supp2);

        ImageView supp3 = new ImageView(getApplicationContext());
        supp3.setImageResource(R.drawable.penguin);
        lp = new FrameLayout.LayoutParams(screenW.get(4) , screenH.get(4));
        lp.setMargins(0,screenH.get(7),0,0);
        supp3.setLayoutParams(lp);
        rl.addView(supp3);

        ImageView supp4 = new ImageView(getApplicationContext());
        supp4.setImageResource(R.drawable.star);
        lp = new FrameLayout.LayoutParams(screenW.get(6) , screenH.get(6));
        lp.setMargins(screenW.get(3),screenH.get(4),0,0);
        supp4.setLayoutParams(lp);
        supp4.startAnimation(rotationo);
        rl.addView(supp4);
    }



}