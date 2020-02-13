package org.firstinspires.ftc.teamcode.math;

import org.firstinspires.ftc.teamcode.util.Point;

public class angle {

    public static double getAngle(Point start, Point end) {
        return Math.atan2(end.x - start.x,end.y - start.y);
    }
}
