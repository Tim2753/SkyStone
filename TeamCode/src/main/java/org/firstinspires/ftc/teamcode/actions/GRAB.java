package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;

public class GRAB extends Action {

    @Override
    public void start(Team2753LinearOpMode linearOpMode) {
        this.robot = linearOpMode.robot;

        if(robot.v4b.isGrabbed) {
            robot.v4b.release();
        } else {
            robot.v4b.grab();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void finish() {

    }
}
