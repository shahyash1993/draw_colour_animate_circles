package com.example.yps.assignment_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yPs on 2/24/2017.
 */

public class SimpleDrawing extends View {
    private ShapeDrawable oval;
    static Paint blackFill;

    static{
        blackFill = new Paint();
        blackFill.setColor(Color.BLACK);
    }

    public SimpleDrawing(Context context){
        super(context);
        int x = 100;
        int y = 100;
        int width = 200;
        int height = 150;
        this.oval = new ShapeDrawable(new RectShape());
        this.oval.getPaint().setColor(Color.RED);
        this.oval.setBounds(x, y, x + width, y + height);
      }



    public SimpleDrawing(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        this.oval.draw(canvas);
        canvas.drawCircle(100,100,100,blackFill);
    }

}
