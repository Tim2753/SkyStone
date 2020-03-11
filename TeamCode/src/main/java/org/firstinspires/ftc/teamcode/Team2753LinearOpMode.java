package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.actions.DOWN;
import org.firstinspires.ftc.teamcode.math.angle;
import org.firstinspires.ftc.teamcode.pathing.Trajectory;
import org.firstinspires.ftc.teamcode.pathing.bCurve;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.util.Line;
import org.firstinspires.ftc.teamcode.util.Point;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Team2753LinearOpMode extends LinearOpMode {

    protected DOWN DOWN;
    Trajectory currentTrajectory;
    protected ElapsedTime time;
    protected ArrayList<Action> running;
    ArrayList<Action> remove;
    double prevTime = 0;
    public Robot robot;


    public void invoke() {
        robot = new Robot(this);
        remove = new ArrayList<Action>();
        running = new ArrayList<Action>();
        DOWN = new DOWN();
        time = new ElapsedTime();
    }
    public abstract void runOpMode();
    public Trajectory newTrajectory() {
        return new Trajectory(robot);
    }
    /*
    public void build(Trajectory trajectory, String hi) {

        currentTrajectory = trajectory;

        while (currentTrajectory.r > 1) {

            robot.run();
            try {
                if (isOnRadius(currentTrajectory.path[currentTrajectory.checkedPoint])) {

                    telemetry.addData("X: ", robot.getX());
                    telemetry.addData("Y: ", robot.getY());
                    telemetry.addData("THETA: ", robot.getTheta());
                    telemetry.addData("Loop Speed: ", time.seconds() - prevTime);
                    prevTime = time.seconds();

                    telemetry.update();
                    for (Action a : running) {
                        a.update();
                        if (a.running == false) {
                            a.finish();
                            remove.add(a);
                        }
                    }
                    for (Action a : remove) {
                        running.remove(a);
                    }
                    remove.clear();
                    if (currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint < trajectory.r)
                        trajectory.r--;
                    double relativeAngle = (Math.atan2(currentTrajectory.path[currentTrajectory.checkedPoint].y - robot.getY(),
                            currentTrajectory.path[currentTrajectory.checkedPoint].x - robot.getX()))
                            - robot.angles.firstAngle;
                    if (Math.abs(relativeAngle) > 180) {
                        if (relativeAngle > 0)
                            relativeAngle = -(360 - Math.abs(relativeAngle));
                        else if (relativeAngle < 0)
                            relativeAngle = 360 - Math.abs(relativeAngle);
                    }
                    if (currentTrajectory.path[currentTrajectory.checkedPoint].theta > 1000) {

                        if (currentTrajectory.tracePoint > 10000) {
                            robot.drive.move(relativeAngle, currentTrajectory.pid.getSpeed(currentTrajectory.speed, currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint, time.milliseconds()),
                                    0 * Range.clip((optimize(angle.getAngle(currentTrajectory.tracePath[currentTrajectory.tracePoint - 10], currentTrajectory.tracePath[currentTrajectory.tracePoint - 1]) - robot.getTheta()) / 30), 1, -1));
                        } else {
                            robot.drive.move(relativeAngle, currentTrajectory.pid.getSpeed(currentTrajectory.speed, currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint, time.milliseconds()), 0);

                        }
                    } else {
                        robot.drive.move(relativeAngle, currentTrajectory.pid.getSpeed(currentTrajectory.speed, currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint, time.milliseconds()),
                                0 * Range.clip((optimize(currentTrajectory.path[currentTrajectory.checkedPoint].theta - robot.getTheta()) / 30), 1, -1));
                    }

                    for (int i = 0; i < currentTrajectory.actions.length; i++) {
                        if (trajectory.actions[i] != null) {
                            if (trajectory.checkedPoint > trajectory.actions[i].point && trajectory.actions[i].action.runable) {
                                if (trajectory.actions[i].action.runable && !trajectory.actions[i].action.running) {
                                    trajectory.actions[i].action.start(this);
                                    trajectory.actions[i].action.running = true;
                                }
                            }
                        }
                    }
                    currentTrajectory.tracePath[currentTrajectory.tracePoint] = new Point(robot.getX(), robot.getY());
                    currentTrajectory.tracePoint++;
                } else {
                    currentTrajectory.checkedPoint++;
                }
            } catch (Exception e) {
                currentTrajectory.r --;
            }

        }
    }
    */

    private boolean isOnRadius(Point point) {
        int x = (int) (point.x - robot.getX());
        int y = (int) (point.y - robot.getY());
        if ((int) Math.sqrt((x*x) + (y*y)) < currentTrajectory.r + 1 && Math.sqrt((x*x) + (y*y)) > currentTrajectory.r-1) {
            return true;
        } else {
            return false;
        }
    }
    public void runAction(Action a) {

        a.start(this);
        a.running = true;
        running.add(a);

    }
    public void run() {
        robot.run();
        telemetry.update();
        for (Action a : running) {
            a.update();
            if (a.running == false) {
                a.finish();
                remove.add(a);
            }
        }
        for (Action a : remove) {
            running.remove(a);
        }
        remove.clear();
    }
    private double cut(double clip) {
        if (clip < 0){
            return 0;
        } else {
            return clip;
        }
    }
    public double optimize(double angle) {
        if (angle > 180) {
            return angle - 360;
        } else if (angle < -180) {
            return angle + 360;
        } else {
            return angle;
        }
    }
    /*
    public void build(Trajectory trajectory) {

        currentTrajectory = trajectory;


        while (currentTrajectory.r > 1) {

            telemetry.addData("x: ", robot.getX());
            telemetry.addData("y: ", robot.getY());
            telemetry.addData("cp: ", currentTrajectory.checkedPoint + "/" + currentTrajectory.getEndPoint());
            currentTrajectory.path[currentTrajectory.checkedPoint].debug(this);



            robot.run();

            if (currentTrajectory.checkedPoint + (10*currentTrajectory.r)+1 > currentTrajectory.getEndPoint()) {
                currentTrajectory.r-= 0.5;
                telemetry.addLine("??");
            } else {
                if (isOnRadius(currentTrajectory.path[currentTrajectory.checkedPoint])) {
                    currentTrajectory.tracePath[currentTrajectory.tracePoint] = new Point(robot.getX(), robot.getY());
                    currentTrajectory.tracePoint++;
                    Line line = new Line(new Point(robot.getX(), robot.getY()),
                            currentTrajectory.path[currentTrajectory.checkedPoint]);
                    double relativeAngle = line.getAngle() - robot.getTheta() - 45;
                    telemetry.addData("MOVE: " , robot.getTheta());
                    if (Math.abs(relativeAngle) > 180) {
                        if (relativeAngle >= 0)
                            relativeAngle = Math.abs(relativeAngle) - 360;
                        else if (relativeAngle < 0)
                            relativeAngle = 360 - Math.abs(relativeAngle);
                    }
                    robot.drive.move(relativeAngle, 0.4,0);
                    telemetry.addData(" ", relativeAngle);
                    telemetry.update();


                } else {
                    currentTrajectory.checkedPoint++;
                }
            }
        }

    }
   public void run(Trajectory t) {
        Point p;
        Line line;

        t.checkedPoint += t.r*5;
        while (true) {

            sleep(100);
            telemetry.addLine("checked Point" + t.checkedPoint);
            telemetry.addLine(t.path[t.checkedPoint].x + " " + t.path[t.checkedPoint].y);
            robot.run();
            line = new Line(new Point(robot.getX(), robot.getY()),
                    t.path[t.checkedPoint]);
            telemetry.addLine("angle: " + line.getAngle() + "- robotTheta: " + robot.getTheta() + "- 45 = " + (line.getAngle()-robot.getTheta()-45));

            p =  new Point(t.path[t.checkedPoint].x, t.path[t.checkedPoint].y);
            if (Math.sqrt(((p.x - robot.getX())*(p.x - robot.getX())) +
                    ((p.y - robot.getY())*(p.y - robot.getY()))) <= t.r+2 &&
                    Math.sqrt(((p.x - robot.getX())*(p.x - robot.getX())) +
                    ((p.y - robot.getY())*(p.y - robot.getY()))) >= t.r) {

                robot.drive.move(line.getAngle()-robot.getTheta()-45,1,0);
            } else {
                 t.checkedPoint+=3;
            }
            if (t.checkedPoint > t.getEndPoint()-7) {
                break;
            }
        }
        robot.drive.move(90,0,0);
        robot.drive.kill();
    }

     */
    public boolean isCloseTo(Point p) {
        return (Math.sqrt(((p.x - robot.getX())*(p.x - robot.getX()))+((p.y - robot.getY())*(p.y - robot.getY()))) < 2);
    }
    public void moveTo(Point p, double speed) {
        Line line = new Line(new Point(robot.getX(), robot.getY()), p);
        robot.drive.move(Math.toRadians(optimize(line.getAngle()-robot.getTheta()-45)),speed,0.1);
    }
    public void build(bCurve c) {
        int selectedPoint = 0;
        while (opModeIsActive() && selectedPoint < 998) {
            /*if (isCloseTo(c.points.get(selectedPoint))) {
                selectedPoint++;
            } else {
                moveTo(c.points.get(selectedPoint),0.5);
            }
            robot.run();

             */
            try {
                telemetry.addData("Selected", selectedPoint);
                telemetry.addData("robot x", robot.getX());
                telemetry.addData("robot y", robot.getY());
                telemetry.addData("x", c.points.get(selectedPoint).x);
                telemetry.addData("y", c.points.get(selectedPoint).y);
                if (isCloseTo(c.points.get(selectedPoint))) {
                    selectedPoint += c.density;

                }
                moveTo(c.points.get(selectedPoint), 0.5);
                robot.run();
            } catch (Exception e) {
                moveTo(c.points.get(selectedPoint-100),0.2);
            }
/*
            sleep(1);
            moveTo(c.points.get(selectedPoint),0.5);

            selectedPoint++;

 */
        }
    }
    public bCurve newCurve() {
        return new bCurve();
    }


}
