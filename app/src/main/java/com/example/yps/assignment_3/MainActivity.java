package com.example.yps.assignment_3;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity{

    String TAG = "rew";
    SimpleDrawing3 simpleDrawing3;
    DeleteCircle deleteCircle;
    ArrayList<CirclePointRad> circlePoints = new ArrayList<CirclePointRad>();
    static String colourSelected = "black";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Canvas canvas;
        Log.e(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        simpleDrawing3 = new SimpleDrawing3(this,null);
        deleteCircle = new DeleteCircle(this,null);
        simpleDrawing3.setColourSelected(colourSelected);
        setContentView(simpleDrawing3);
        //setContentView(R.layout.content_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.blackOption:
                Log.i(TAG,">>> black");
                colourSelected = "black";
                break;
            case R.id.blueOption:
                Log.i(TAG,">>> blue");
                colourSelected = "blue";
                break;
            case R.id.redOption:
                Log.i(TAG,">>> red");
                colourSelected = "red";
                break;
            case R.id.greenOption:
                Log.i(TAG,">>> green");
                colourSelected = "green";
                break;
            case R.id.deleteOption:

                circlePoints = simpleDrawing3.getCirclePoints();
                Log.i(TAG,">>> Delete..."+circlePoints.size());
                deleteCircle.setCirclePoints(circlePoints);
                deleteCircle.setColourSelected(colourSelected);

                for(CirclePointRad p : circlePoints){
                    Log.i(TAG,""+p.getX()+"|"+p.getY()+"|"+p.getRad());
                }
                //simpleDrawing3.delete();
                break;
        }
        simpleDrawing3.setColourSelected(colourSelected);
        return false;
    }



    @Override
    protected void onStop() {
        super.onStop();
        new SimpleDrawing3(this,null).invalidateIt();
    }
}
