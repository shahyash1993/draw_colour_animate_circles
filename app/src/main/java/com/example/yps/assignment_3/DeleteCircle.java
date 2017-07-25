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

public class DeleteCircle extends View {
    String TAG = "rew";
    ArrayList<CirclePointRad> circlePoints = new ArrayList<CirclePointRad>();
    static Paint myFill;
    String colourSelected;
    int canvasHeight, canvasWidth;

    //constructor
    public DeleteCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }//end Constructor

    //on Click
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_UP:
                return handleActionUp(event);
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
                return false;
        }
        postInvalidate();
        return false;
    }

    private boolean handleActionUp(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();
        float centerX;
        float centerY;
        float rad;

        for(CirclePointRad p:circlePoints ){
            centerX = p.getX();
            centerY = p.getY();
            Log.i(TAG,"DeleteX/Y:"+centerX+" | "+centerY);
            rad = p.getRad();
            double d = Math.sqrt(Math.pow((touchX - centerX),2) + Math.pow((touchY-centerY),2));
            if(d<0 || d==0){
                circlePoints.remove(p);
            }
        }
        postInvalidate();
        return true;
    }


    //canvas
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


    /*
    * Getter Setter
    * */

    public ArrayList<CirclePointRad> getCirclePoints() {
        return circlePoints;
    }

    public void setCirclePoints(ArrayList<CirclePointRad> circlePoints) {
        this.circlePoints = circlePoints;
    }

    public String getColourSelected() {
        return colourSelected;
    }

    public void setColourSelected(String colourSelected) {
        this.colourSelected = colourSelected;
    }
}//end
