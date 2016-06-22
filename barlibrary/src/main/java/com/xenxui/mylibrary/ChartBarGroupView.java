package com.xenxui.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by xenxui on 2015/8/29.
 * example
 * ChartBarGroupView chartBarGroupView = (ChartBarGroupView)findViewById(R.id.view);
 ArrayList<ChartBarData> arrayList = new ArrayList<>();
 ChartBarData chartBarData;
 for (int i = 0 ; i<20;i++) {
 chartBarData = new ChartBarData();
 chartBarData.setCount((int)(Math.random()*300));
 arrayList.add(chartBarData);
 }
 chartBarGroupView.addBars(arrayList);
 */
public final class ChartBarGroupView extends LinearLayout {
    private ArrayList<ChartBarData> mArrayList = new ArrayList();
    private Context mContext;

    private ChartBarView.ViewStructure mViewStructure = new ChartBarView.ViewStructure();

    private int mColor = -1;

    /**
     * rectangle in chart bar
     */
    public static final int TYPE_RETA = 0;
    /**
     * circle in chart bar
     */
    public static final int TYPE_CIRCLE = 1;
    /**
     * full rectangle chart bar
     */
    public static final int TYPE_FULL_BAR = 2;
    /**
     * gradient color form bar to bar
     */
    public static final int COLOR_GRADIENT = -2;
    /**
     * alpha in the bar and gradient color from bar to bar
     */
    public static final int COLOR_GRADIENT_ALPHA = -1;

    public static final int[] ColorArray = {
        0xFF0000,0xFF0040,0xFF00BF,0XCC00FF,0XD900FF,0X7700FF,0X2600FF,0X0026FF,0X007BFF,
        0X00F6FF,0X00FFBF,0X00FF37,0X1AFF00,0X84FF00,0XF6FF00,0XFFD500,0XFF6600,0XFF1500
    };

    public static final int[] ColorAlphaArray = {
            0xFFFF0000,0xFFFF0040,0xFFFF00BF,0XFFCC00FF,0XFFD900FF,0XFF7700FF,0XFF2600FF,0XFF0026FF,0XFF007BFF,
            0XFF00F6FF,0XFF00FFBF,0XFF00FF37,0XFF1AFF00,0XFF84FF00,0XFFF6FF00,0XFFFFD500,0XFFFF6600,0XFFFF1500
    };

    public ChartBarGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        this.mContext = context;
        setGravity(Gravity.BOTTOM);
    }

    /**
     * add new bar
     *@param chartBarData  the bar's name
     * */

    public void addBar(ChartBarData chartBarData) {
        mArrayList.add(chartBarData);
        ChartBarView chartBarView = new ChartBarView(mContext,mViewStructure);
        setView(chartBarData, chartBarView, 0);
    }

    /**
     * add data array
     * @param arrayList  the data array for chart bar
     */

    public void addBars(ArrayList<ChartBarData> arrayList) {
        ChartBarView chartBarView;
        for (int i = 0;i<arrayList.size();i++) {
            chartBarView = new ChartBarView(mContext,mViewStructure);
            setView(arrayList.get(i),chartBarView,i);
        }
        mArrayList.addAll(arrayList);
    }

    /**
     *
     * @param chartBarData the bar's data : count,color,distribution,etc
     * @param chartBarView the chart bar
     * @param position position of input array,if add one chart bar position = 0;
     */

    private void setView(ChartBarData chartBarData, ChartBarView chartBarView ,int position) {
        initialColorStyle(chartBarData, mArrayList.size()+position);
        chartBarView.setChartBarData(chartBarData);
        addView(chartBarView);
    }

    public void setViewStructure(ChartBarView.ViewStructure viewStructure) {
        mViewStructure = viewStructure;
    }

    /**
     * set the bar's percent
     * @param index the bar's index in array,if the index out of the array length throws exception
     * @param count new bar's count : this must>0&&<300
     */

    public void setCount(int index,int count) {
        mArrayList.get(index).setCount(count);
        ((ChartBarView)getChildAt(index)).setCount(count).invalidate();
    }

    /**
     * set the bar's name
     * @param index  the bar's index in array,if the index out of the array length throws exception
     * @param name new bar's name
     */

    public void setName(int index,String name) {
        mArrayList.get(index).setName(name);
    }

    /**
     * remove the bar in the index position
     * @param index
     */

    public void remove(int index) {
        mArrayList.remove(index);
        remove(index);
    }

    /***
     * for bar's type
     * @param type this must 0,1,2
     */

    public void setType(int type) {
        mViewStructure.Type = type;
    }

    /**
     * set bar's margin
     * @param margin
     */

    public void setMargin(int margin) {
        mViewStructure.Margin = margin;
    }

    /**
     * set bar size
     * @param size
     */

    public void setSize(int size) {
        mViewStructure.Size = size;
    }

    /**
     * setAlpha
     * @param index the bar's position
     * @param barAlpha 0 to 100
     */
    public void setBarAlpha(int index,float barAlpha) {
        getChildAt(index).setAlpha(barAlpha);
    }

    /**
     * set the distribution of the bar
     * @param distribution the distribution
     */
    public void setDistribution(int distribution) {
        mViewStructure.Distribution = distribution;
    }

    /**
     * set the bar group style
     * @param color Integer of style number
     */
    public void setColor(int color) {
        mColor = color;
    }

    /**
     *  initial bar detail {@link ChartBarView}
     * @param chartBarData {@link ChartBarView} view of the bar
     * @param index the  position of the bar
     */

    private void initialColorStyle(ChartBarData chartBarData,int index) {
        switch (mColor) {
            case COLOR_GRADIENT:
                chartBarData.setColor(ColorArray[(index % ColorArray.length)]);
                break;
            case COLOR_GRADIENT_ALPHA:
                chartBarData.setColor(ColorAlphaArray[index % ColorAlphaArray.length]);
                break;
            default:
                chartBarData.setColor(mColor);
        }
    }
}
