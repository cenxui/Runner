package com.xenxui.mylibrary;

import android.graphics.Color;

/**
 * Created by xenxui on 2015/9/2.
 */
public class ChartBarData implements ChartData {
    private String mName;
    private int mColor = Color.GREEN;
    private int mCount = 50;
    private int mAlpha = 50;

    @Override
    public ChartData setAlpha(int alpha) {
        mAlpha = alpha;
        return this;
    }

    @Override
    public ChartData setName(String name) {
        mName = name;
        return this;
    }

    @Override
    public ChartData setColor(int color) {
        mColor = color;
        return this;
    }

    @Override
    public ChartData setCount(int count) {
        mCount = count;
        return this;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public int getColor() {
        return mColor;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public int getPercent() {
        return 0;
    }

    @Override
    public ChartData setPercent(int percent) {
        return this;
    }

    @Override
    public int getAlpha() {
        return mAlpha;
    }
}
