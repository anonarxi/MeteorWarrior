package com.xacasoft.www.meteorwarrior;
import android.content.Intent;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class jeu extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView vieLabel;
    final private int nb_proj = 3;
    final private int screen_div = 12;
    final private int proj_type = R.drawable.star;
    private List<Integer> screenW = new ArrayList<Integer>();
    private List<Integer> screenH = new ArrayList<Integer>();
    private ImageView[] Projectile= new ImageView[nb_proj];
    private int[] speed = new int[nb_proj];

    private int screenWidth;
    private int screenHeight;
    private int maxsp =40;
    private int minsp =30;
    private int score =0;
    private int vie = 5;
    private float vitesse =0;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private Timer timer3 = new Timer();
    private static SoundPlayer sound;

    private int pnjId[]={R.drawable.adventurer_idle_2_00,R.drawable.adventurer_air_attack1_00,R.drawable.adventurer_air_attack1_01,R.drawable.adventurer_air_attack1_02,R.drawable.adventurer_air_attack1_03};
    private int frame=0;
    private  ImageView hero = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        FrameLayout rl = (FrameLayout) findViewById(R.id.baselevel);
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        destroyit touchListener = new destroyit();
        FrameLayout.LayoutParams lp;
        int i;
        for(i=0;i<=screen_div;i++){
            screenW.add( Math.round( (screenWidth/12.0f)*i)  );
            screenH.add( Math.round((screenHeight/12.0f)*i)  );
        }

        sound = new SoundPlayer(this);
        sound.playBackSoundGAME();

        scoreLabel =  findViewById(R.id.scoreLabel);
        vieLabel = findViewById(R.id.vie);
        scoreLabel.setText("Score : "+score);
        vieLabel.setText("Vie : "+vie);
        Random r= new Random();

        hero = new ImageView(getApplicationContext());
        hero.setImageResource(R.drawable.adventurer_idle_2_00);
        lp = new FrameLayout.LayoutParams(screenW.get(4) , screenH.get(4));
        lp.setMargins(0,screenH.get(7),0,0);
        hero.setLayoutParams(lp);
        rl.addView(hero);

        for(i=0;i<nb_proj;i++) {
            Projectile[i] = new ImageView(getApplicationContext());
            Projectile[i].setImageResource(proj_type);
            speed[i] = r.nextInt(maxsp-minsp)+minsp;
            lp = new FrameLayout.LayoutParams(screenW.get(screen_div/nb_proj) , screenH.get(screen_div/nb_proj));
            lp.setMargins(screenW.get(screen_div-1),screenH.get(( (screen_div-2)/nb_proj )*(i+1)),0,0);
            Projectile[i].setLayoutParams(lp);
            Projectile[i].setId(i);
            Projectile[i].setOnTouchListener(touchListener);
            rl.addView(Projectile[i]);
        }

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
       // timer3.schedule(new Task3(), 1000);
    }

    public class destroyit implements View.OnTouchListener {
        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            Random r=new Random();
            int tmpi;
            if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
                ImageView tmp = findViewById(arg0.getId());
                hero.setY(tmp.getY());
                timer3.schedule(new Task3(), 50);
                tmp.setX(screenW.get(screen_div));
                tmpi=r.nextInt(nb_proj);
                tmp.setY(screenH.get(( (screen_div-2)/nb_proj )* tmpi));
                if(vitesse < 20) {
                    vitesse+=0.5;
                }
                score += 100;
                scoreLabel.setText("Score : "+score);
                sound.playHitSound();
                return true;
            }
            else
                return false;

        }

    }


    public void changePos(){
        int i,tmp;
        Random r= new Random();
        for(i=0;i<nb_proj;i++) {

            Projectile[i].setX(Projectile[i].getX()-speed[i] );
            if(Projectile[i].getX() < 0 ){
                vie--;
                vieLabel.setText("Vie : "+vie);
                if(vie<1){
                    sound.playEndSound();
                    sound.stopBackSoundGAME();
                    Intent intent = new Intent(getApplicationContext(),resultat.class);
                    intent.putExtra("SCORE",score);
                    if(timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timer3 != null) {
                        timer3.cancel();
                        timer3=null;
                    }
                    startActivity(intent);
                    return ;
                }
                Projectile[i].setX(screenW.get(screen_div));
                speed[i] = r.nextInt(maxsp+(int)vitesse-(minsp+(int)vitesse))+minsp + (int)vitesse;
                tmp=r.nextInt(nb_proj-1)+1;
                Projectile[i].setY(screenH.get(( (screen_div-2)/nb_proj )* tmp));
            }
        }
    }

    public class Task3 extends TimerTask {
        @Override
        public void run() {
            if(frame <= 4) {
                frame++;
            }
            hero.post(new Runnable() {
                @Override
                public void run() {
                    if(frame < 5) {
                        hero.setImageResource(pnjId[frame]);
                    }
                }
            });
            if(frame < 5){
                if(timer3 != null) {
                    timer3.schedule(new Task3(), 50);
                }
            }
            else{
                frame=0;
            }

        }
    }
}
