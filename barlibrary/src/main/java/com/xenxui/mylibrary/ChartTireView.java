package com.xenxui.mylibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by xenxui on 2015/9/4.
 */
public class ChartTireView extends View {
    private Paint mPaintOut;
    private Paint mPaintIn;
    private Paint mPaintInWhite;
    private TextPaint mPaintText;
    private String mText = "0";
    private double mPreAngle = 0;
    private double mNextAngle = 0;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public ChartTireView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaintOut = new Paint();
        mPaintOut.setColor(Color.RED);
        mPaintOut.setAlpha(54);

        mPaintIn = new Paint();
        mPaintIn.setColor(Color.RED);
        mPaintIn.setAlpha(95);
        mPaintIn.setAntiAlias(true);

        mPaintInWhite = new Paint();
        mPaintInWhite.setColor(Color.WHITE);
        mPaintInWhite.setAntiAlias(true);

        mPaintText = new TextPaint();
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(80);

        setDrawingCacheEnabled(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0,0,getWidth(),getHeight());
        canvas.drawArc(rectF, 270, (float) mPreAngle, true, mPaintOut);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 60, mPaintInWhite);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 60, mPaintIn);
        canvas.drawText(mText, getWidth() / 2 - 25, getHeight() / 2 + 30, mPaintText);
        if (mPreAngle>=mNextAngle) return;
        mPreAngle = mPreAngle +1;
        postDelayed(mRunnable,20);
    }

    public ChartTireView setAngle(double angle) {
        mNextAngle = angle;
        return this;
    }

    public ChartTireView setText(String text) {
        mText = text;
        return this;
    }
}
