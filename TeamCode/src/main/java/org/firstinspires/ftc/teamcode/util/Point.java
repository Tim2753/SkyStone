package org.firstinspires.ftc.teamcode.util;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {

        this.x = x;
        this.y = y;
    }
    public Point() {

        x = 0;
        y = 0;

    }
    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }
}
