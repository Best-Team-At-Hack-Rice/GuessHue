package com.bestteamathackrice.guesshue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FinalScore extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        TextView finalScoreDisplay = (TextView) findViewById(R.id.final_score);
        

        finalScoreDisplay.setText(Integer.toString(DataMule.totalScore));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_final_score, menu);
        return true;
    }

    @Override
    public void onBackPressed() {}

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

//    public void dispatchMainActivity(View view){
//        Intent mainIntent = new Intent(this, MainActivity.class);
//        startActivity(mainIntent);
//    }

    public void submitScore(View view) {
        // Get the initials from the player
        EditText initials = (EditText) findViewById(R.id.enter_initials);
        String name = initials.getText().toString();

        // Put the name/score of the user in our leaderboard (if it's high enough)
        ArrayList<String> highScores = persistScore(name);

        // Redirect to the High Scores activity
        Intent scoresIntent = new Intent(this, HighScores.class);
//        scoresIntent.putStringArrayListExtra("HIGH_SCORES", highScores);
        startActivity(scoresIntent);
    }


    public ArrayList<String> persistScore(String name) {
        // Connect to our Shared Preferences
        SharedPreferences scorePrefs = getSharedPreferences(MainActivity.GAME_PREFS, 0);

        // Get a List of the high scores from the shared preferences
        Set<String> highScoresSet = scorePrefs.getStringSet("highScores", null);
        ArrayList<String> highScoresArray = new ArrayList<>(highScoresSet);

        // Sort the high scores by score, inserting the new score where appropriate
        return sortHighScores(highScoresArray, name, scorePrefs);
    }


    public ArrayList<String> sortHighScores(ArrayList<String> highScoresArray, String name,
                                            SharedPreferences scorePrefs) {
        // Parse each string into a name and score, putting the resulting PlayerScore object in an
        // ArrayList
        ArrayList<PlayerScore> playerScores = new ArrayList<>();
        for (String playerScore : highScoresArray) {
            String[] tuple = playerScore.split(" ");
            playerScores.add(new PlayerScore(tuple[0], Integer.parseInt(tuple[1])));
        }

        // Now add the new score, and sort
        playerScores.add(new PlayerScore(name, DataMule.totalScore));
        Collections.sort(playerScores);

        // Whatever score is lowest will be culled
        if (playerScores.size() > 10) {
            playerScores.remove(10);
        }

        // Convert the values back to a set of strings, then persist to Shared Preferences
        ArrayList<String> resultantList = new ArrayList<>();
        for (PlayerScore playerScore : playerScores) {
            String resultantString = playerScore.getName() + " " + playerScore.getScore();
            resultantList.add(resultantString);
        }
        Set<String> resultantSet = new HashSet<>(resultantList);

        SharedPreferences.Editor editor = scorePrefs.edit();
        editor.putStringSet("highScores", resultantSet);
        editor.commit();

        // Return our ArrayList of Strings to be used by the hih scores activity
        return resultantList;
    }
}
