package com.example.yps.assignment_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yPs on 2/24/2017.
 */

public class SimpleDrawing2 extends View{

    static Paint blackFill;
    static Paint redFill;
    static Paint greenFill;

    public SimpleDrawing2(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    static{
        blackFill = new Paint();
        redFill = new Paint();
        greenFill = new Paint();

        blackFill.setColor(Color.BLACK);
        blackFill.setTextSize(100);

        redFill.setStrokeWidth(20.0f);
        redFill.setColor(Color.RED);
        redFill.setStyle(Paint.Style.STROKE);
        redFill.setTextSize(100);

        redFill.setTypeface(Typeface.create("seriff",Typeface.BOLD_ITALIC));
//        redFill.setFakeBoldText(true);

        greenFill.setStrokeWidth(20.0f);
        greenFill.setColor(Color.GREEN);
        greenFill.setStyle(Paint.Style.STROKE);
        greenFill.setTextSize(100);

    }

    protected void onDraw(Canvas canvas){
        canvas.drawCircle(100,100,100,blackFill);
        canvas.drawRect(200,200,400,400,redFill);
        canvas.drawText("Hello World!",500,500,blackFill);
        //for(int i=0; i< 500; i++){
        canvas.drawLine(0,0,canvas.getWidth(),canvas.getHeight(),redFill);

        canvas.drawLine(0,0,0,canvas.getHeight(),redFill);
        canvas.drawLine(0,0,canvas.getWidth(),0,redFill);
        canvas.drawLine(canvas.getWidth(),0,canvas.getWidth(),canvas.getHeight(),redFill);
        canvas.drawLine(0,canvas.getHeight(),canvas.getWidth(),canvas.getHeight(),redFill);

        canvas.drawText(canvas.getWidth()+"/"+canvas.getHeight(),300,700,blackFill);
        //}
        canvas.save();
        int x=500,y=900;
        canvas.rotate(90,500,500);

        canvas.drawLine(0,0,canvas.getWidth(),canvas.getHeight(),greenFill);
        canvas.drawLine(0,0,0,canvas.getHeight(),greenFill);
        canvas.drawLine(0,0,canvas.getWidth(),0,greenFill);
        canvas.drawLine(canvas.getWidth(),0,canvas.getWidth(),canvas.getHeight(),greenFill);
        canvas.drawLine(0,canvas.getHeight(),canvas.getWidth(),canvas.getHeight(),greenFill);

        canvas.drawText("YASH",300,400,blackFill);

        canvas.restore();
    }
}
