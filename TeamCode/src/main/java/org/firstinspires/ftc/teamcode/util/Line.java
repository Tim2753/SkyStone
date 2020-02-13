package org.firstinspires.ftc.teamcode.util;

public class Line {
    Point startingPoint;
    Point endingPoint;
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
}
