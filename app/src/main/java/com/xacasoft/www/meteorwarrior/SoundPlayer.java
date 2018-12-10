package com.xacasoft.www.meteorwarrior;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RequiresApi;


class SoundPlayer {

    private AudioAttributes audioAttributes;
    private final int SOUND_POOL_MAX = 2;
    private static SoundPool soundPool;

    private static int hitSound;
    private static int  endSound;

    private static MediaPlayer mediaPlayer;
    private static MediaPlayer mediaPlayerMenu;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SoundPlayer(Context context){

        mediaPlayer =  MediaPlayer.create(context,R.raw.back);
        mediaPlayerMenu =  MediaPlayer.create(context,R.raw.back2);
        //soundPool = new SoundPool(2,AudioManager.STREAM_MUSIC,0);
        audioAttributes= new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(SOUND_POOL_MAX)
                .build();

        hitSound = soundPool.load(context,R.raw.hit,1);
        endSound = soundPool.load(context,R.raw.end,1);

    }

    public void playHitSound(){

        soundPool.play(hitSound,1.0f,1.0f,1,0,1.0f);
    }

    public void playEndSound(){

        soundPool.play(endSound,1.0f,1.0f,1,0,1.0f);
    }

    public void playBackSoundGAME(){
        if(mediaPlayer!= null) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }

    public void stopBackSoundGAME(){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            //mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    public void playBackSoundMenu(){
        if(mediaPlayerMenu!= null) {
            mediaPlayerMenu.start();
            mediaPlayerMenu.setLooping(true);
        }
    }

    public void stopBackSoundMenu(){
        if ( mediaPlayerMenu != null) {
            mediaPlayerMenu.stop();
            //mediaPlayerMenu.reset();
            mediaPlayerMenu.release();
            mediaPlayerMenu=null;
        }
    }

}
