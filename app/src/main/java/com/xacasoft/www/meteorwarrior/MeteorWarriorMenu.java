package com.xacasoft.www.meteorwarrior;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
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

import 	android.view.View;

import android.animation.ObjectAnimator;
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
        s1.setImageResource(R.drawable.hil);
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
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(screenW.get(3),screenW.get(3));
        lp.setMargins(0,screenH.get(2),0,0);
        //Log.d("tagdeb", "Value: " + Float.toString(Sheight));
        s1.setLayoutParams(lp);
        final ObjectAnimator animation = ObjectAnimator.ofFloat(s1, "translationX", 2000f);
        animation.setDuration(3000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.start();

        rl.addView(s1);

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



    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(MeteorWarriorMenu.this, jeu.class);
        startActivity(intent);
    }



}