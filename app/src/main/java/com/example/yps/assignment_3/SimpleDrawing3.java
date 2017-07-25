package com.example.yps.assignment_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SimpleDrawing3 extends View{

    String TAG = "rew";
    String colourSelected = "black";
    static Paint myFill;
    float centerX=0,centerY=0,rad=0;
    ArrayList<CirclePointRad> circlePoints = new ArrayList<CirclePointRad>();
    boolean swipeInProgress = false;

    int canvasHeight, canvasWidth;


    public SimpleDrawing3(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
        Log.e(TAG,"Inside Constructor & Colour: "+colourSelected);

        circlePoints.add(new CirclePointRad(centerX,centerY,rad));
    }//end Constructor

    //on Click
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_DOWN:
                return handleActionDown(event);
            case MotionEvent.ACTION_UP:
                return handleActionUp(event);
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
                swipeInProgress = false;
                return false;
        }
        postInvalidate();
        return false;
    }

    //drawing
    public void onDraw(Canvas canvas){
        myFill = new Paint();
        switch (colourSelected){
            case "red":
                myFill.setColor(Color.RED);
                break;
            case "blue":
                myFill.setColor(Color.BLUE);
                break;
            case "green":
                myFill.setColor(Color.GREEN);
                break;
            default:
                myFill.setColor(Color.BLACK);
                break;
        }
        myFill.setStrokeWidth(2.0f);
        myFill.setStyle(Paint.Style.STROKE);

        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();
        Log.i("rew","Size: "+circlePoints.size());
        for(CirclePointRad p: circlePoints){

            canvas.drawCircle(p.x,p.y,p.rad,myFill);
            /*Log.i("rew","X: "+p.getX()+
                         "| Y: "+p.getY()+
                          "| Rad: "+p.getRad());*/
        }
    }

    //handle UP and Down
    private boolean handleActionDown(MotionEvent event) {
        swipeInProgress = true;
        centerX = event.getX();
        centerY = event.getY();

        return true;
    }

    private boolean handleActionUp(MotionEvent event) {
        if (!swipeInProgress)
            return false;

        float endX = event.getX();
        float endY = event.getY();
        rad = findRad(endX, endY);
        Log.e("rew", "Swipe Distance: " + (endX - centerX) + "\n" + event);
        swipeInProgress = false;

        if ((centerX + Math.abs(rad)) < canvasWidth &&
                (centerY + Math.abs(rad)) < canvasHeight &&
                centerX - Math.abs(rad) >0 &&
                centerY - Math.abs(rad) > 0) {
             circlePoints.add(new CirclePointRad(centerX, centerY, Math.abs(rad)));
             postInvalidate();
        }

        return true;
    }

    //find Radius
    public float findRad(float endX, float endY){
        double rad;
        rad = Math.sqrt(Math.pow((endX - centerX),2) + Math.pow((endY-centerY),2)) ;
        return (float)rad;
    }

    //Simply invalidate it!!
    public void invalidateIt(){
        postInvalidate();
    }


    /*
    *Setter Getter
    **/

    public String getColourSelected() {
        return colourSelected;
    }

    public void setColourSelected(String colourSelected) {
        this.colourSelected = colourSelected;
    }

    public ArrayList<CirclePointRad> getCirclePoints() {
        return circlePoints;
    }

    /*
    *Setter Getters
    **/

    //delete
    public void delete(){

    }

}//end