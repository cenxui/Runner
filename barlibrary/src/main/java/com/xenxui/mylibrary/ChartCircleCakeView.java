package com.xenxui.mylibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xenxui on 2015/9/2.
 */
public class ChartCircleCakeView extends View {
    private int mX_Center;
    private int mY_Center;
    private int mRadius;

    public ChartCircleCakeView(Context context) {
        super(context);
        mX_Center = getWidth()/2;
        mY_Center = getHeight()/2;
        mRadius = mX_Center>mY_Center? mX_Center:mY_Center;
    }

    public ChartCircleCakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mX_Center = getWidth()/2;
        mY_Center = getHeight()/2;
        mRadius = mX_Center>mY_Center? mX_Center:mY_Center;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        RectF rectF = new RectF(70,40,250,180);
        canvas.drawArc(rectF, 60 ,270, true, paint);
    }

    public final void setRadius(int radius) {
        mRadius = radius<mRadius?radius:mRadius;
    }

    public class Data{
        private String name = "";
        private int percent = 10;
        private int color = 0;

        public final void setName(String name) {

        }
    }
}
