package com.xacasoft.www.meteorwarrior;
import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class jeu extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView vieLabel;
    private ImageView hill2;
    private ImageView hill3;

    private ImageView hill4;
    private ImageView hill5;
    private ImageView hill6;
    private ImageView hill7;
    private ImageView hill8;
    private ImageView hill9;

    private int hill2Y;
    private int hill2X;
    private int hill3Y;
    private int hill3X;
    private int hill4Y;
    private int hill4X;
    private int hill5Y;
    private int hill5X;
    private int hill6Y;
    private int hill6X;
    private int hill7Y;
    private int hill7X;
    private int hill8Y;
    private int hill8X;
    private int hill9Y;
    private int hill9X;


    private int screenWidth;
    private int screenHeight;

    private int score =0;
    private int vie = 30;

    private Handler handler = new Handler();
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        vieLabel = (TextView) findViewById(R.id.vie);
        hill2 = (ImageView) findViewById(R.id.hil12);
        hill3 = (ImageView) findViewById(R.id.hil13);
        hill4 = (ImageView) findViewById(R.id.hil14);
        hill5 = (ImageView) findViewById(R.id.hil15);
        hill6 = (ImageView) findViewById(R.id.hil16);
        hill7 = (ImageView) findViewById(R.id.hil17);
        hill8 = (ImageView) findViewById(R.id.hil18);
        hill9 = (ImageView) findViewById(R.id.hil19);

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;


        hill2.setX(50);
        hill2.setY(50);
        hill3.setX(-150);
        hill3.setY(-150);
        hill4.setX(-150);
        hill4.setY(-150);

        hill5.setX(-150);
        hill5.setY(-150);
        hill6.setX(-150);
        hill6.setY(-150);
        hill7.setX(-150);
        hill7.setY(-150);
        hill8.setX(-150);
        hill8.setY(-150);
        hill9.setX(-150);
        hill9.setY(-150);


    ;
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        },0,20);


        hill2.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill2X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill2.getHeight() - hill2.getHeight()) + hill2.getHeight();
                    hill2Y = ii;
                    hill2.setX(hill2X);
                    hill2.setY(hill2Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill3.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill3X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill3.getHeight() - hill3.getHeight()) + hill3.getHeight();
                    hill3Y = ii;
                    hill3.setX(hill3X);
                    hill3.setY(hill3Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill4.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill2X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill4.getHeight() - hill4.getHeight()) + hill4.getHeight();
                    hill4Y = ii;
                    hill4.setX(hill4X);
                    hill4.setY(hill4Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill5.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill5X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill5.getHeight() - hill5.getHeight()) + hill5.getHeight();
                    hill5Y = ii;
                    hill5.setX(hill5X);
                    hill5.setY(hill5Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill6.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill6X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill6.getHeight() - hill6.getHeight()) + hill6.getHeight();
                    hill6Y = ii;
                    hill6.setX(hill6X);
                    hill6.setY(hill6Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill7.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill7X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill7.getHeight() - hill7.getHeight()) + hill7.getHeight();
                    hill7Y = ii;
                    hill7.setX(hill7X);
                    hill7.setY(hill7Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill8.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill8X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill8.getHeight() - hill8.getHeight()) + hill8.getHeight();
                    hill8Y = ii;
                    hill8.setX(hill8X);
                    hill8.setY(hill8Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });
        hill9.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    hill9X = screenWidth + 20;
                    Random r = new Random();
                    int ii = r.nextInt(screenHeight- hill9.getHeight() - hill9.getHeight()) + hill9.getHeight();
                    hill9Y = ii;
                    hill9.setX(hill9X);
                    hill9.setY(hill9Y);
                    score += 100;
                    scoreLabel.setText("Score : "+score);
                    return true;
                }
                else
                    return false;
            }
        });


    }

    public void changePos(){

        hill2X -=12;
        hill3X -=12;
        hill4X -=12;
        hill5X -=22;
        hill6X -=22;
        hill7X -=22;
        hill8X -=32;
        hill9X -=32;
        if(hill2X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill2X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight- hill2.getHeight() - hill2.getHeight()) + hill2.getHeight();
            hill2Y = ii;
        }
        if(hill3X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill3X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight- hill3.getHeight() - hill3.getHeight()) + hill3.getHeight();
            hill3Y = ii;
        }
        if(hill4X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill4X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight-50 - 50) + 50;
            hill4Y = ii;
        }
        if(hill5X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill5X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight-50 - 50) + 50;
            hill5Y = ii;
        }
        if(hill6X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill6X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight-50 - 50) + 50;
            hill6Y = ii;
        }
        if(hill7X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill7X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight-50 - 50) + 50;
            hill7Y = ii;
        }
        if(hill8X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill8X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight-50 - 50) + 50;
            hill8Y = ii;
        }
        if(hill9X < 0 ){
            vie--;
            vieLabel.setText("Vie : "+vie);
            if(vie<1){
                timer.cancel();
                timer=null;
                Intent intent = new Intent(getApplicationContext(),resultat.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
                return ;
            }
            hill9X = screenWidth + 20;
            Random r = new Random();
            int ii = r.nextInt(screenHeight-50 - 50) + 50;
            hill9Y = ii;
        }
        hill2.setX(hill2X);
        hill2.setY(hill2Y);
        hill3.setX(hill3X);
        hill3.setY(hill3Y);
        hill4.setX(hill4X);
        hill4.setY(hill4Y);

        hill5.setX(hill5X);
        hill5.setY(hill5Y);
        hill6.setX(hill6X);
        hill6.setY(hill6Y);
        hill7.setX(hill7X);
        hill7.setY(hill7Y);
        hill8.setX(hill8X);
        hill8.setY(hill8Y);
        hill9.setX(hill9X);
        hill9.setY(hill9Y);

    }
}
