package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pathing.Trajectory;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.util.Point;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Team2753LinearOpMode extends LinearOpMode {

    Trajectory currentTrajectory;
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
}
