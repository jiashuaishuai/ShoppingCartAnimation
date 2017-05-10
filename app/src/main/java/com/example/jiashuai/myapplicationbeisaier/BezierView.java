package com.example.jiashuai.myapplicationbeisaier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by JiaShuai on 2017/5/8.
 */

public class BezierView extends View {
//    private Paint mPaint;
//    private Path mPath;

    private Point startPoint;
    private Point endPoint;
    private Point assistPoint;

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        startPoint = new Point(0, 10);
        endPoint = new Point(displayMetrics.widthPixels, 10);
        assistPoint = new Point(displayMetrics.widthPixels / 2, 100);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint  mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        Path     mPath = new Path();
        mPath.moveTo(startPoint.x, startPoint.y);
        mPath.quadTo(assistPoint.x, assistPoint.y, endPoint.x, endPoint.y);
        canvas.drawPath(mPath, mPaint);
        mPaint.setStrokeWidth(30);
        canvas.drawPoint(assistPoint.x, assistPoint.y, mPaint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                assistPoint.x = (int) event.getX();
                assistPoint.y = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
//    int mSupX,mSupY;
//@Override
//protected void onDraw(Canvas canvas) {
//    Paint p = new Paint();
//    p.setStyle(Paint.Style.STROKE);
//    p.setStrokeWidth(10);
//    Path path = new Path();
//    path.moveTo(200, 200);
//    path.quadTo(mSupX, mSupY, 400, 200);
//    canvas.drawPath(path,p);
//    canvas.drawPoint(mSupX,mSupY,p);
//    super.onDraw(canvas);
//}
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_MOVE:
//                mSupX = (int) event.getX();
//                mSupY = (int) event.getY();
//                invalidate();
//        }
//        return true;
//    }
}
