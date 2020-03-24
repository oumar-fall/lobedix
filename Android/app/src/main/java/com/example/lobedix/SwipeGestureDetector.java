package com.example.lobedix;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class SwipeGestureDetector extends GestureDetector {

    private final static int DELTA_MIN = 10; //distance minimale pour qu'un swipe soit accepté
    public SwipeGestureDetector(final Apero context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                Log.i("DEBUG", e1 + " - " + e2);

                float deltaX = e1.getX() - e2.getX();
                float deltaY = e1.getY() - e2.getY();


                if (Math.abs(deltaX) > Math.abs(deltaY)){
                    if (Math.abs(deltaX)>=DELTA_MIN){
                        if (deltaX < 0) {
                            context.onSwipe(Swipe_Direction.RIGHT_TO_LEFT);

                            return(true);
                        }
                        else{
                            context.onSwipe(Swipe_Direction.LEFT_TO_RIGHT);
                            return(true);
                        }
                    }
                }

                return (false);
            }
        }
        );
    }

    public static enum Swipe_Direction{
        LEFT_TO_RIGHT, RIGHT_TO_LEFT
    }
}
