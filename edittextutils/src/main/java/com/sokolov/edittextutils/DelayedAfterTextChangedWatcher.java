package com.sokolov.edittextutils;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

public class DelayedAfterTextChangedWatcher implements TextWatcher {

    private final TextWatcher origin;
    private final Long delayInMills;
    private final Handler handler = new Handler();

    private Runnable runnable;

    public DelayedAfterTextChangedWatcher(TextWatcher origin) {
        this.origin = origin;
        delayInMills = 150L;
        runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public DelayedAfterTextChangedWatcher(TextWatcher origin, Long delayInMills) {
        this.origin = origin;
        this.delayInMills = delayInMills;
        runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        origin.beforeTextChanged(s, start, count, after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        origin.onTextChanged(s, start, before, count);
    }

    @Override
    public void afterTextChanged(final Editable s) {
        handler.removeCallbacks(runnable);
        runnable =
                new Runnable() {
                    @Override
                    public void run() {
                        origin.afterTextChanged(s);
                    }
                };
        handler.postDelayed(runnable, delayInMills);
    }
}