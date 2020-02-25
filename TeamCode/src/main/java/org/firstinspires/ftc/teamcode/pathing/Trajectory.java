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
    private Point[] tracePath = new Point[10000];

    private int endPoint = 0;
    private Robot robot;
    public int r = 1;
    AHolder[] actions = new AHolder[10];
    public int checkedPoint = 0;
    double speed = 1;
    double v = speed;
    double totalI = 0;
    double lastD = 1;

    boolean usePID = true;
    /*
    public int getV(double error) {
        totalI += error * PID.kI;
        System.out.println("D: " + lastD);
        System.out.println(totalI + ", " + lastD + ", " + (int) (-10 * PID.dilate(error, totalI, PID.updateD(lastD, error)) + 12));
        return (int) ((-10 * PID.dilate(error, totalI, PID.updateD(lastD, error))) + 14);
    }
    */
    public Trajectory(Robot robot) {
        this.robot = robot;
    }
    public Trajectory startingPoint(int x, int y) {
        path[0] = new Pos(x,y,robot.getTheta());
        return this;
    }
    public Trajectory speed(double speed) {
        this.speed = speed;
        return this;
    }
    public Trajectory addPoint(int x,int y) {
        Pos startPoint = path[endPoint];
        Pos endingPoint = new Pos(x,y, 2753);
        Line line = new Line(startPoint,endingPoint);

        if (Math.abs(line.getAngle()) > 45 && Math.abs(line.getAngle()) < 135) {
            System.out.println("Y");
            if(endingPoint.y > startPoint.y) {
                for (int i = 0; i < endingPoint.y - startPoint.y; i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) (((startPoint.y + i) - line.a)/line.b),(int) startPoint.y + i,endingPoint.theta);
                }
            } else {
                for (int i = 0; i < Math.abs(endingPoint.y - startPoint.y); i++) {

                    endPoint++;
                    path[endPoint] = new Pos((int) (((startPoint.y - i) - line.a)/line.b),(int) startPoint.y - i,endingPoint.theta);
                }
            }
        }
        else {
            if(endingPoint.x > startPoint.x) {
                for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + i)* line.b) + line.a),endingPoint.theta);
                }
            } else {
                for (int i = 0; i < Math.abs(endingPoint.x - startPoint.x); i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) startPoint.x - i,(int) (((startPoint.x - i)* line.b) + line.a),endingPoint.theta);
                }
            }
        }

        /*for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
            endPoint++;
            path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + i)* line.b) + line.a),endingPoint.theta);
        }
        */
        return this;
    }
    public Trajectory addPoint(int x,int y, double theta) {
        Pos startPoint = path[endPoint];
        Pos endingPoint = new Pos(x,y,theta);
        Line line = new Line(startPoint,endingPoint);
        if (Math.abs(line.getAngle()) > 45 && Math.abs(line.getAngle()) < 135) {
            System.out.println("Y");
            if(endingPoint.y > startPoint.y) {
                for (int i = 0; i < endingPoint.y - startPoint.y; i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) (((startPoint.y + i) - line.a)/line.b),(int) startPoint.y + i,endingPoint.theta);
                }
            } else {
                for (int i = 0; i < Math.abs(endingPoint.y - startPoint.y); i++) {

                    endPoint++;
                    path[endPoint] = new Pos((int) (((startPoint.y - i) - line.a)/line.b),(int) startPoint.y - i,endingPoint.theta);
                }
            }
        }
        else {
            if(endingPoint.x > startPoint.x) {
                for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + i)* line.b) + line.a),endingPoint.theta);
                }
            } else {
                for (int i = 0; i < Math.abs(endingPoint.x - startPoint.x); i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) startPoint.x - i,(int) (((startPoint.x - i)* line.b) + line.a),endingPoint.theta);
                }
            }
        }
        return this;
    }
    public Trajectory addPoint(int x,int y, Object inputNull) {
        Pos startPoint = path[endPoint];
        Pos endingPoint = new Pos(x,y, startPoint.theta);
        Line line = new Line(startPoint,endingPoint);
        if (Math.abs(line.getAngle()) > 45 && Math.abs(line.getAngle()) < 135) {
            System.out.println("Y");
            if(endingPoint.y > startPoint.y) {
                for (int i = 0; i < endingPoint.y - startPoint.y; i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) (((startPoint.y + i) - line.a)/line.b),(int) startPoint.y + i,endingPoint.theta);
                }
            } else {
                for (int i = 0; i < Math.abs(endingPoint.y - startPoint.y); i++) {

                    endPoint++;
                    path[endPoint] = new Pos((int) (((startPoint.y - i) - line.a)/line.b),(int) startPoint.y - i,endingPoint.theta);
                }
            }
        }
        else {
            if(endingPoint.x > startPoint.x) {
                for (int i = 0; i < endingPoint.x - startPoint.x; i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) startPoint.x + i,(int) (((startPoint.x + i)* line.b) + line.a),endingPoint.theta);
                }
            } else {
                for (int i = 0; i < Math.abs(endingPoint.x - startPoint.x); i++) {
                    endPoint++;
                    path[endPoint] = new Pos((int) startPoint.x - i,(int) (((startPoint.x - i)* line.b) + line.a),endingPoint.theta);
                }
            }
        }
        return this;
    }
    public Trajectory radius(int r) {
        this.r = r;
        return this;
    }
    public Trajectory action(Action a) {
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == null) {
                actions[i] = new AHolder(endPoint,a);
                break;
            }
        }
        return this;
    }


    public int getEndPoint() {
        return endPoint;
    }
}
