package com.xenxui.mylibrary;

/**
 * Created by xenxui on 2015/9/2.
 */
public interface ChartData {
    ChartData setName(String s);
    ChartData setColor(int color);
    ChartData setCount(int count);
    ChartData setAlpha(int alpha);
    ChartData setPercent(int percent);
    String getName();
    int getColor();
    int getCount();
    int getAlpha();
    int getPercent();
}
