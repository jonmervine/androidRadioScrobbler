package com.darkmage530.androidRadioScrobbler;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * User: Jon
 * Date: 6/22/14
 * Time: 9:35 PM
 */
public class MusicPlayer extends Activity {
    private final static Logger log = LoggerFactory.getLogger(MusicPlayer.class);
    private MediaPlayer mPlayer = new MediaPlayer();
    private static final String animeNfoStreamURL = "http://momori.animenfo.com:8000/";

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.mediaplayer);
        log.info("started layout");
        try {
            mPlayer.setDataSource(animeNfoStreamURL);
            log.info("set datasource");
        } catch (IOException e) {
            log.error("Could not set DataSource", e.getMessage());
        }
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        log.info("set audio stream type");
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        log.info("set volume control stream");
    }

    @Override
    public void onStop() {
        super.onStop();
        mPlayer.release();
    }

    private void preparePlayer() {
        try {
            mPlayer.prepare();
            log.info("player prepared successfully");
        } catch (IOException e) {
            log.error("Could not prepare mediaPlayer", e.getMessage());
        }
    }

    public void startPlayback(View view) {
        log.info("start button press, attempt to prepare player");
        preparePlayer();
        mPlayer.start();
        log.info("mplayer started successfully");
        if (mPlayer.isPlaying()) {
            log.info("Player is successfully playing music");
        } else {
            log.error("something wrong happened and is not streaming music");
        }
    }

    public void stopPlayback(View view) {
        log.info("attempt to stop playback");
        mPlayer.stop();
        if (mPlayer.isPlaying()) {
            log.error("something wrong happened and music is still playing");
        } else {
            log.info("play back stopped");
        }
    }
}
