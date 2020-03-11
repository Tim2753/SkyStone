package org.firstinspires.ftc.teamcode.pathing;

import org.firstinspires.ftc.teamcode.math.angle;
import org.firstinspires.ftc.teamcode.util.Line;
import org.firstinspires.ftc.teamcode.util.Point;
import org.firstinspires.ftc.teamcode.util.Pos;

import java.util.ArrayList;

public class bCurve {

    public ArrayList<Point> controlPoint;
    public ArrayList<Pos> points;
    public double rotation;
    public int density = 10;

    public bCurve() {

        controlPoint = new ArrayList<Point>();
        points = new ArrayList<Pos>();
        rotation = 2753;

    }
    public bCurve add(Point p) {
        controlPoint.add(p);
        return this;
    }
    public bCurve remove(int p) {
        controlPoint.remove(p);
        return this;
    }
    public int length() {

        return controlPoint.size();

    }
    public bCurve rotate(double rotation) {
        this.rotation = rotation;
        return this;
    }
    public bCurve density(int d) {
        density = d;
        return this;
    }
    public bCurve compile() {
        Point p;
        if (rotation == 2753)
            for (int i = 0; i < 1000; i++) {
               p = getPoint(controlPoint,(i *0.001));
               if (i != 0)
                   points.add(p.cast(angle.getAngle(points.get(i-1),p)));
               else
                   points.add(p.cast(0));
            }
        else {
            for (int i = 0; i < 1000; i++) {

                points.add(getPoint(controlPoint, (i * 0.001)).cast(rotation));

            }
        }
        return this;
    }
    public static Point interpolate(Line line, double t) {
        return new Point((1-t)*line.startingPoint.x + t*line.endingPoint.x,(1-t)*line.startingPoint.y + t*line.endingPoint.y);
    }
    public static Point getPoint(ArrayList<Point> c, double t) {
        ArrayList<Point> controlPoints = (ArrayList<Point>) c.clone();
        while (controlPoints.size() > 1) {

            for (int i = 0; i < controlPoints.size() - 1; i++) {
                for (Point p : controlPoints) {
                }
                controlPoints.set(i, interpolate(new Line(controlPoints.get(i),controlPoints.get(i+1)),t));
            }
            controlPoints.remove(controlPoints.size()-1);
        }
        return controlPoints.get(0);
    }

}
