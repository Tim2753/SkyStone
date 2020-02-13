package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pathing.Trajectory;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

public abstract class Team2753LinearOpMode extends LinearOpMode {

    Robot robot = new Robot(this);
    public abstract void runOpMode();
    public Trajectory buildTrajectory() {
        return new Trajectory(robot);
    }
    public void build(Trajectory trajectory) {

    }
}
