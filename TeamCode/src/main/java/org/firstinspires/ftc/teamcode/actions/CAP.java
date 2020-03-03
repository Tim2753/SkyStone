package org.firstinspires.ftc.teamcode.actions;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;

public class CAP extends Action {
    @Override
    public void start(Team2753LinearOpMode linearOpMode) {
        this.robot = linearOpMode.robot;

        if(robot.v4b.isCapped) {
            robot.v4b.release();
        } else {
            robot.v4b.cap();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void finish() {

    }
}
