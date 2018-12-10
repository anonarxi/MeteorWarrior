package com.xacasoft.www.meteorwarrior;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class resultat extends AppCompatActivity {

    private static SoundPlayer sound;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        setContentView(R.layout.activity_resultat);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        TextView scoreLab = findViewById(R.id.score);
        TextView highScoreLabel = findViewById(R.id.highscoreLabel);

        sound = new SoundPlayer(this);
        sound.playBackSoundGAME();

        int score = getIntent().getIntExtra("SCORE",0);
        scoreLab.setText("Score : "+score);

        SharedPreferences settings = getSharedPreferences("GAME_DATA",Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE",0);

        if(score > highScore){
            highScoreLabel.setText("Hight score : "+score);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }
        else{
            highScoreLabel.setText("High score : " + highScore);
        }
    }

    public void tryagain(View view){
        sound.stopBackSoundGAME();
        startActivity(new Intent(getApplicationContext(),jeu.class));
    }

    public void menu(View view){
        sound.stopBackSoundGAME();
        startActivity(new Intent(getApplicationContext(),MeteorWarriorMenu.class));
    }

}
