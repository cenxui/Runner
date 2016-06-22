package com.xenxui.mylibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by xenxui on 2015/8/26.
 */
class ChartBarView extends View {

    private ChartBarData mChartBarData = new ChartBarData();

    public static final int RECTANGLE = 0;
    public static final int CIRCLE_BAR = 1;
    public static final int FULL_BAR = 2;

    private ViewStructure mViewStructure;

    public ChartBarView(Context context) {
        super(context);
        mViewStructure = new ViewStructure();
        setLayoutParams(new LinearLayout.LayoutParams((mViewStructure.Size + mViewStructure.Margin) * 2, 300));
    }

    public ChartBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mViewStructure = new ViewStructure();
        setLayoutParams(new LinearLayout.LayoutParams((mViewStructure.Size+mViewStructure.Margin)*2, 300));
    }

    public ChartBarView(Context context,ViewStructure viewStructure) {
        super(context);
        mViewStructure = viewStructure;
        setLayoutParams(new LinearLayout.LayoutParams((mViewStructure.Size+mViewStructure.Margin)*2, 300));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (mViewStructure.Type) {
            case RECTANGLE:
                setRectangleBar(canvas);
                break;
            case CIRCLE_BAR:
                setCircleBar(canvas);
                break;
            case FULL_BAR:
                setFullBar(canvas);
                break;
        }
    }

    public final ChartBarView setCount(int count) {
        mChartBarData.setCount(count);
        return this;
    }

    public final ChartBarView setMargin(int margin) {
        mViewStructure.Margin = margin;
        return this;
    }

    public final ChartBarView setDistribution(int distribution) {
        mViewStructure.Distribution = distribution;
        return this;
    }

    public final ChartBarView setColor(int color) {
        mChartBarData.setColor(color);
        return this;
    }

    public final ChartBarView setSize(int size) {
        mViewStructure.Size = size;
        return this;
    }

    public final ChartBarView setType(int type) {
        mViewStructure.Type = type;
        return this;
    }

    public final ChartData getItemData() {
        return mChartBarData;
    };

    public final void setChartBarData(ChartBarData chartBarData) {
        mChartBarData = chartBarData;
    }

    private final void setCircleBar(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(mChartBarData.getColor());
        int x_center = getWidth()/2;
        int distribution = mViewStructure.Distribution;
        int circleRadius = mViewStructure.Size;
        int y_center = getHeight()-2*mViewStructure.Margin-circleRadius;

        for (int i = 0;i<mChartBarData.getCount()/distribution;i++) {
            canvas.drawCircle(x_center,y_center,circleRadius,paint);
            circleRadius = circleRadius-mViewStructure.Decrease;
            y_center = y_center-2*(circleRadius+mViewStructure.Margin);
            paint.setAlpha(98-2*i);
        }
        circleRadius = (int)(((double)mChartBarData.getCount()%distribution)/distribution*(double)circleRadius);
        canvas.drawCircle(x_center, y_center, circleRadius, paint);
    }

    private final void setRectangleBar(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(mChartBarData.getColor());
        int x_center = getWidth()/2;
        int distribution = mViewStructure.Distribution;
        int circleRadius = mViewStructure.Size;
        int y_bottom = getHeight()-2*mViewStructure.Margin;

        for (int i = 0;i<mChartBarData.getCount()/distribution;i++) {
            canvas.drawRect(x_center - circleRadius, y_bottom - 2 * circleRadius, x_center + circleRadius, y_bottom, paint);
            circleRadius = circleRadius-mViewStructure.Decrease;
            y_bottom = y_bottom-2*(circleRadius+mViewStructure.Margin);
            paint.setAlpha(100-i);
        }
        circleRadius = (int)(((double)mChartBarData.getCount()%distribution)/distribution*(double)circleRadius);
        canvas.drawRect(x_center - circleRadius, y_bottom - 2 * circleRadius, x_center + circleRadius, y_bottom, paint);
    }

    private final void setFullBar(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(mChartBarData.getColor());
        canvas.drawRect(mViewStructure.Margin,mChartBarData.getCount()*2,mViewStructure.Margin+mViewStructure.Size*2,getHeight(),paint);
    }

    static class ViewStructure{
        int Decrease = 1;
        int Distribution = 15;
        int Size = 15;
        int Type = 0;
        int Margin = 2;
    }
}
