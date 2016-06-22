package com.xenxui.mylibrary;

/**
 * Created by xenxui on 2015/9/2.
 */
public class ChartCircleData implements ChartData {
    private String mName;
    private int mColor;
    private int mCount;
    private int mAlpha;
    private int mPercent;
    @Override
    public ChartData setName(String s) {
        mName = s;
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
    public ChartData setAlpha(int alpha) {
        mAlpha = alpha;
        return this;
    }

    @Override
    public ChartData setPercent(int percent) {
        mPercent = percent;
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
    public int getAlpha() {
        return mAlpha;
    }

    @Override
    public int getPercent() {
        return mPercent;
    }
}
