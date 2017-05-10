package com.example.jiashuai.myapplicationbeisaier.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by JiaShuai on 2017/5/9.
 */

public class MyLayout extends RelativeLayout {
    private float[] mCurrentPosition = new float[2];

    public void setmCurrentPosition(float[] mCurrentPosition) {
        this.mCurrentPosition = mCurrentPosition;
    }

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//去除锯齿
        paint.setColor(Color.parseColor("#000000"));//画笔颜色黑色
        paint.setStyle(Paint.Style.STROKE);//空心
        paint.setStrokeWidth(3);//外框宽度
        canvas.drawCircle(mCurrentPosition[0], mCurrentPosition[1], 10, paint);
        super.onDraw(canvas);
    }
}
