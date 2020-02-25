package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.math.angle;
import org.firstinspires.ftc.teamcode.pathing.Trajectory;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.util.Point;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Team2753LinearOpMode extends LinearOpMode {

    Trajectory currentTrajectory;
    ElapsedTime time = new ElapsedTime();
    ArrayList<Action> running = new ArrayList<Action>();
    ArrayList<Action> remove = new ArrayList<Action>();


    Robot robot = new Robot(this);
    public abstract void runOpMode();
    public Trajectory newTrajectory() {
        return new Trajectory(robot);
    }
    public void build(Trajectory trajectory) {
        currentTrajectory = trajectory;
        while (currentTrajectory.r > 1) {
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
            if(currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint < trajectory.r)
                trajectory.r--;
            if(isOnRadius(currentTrajectory.path[currentTrajectory.checkedPoint])) {
                double relativeAngle = (Math.atan2(currentTrajectory.path[currentTrajectory.checkedPoint].y - robot.getY(),
                        currentTrajectory.path[currentTrajectory.checkedPoint].x - robot.getX()) - Math.PI / 4)
                        - Math.toRadians(robot.angles.firstAngle);
                if (Math.abs(relativeAngle) > Math.PI) {
                    if (relativeAngle > 0)
                        relativeAngle = -(Math.PI * 2 - Math.abs(relativeAngle));
                    else if (relativeAngle > 0)
                        relativeAngle = Math.PI * 2 - Math.abs(relativeAngle);
                }
                if (currentTrajectory.path[currentTrajectory.checkedPoint].theta > 1000) {
                    robot.drive.move(relativeAngle, currentTrajectory.pid.getSpeed(currentTrajectory.speed,currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint, time.milliseconds()), Range.clip((optimize(angle.getAngle(currentTrajectory.tracePath[currentTrajectory.tracePoint-10], currentTrajectory.tracePath[currentTrajectory.tracePoint-1])+robot.getTheta())/30),1,-1));

                } else
                robot.drive.move(relativeAngle, currentTrajectory.pid.getSpeed(currentTrajectory.speed,currentTrajectory.getEndPoint() - currentTrajectory.checkedPoint, time.milliseconds()), Range.clip((optimize(currentTrajectory.path[currentTrajectory.checkedPoint].theta-robot.getTheta())/30),1,-1));

            } else {
                currentTrajectory.checkedPoint++;
            }
            for(int i = 0; i < currentTrajectory.actions.length;i++) {
                if (trajectory.actions[i] != null) {
                    if (trajectory.checkedPoint > trajectory.actions[i].point && trajectory.actions[i].action.runable) {
                        if (trajectory.actions[i].action.runable && !trajectory.actions[i].action.running) {
                            trajectory.actions[i].action.start();
                            trajectory.actions[i].action.running = true;
                        }
                    }
                }
            }
        }
    }
    private boolean isOnRadius(Point point) {
        int x = (int) (point.x - robot.getX());
        int y = (int) (point.y - robot.getY());
        if ((int) Math.sqrt((x*x) + (y*y))- 2 < currentTrajectory.r && Math.sqrt((x*x) + (y*y)) +2 > currentTrajectory.r) {
            return true;
        } else {
            return false;
        }
    }
    public void runAction(Action a) {

        a.start();
        a.running = true;
        running.add(a);

    }
    private double cut(double clip) {
        if (clip < 0){
            return 0;
        } else {
            return clip;
        }
    }
    private double optimize(double angle) {
        if (angle > 180) {
            return angle - 360;
        } else if (angle < -180) {
            return angle + 360;
        } else {
            return angle;
        }
    }
}
