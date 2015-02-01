package com.bestteamathackrice.guesshue;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;


public class Round extends ActionBarActivity {
    private long current_time;
    private Intent score_intent;
    private TextView time_display;
    private CountDownTimer countdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        current_time = 30000;
        score_intent = new Intent(this, Score.class);
        time_display = (TextView) findViewById(R.id.count_down_text_round);
    }

    @Override
    protected void onResume(){

        super.onResume();

        countdown = new CountDownTimer(current_time, 1000) {

            public void onTick(long millisUntilFinished) {
                current_time = millisUntilFinished;
                time_display.setText("seconds remaining: " + current_time / 1000);
            }

            public void onFinish() {
                time_display.setText("done!");
                startActivity(score_intent);
            }

        }.start();

    }

    @Override
    protected void onStop(){
        super.onStop();
        countdown.cancel();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_round, menu);
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

    public void dispatchApprovalActivity(View view) {
        Intent intent = new Intent(this, Approval.class);
        intent.putExtra("time_left", current_time);
        startActivity(intent);
    }
}
