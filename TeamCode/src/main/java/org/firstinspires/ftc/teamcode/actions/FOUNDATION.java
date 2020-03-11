package org.firstinspires.ftc.teamcode.actions;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;

public class FOUNDATION extends Action {
    @Override
    public void start(Team2753LinearOpMode linearOpMode) {
        this.robot = linearOpMode.robot;
        if (!robot.foundation.grabbed)
            robot.foundation.grab();
        else {
            robot.foundation.release();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void finish() {

    }
}
