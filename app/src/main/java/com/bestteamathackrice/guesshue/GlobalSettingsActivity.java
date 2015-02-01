package com.bestteamathackrice.guesshue;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class GlobalSettingsActivity extends ActionBarActivity {
    protected Typeface type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = Typeface.createFromAsset(getAssets(), "fonts/ropasansregular.ttf");
        setContentView(R.layout.activity_global_settings);
    }
}
