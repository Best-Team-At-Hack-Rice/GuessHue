package com.bestteamathackrice.guesshue;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Score extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        if(DataMule.totalRound >= 3){
            Button button = (Button) findViewById(R.id.next_round_button);
            button.setText("Final Score");
        }

        TextView score_display = (TextView) findViewById(R.id.score_display);
        int roundScore = (int) getIntent().getExtras().get("round_score");
        score_display.setText(Integer.toString(roundScore));
    }

    @Override
    public void onBackPressed(){
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score, menu);
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

    public void dispatchRoundActivity(View view){
        if(DataMule.totalRound >= 3){
            Intent finalScoreIntent = new Intent(this, FinalScore.class);
            startActivity(finalScoreIntent);
        }else{
            Intent roundIntent = new Intent(this, Round.class);
            startActivity(roundIntent);
        }

    }
}
