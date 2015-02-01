package com.bestteamathackrice.guesshue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends GlobalSettingsActivity {

    public static final String GAME_PREFS = "GuessHuePrefs";
    MediaPlayer mainMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        SharedPreferences prefs = getSharedPreferences(GAME_PREFS, 0);
//        SharedPreferences.Editor editor = prefs.edit();
//        List<String> myStrings = Arrays.asList(new String[] {"jfk 123", "mbh 1423", "othr 243"});
//        Set<String> myStringsSet = new HashSet<String>(myStrings);
//        editor.putStringSet("highScores", myStringsSet);
//        editor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainMusic = MediaPlayer.create(MainActivity.this, R.raw.main_music);
        mainMusic.setLooping(true);
        mainMusic.start();
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startGame(View view) {
//        PlayerScore score1 = new PlayerScore("jfk", 123);
//        PlayerScore score2 = new PlayerScore("mbh", 321);
//        List<PlayerScore> scoreStrings = new ArrayList<>();
//        scoreStrings.add(score1);
//        scoreStrings.add(score2);
//        Collections.sort(scoreStrings);
//        String highScores = score1.getName() + " " + score1.getScore() + "|" + score2.getName() + " " + score2.getScore();
//        SharedPreferences gamePrefs = getSharedPreferences(GAME_PREFS, 0);;
//        SharedPreferences.Editor scoreEdit = gamePrefs.edit();
//        scoreEdit.putString("highScores", highScores);
//        scoreEdit.commit();

        DataMule.totalRound = 0;
        DataMule.totalScore = 0;
        Intent intent = new Intent(this, Round.class);
        startActivity(intent);
    }


    public void viewHighScores(View view) {
        Intent highIntent = new Intent(this, HighScores.class);
        startActivity(highIntent);
    }
}
