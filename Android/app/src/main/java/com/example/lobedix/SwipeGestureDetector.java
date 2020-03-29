package com.example.lobedix;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

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

    public SwipeGestureDetector(final Enfant_Adulte context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        TextView txt = context.getText();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);
                            txt.setX(txt.getX() - deltaX/2);
                            txt.setY(txt.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_sucre_sale context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_Sucre_healthy context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_Glace context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_chocolat context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_chaud_froid context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_froid_exotique context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_vegetarien context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_Chaud_Healthy context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_soupe context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_Chaud_exotique context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

                                    return(true);
                                }
                            }
                        }

                        return (false);
                    }
                }
        );
    }

    public SwipeGestureDetector(final Pouce_froid_healthy context){
        super(context, new GestureDetector.SimpleOnGestureListener(){

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        ImageView image = context.getImage();
                        Log.i("DEBUG", e1 + " - " + e2);

                        float deltaX = e1.getX() - e2.getX();
                        float deltaY = e1.getY() - e2.getY();

                        if ((velocityX > 1) | (velocityY > 1)){
                            image.setX(image.getX() - deltaX/2);
                            image.setY(image.getY() - deltaY/2);

                        }

                        if (Math.abs(deltaX) > Math.abs(deltaY)){
                            if (Math.abs(deltaX)>=DELTA_MIN){
                                if (deltaX < 0) {
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.RIGHT_TO_LEFT);
                                    return(true);
                                }
                                else{
                                    context.onSwipe(SwipeGestureDetector.Swipe_Direction.LEFT_TO_RIGHT);

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
