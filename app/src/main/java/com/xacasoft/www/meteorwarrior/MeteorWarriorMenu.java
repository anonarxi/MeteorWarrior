package com.xacasoft.www.meteorwarrior;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import 	android.view.View;

public class MeteorWarriorMenu extends AppCompatActivity {
    List<Integer> screenW = new ArrayList<Integer>();
    List<Integer> screenH = new ArrayList<Integer>();
    Handler handler = new Handler();

    private static SoundPlayer sound;

    private  ImageView supp4 = null;
    private  ImageView supp5 = null;
    private  ImageView supp3 = null;
    private int time=1000;
    private int time2=1000;
    private Timer timer = new Timer();
    private Timer timer2 = new Timer();
    private Timer timer3 = new Timer();
    private int pnjId[]={R.drawable.adventurer_idle_2_00,R.drawable.adventurer_idle_2_01,R.drawable.adventurer_idle_2_02,R.drawable.adventurer_idle_2_03};
    private int frame=0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_meteor_warrior_menu);
        FrameLayout rl = (FrameLayout) findViewById(R.id.base);
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
        sound = new SoundPlayer(this);
        sound.playBackSoundMenu();

        ImageView supp = new ImageView(getApplicationContext());
        supp.setImageResource(R.drawable.hilshad);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(screenW.get(6) , screenH.get(6));
        lp.setMargins(-screenW.get(1),screenH.get(9),0,0);
        supp.setLayoutParams(lp);
        rl.addView(supp);

        ImageView supp2 = new ImageView(getApplicationContext());
        supp2.setImageResource(R.drawable.flamedemon);
        lp = new FrameLayout.LayoutParams(screenW.get(6), screenH.get(6));
        lp.setMargins(screenW.get(7),screenH.get(7),0,0);
        supp2.setLayoutParams(lp);
        rl.addView(supp2);

        supp3 = new ImageView(getApplicationContext());
        supp3.setImageResource(R.drawable.adventurer_idle_2_00);
        lp = new FrameLayout.LayoutParams(screenW.get(4) , screenH.get(4));
        lp.setMargins(0,screenH.get(7),0,0);
        supp3.setLayoutParams(lp);
        rl.addView(supp3);

        supp4 = new ImageView(getApplicationContext());
        supp4.setImageResource(R.drawable.star);
        lp = new FrameLayout.LayoutParams(screenW.get(2) , screenH.get(2));
        lp.setMargins(screenW.get(0),screenH.get(0),0,0);
        supp4.setLayoutParams(lp);
        rl.addView(supp4);
        supp5 = new ImageView(getApplicationContext());
        supp5.setImageResource(R.drawable.star);
        lp = new FrameLayout.LayoutParams(screenW.get(2) , screenH.get(2));
        lp.setMargins(screenW.get(0),screenH.get(2),0,0);
        supp5.setLayoutParams(lp);

        rl.addView(supp5);
        timer.schedule(new Task(), time);
        timer2.schedule(new Task2(), time2);
        timer3.schedule(new Task3(), 1000);
    }

    public void sendMessage(View view)
    {

        Intent intent = new Intent(MeteorWarriorMenu.this, jeu.class);
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timer2 != null) {
            timer2.cancel();
            timer2 = null;
        }
        if (timer3 != null) {
            timer3.cancel();
            timer3=null;
        }
        sound.stopBackSoundMenu();
        startActivity(intent);
    }

    public class Task extends TimerTask {
            Random r = new Random();
            Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
            @Override
            public void run() {
                time = r.nextInt(1000)+1000 ;
                rotation.setDuration(time);
                supp4.post(new Runnable() {
                    @Override
                    public void run() {
                        supp4.startAnimation(rotation);
                    }
                });
                timer.schedule(new Task(), time);
        }
    }

    public class Task2 extends TimerTask {
        Random r = new Random();
        Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        @Override
        public void run() {
            time2 = r.nextInt(1000)+1000 ;
            rotation.setDuration(time2);

            supp5.post(new Runnable() {
                @Override
                public void run() {
                    supp5.startAnimation(rotation);
                }
            });
            timer2.schedule(new Task2(), time2);
        }
    }

    public class Task3 extends TimerTask {
        @Override
        public void run() {
            frame++;
            if (frame>3)frame=0;
            supp3.post(new Runnable() {
                @Override
                public void run() {
                    supp3.setImageResource(pnjId[frame]);
                }
            });
            timer3.schedule(new Task3(), 100);
        }
    }

}