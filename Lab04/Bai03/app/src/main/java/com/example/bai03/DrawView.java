package com.example.bai03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.lang.ref.PhantomReference;

public class DrawView extends View {
    Paint mPaint = new Paint();
    Path mPath = new Path();

    float mCurX = 0f;
    float mCurY = 0f;
    float mStartX = 0f;
    float mStartY = 0f;


    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    void init() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(8f);
        mPaint.setAntiAlias(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = x;
                mStartY = y;
                actionDown(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                actionMove(x, y);
                return true;
            case MotionEvent.ACTION_UP:
                actionUp();
                return true;
        }

        return false;
    }

    void actionDown(float x, float y) {
        mPath.moveTo(x, y);
        mCurX = x;
        mCurY = y;
    }

    void actionMove(float x, float y) {
        mPath.quadTo(mCurX, mCurY, (x + mCurY) / 2, (y + mCurY) / 2);
        mCurX = x;
        mCurY = y;
    }

    void actionUp() {
        mPath.lineTo(mCurX, mCurY);

        if (mStartX == mCurX && mStartY == mCurY) {
            mPath.lineTo(mCurX, mCurY + 2);
            mPath.lineTo(mCurX + 1, mCurY + 2);
            mPath.lineTo(mCurX + 1, mCurY);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();

        canvas.drawPath(mPath, mPaint);
    }
}
