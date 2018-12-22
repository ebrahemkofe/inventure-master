package com.example.android.inventure.findhome_amir;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by aswany on 12/16/18.
 */

public class MySpannable extends ClickableSpan {
    private boolean isUnderline = false;

    /**
     * Constructor
     */
    public MySpannable(boolean isUnderline) {
        this.isUnderline = isUnderline;
    }

    @Override
    public void updateDrawState(TextPaint ds) {

        ds.setUnderlineText(isUnderline);
        ds.setColor(Color.parseColor("#5eaefc"));

    }

    @Override
    public void onClick(View widget) {

    }
}

