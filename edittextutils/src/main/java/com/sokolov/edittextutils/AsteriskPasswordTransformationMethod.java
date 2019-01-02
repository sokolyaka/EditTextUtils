package com.sokolov.edittextutils;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        return new PasswordCharSequence(source);
    }

    private static class PasswordCharSequence implements CharSequence {
        private final CharSequence mSource;

        private PasswordCharSequence(CharSequence source) {
            mSource = source;
        }

        public char charAt(int index) {
            return '*';
        }

        public int length() {
            return mSource.length();
        }

        public CharSequence subSequence(int start, int end) {
            return mSource.subSequence(start, end);
        }

        @Override
        public String toString() {
            return mSource.toString();
        }
    }
}