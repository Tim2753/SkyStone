package org.firstinspires.ftc.teamcode.pathing;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.math.angle;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.util.AHolder;
import org.firstinspires.ftc.teamcode.util.Line;
import org.firstinspires.ftc.teamcode.util.Point;
import org.firstinspires.ftc.teamcode.util.Pos;

public class Trajectory {
    public Pos[] path = new Pos[10000];
    private int endPoint = 0;
    private Robot robot;
    public int r = 1;
    AHolder[] actions = new AHolder[10];

    public Trajectory(Robot robot) {
        this.robot = robot;
    }
    public Trajectory startingPoint(int x, int y) {
        path[0] = new Pos(x,y,robot.getTheta());
        return this;
    }
    public Trajectory addPoint(int x,int y) {
        Pos startPoint = path[endPoint];
        Pos endingPoint = new Pos(x,y,startPoint.theta);
        Line line = new Line(startPoint,endingPoint);
        for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
            endPoint++;
            path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + 1)* line.b) + line.a),endingPoint.theta);
        }
        return this;
    }
    public Trajectory addPoint(int x,int y, double theta) {
        Pos startPoint = path[endPoint];
        Pos endingPoint = new Pos(x,y,theta);
        Line line = new Line(startPoint,endingPoint);
        for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
            endPoint++;
            path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + 1)* line.b) + line.a),endingPoint.theta);
        }
        return this;
    }
    public Trajectory addPoint(int x,int y, Object inputNull) {
        Pos startPoint = path[endPoint];
        Pos endingPoint = new Pos(x,y, angle.getAngle(startPoint, new Point(x,y)));
        Line line = new Line(startPoint,endingPoint);
        for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
            endPoint++;
            path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + 1)* line.b) + line.a),endingPoint.theta);
        }
        return this;
    }
    public Trajectory radius(int r) {
        this.r = r;
        return this;
    }
    public Trajectory action(Action a) {
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] != null) {
                actions[i] = new AHolder(path[endPoint],a);
                break;
            }
        }
        return this;
    }


    public int getEndPoint() {
        return endPoint;
    }
}
