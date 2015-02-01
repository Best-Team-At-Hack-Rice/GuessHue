package com.bestteamathackrice.guesshue;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Our subclass of a general activity that includes our UI settings.
 */
public class GlobalSettingsActivity extends ActionBarActivity {
    protected static Typeface type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = Typeface.createFromAsset(getAssets(), "fonts/ropasansregular.ttf");
        setContentView(R.layout.activity_global_settings);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
