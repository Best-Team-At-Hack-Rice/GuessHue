package com.bestteamathackrice.guesshue;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Subclass of buttons that have our custom UI settings.
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
