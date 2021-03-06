package com.example.lobedix;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class TouchListener implements View.OnTouchListener {
    private float xDelta;
    private float yDelta;

    public float getActualX() {
        return actualX;
    }

    public void setActualX(float actualX) {
        this.actualX = actualX;
    }

    public float getActualY() {
        return actualY;
    }

    public void setActualY(float actualY) {
        this.actualY = actualY;
    }

    private float actualX;
    private float actualY;


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getRawX();
        float y = motionEvent.getRawY();
        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                xDelta = x - lParams.leftMargin;
                yDelta = y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                lParams.leftMargin = (int) (x - xDelta);
                lParams.topMargin = (int) (y - yDelta);
                actualX = (int) (x - xDelta);
                actualY =  (int) (y - yDelta);
                view.setLayoutParams(lParams);
                break;
        }

        return true;
    }
}