package org.firstinspires.ftc.teamcode.actions.intake;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;

public class ON extends Action {
    @Override
    public void start(Team2753LinearOpMode linearOpMode) {
        this.robot = linearOpMode.robot;
        robot.intake.setSpeed(1);
    }

    @Override
    public void update() {

    }

    @Override
    public void finish() {

    }
}
