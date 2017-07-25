package com.example.yps.assignment_3;

/**
 * Created by yPs on 2/24/2017.
 */

public class CirclePointRad {
    public float x;
    public float y;
    public float rad;

    public CirclePointRad(float x, float y, float rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRad(float rad) {
        this.rad = rad;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRad() {
        return rad;
    }
}
