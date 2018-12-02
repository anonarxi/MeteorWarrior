package com.xacasoft.www.meteorwarrior;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
public class resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        setContentView(R.layout.activity_resultat);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        TextView scoreLab = (TextView) findViewById(R.id.score);
        TextView highScoreLabel = (TextView) findViewById(R.id.highscoreLabel);

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
        startActivity(new Intent(getApplicationContext(),jeu.class));

    }


}
