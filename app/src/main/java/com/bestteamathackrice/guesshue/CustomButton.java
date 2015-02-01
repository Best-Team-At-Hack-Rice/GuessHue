package com.bestteamathackrice.guesshue;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by johnking on 1/31/15.
 */
public class CustomButton extends Button {
    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(GlobalSettingsActivity.type);
        }
    }
}
