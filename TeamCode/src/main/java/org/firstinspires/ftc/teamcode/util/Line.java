package org.firstinspires.ftc.teamcode.util;

import org.firstinspires.ftc.teamcode.math.angle;

public class Line {
    public Point startingPoint;
    public Point endingPoint;
    public double a;
    public double b;
    public Line(Point start, Point end) {
        startingPoint = start;
        endingPoint = end;
        if (endingPoint.x - startingPoint.x != 0)
            b = (endingPoint.y - startingPoint.y)/(endingPoint.x - startingPoint.x);
        else
            b = (endingPoint.y - startingPoint.y)/0.0000000001;
        a = start.y - (start.x * b);
    }
    public void debug() {
        System.out.println(startingPoint.x + ", " + startingPoint.y);
        System.out.println(endingPoint.x + ", " + endingPoint.y);
        System.out.println(a);
        System.out.println(b);
    }
    public double getAngle() {
        return angle.getAngle(startingPoint, endingPoint);
    }
}

