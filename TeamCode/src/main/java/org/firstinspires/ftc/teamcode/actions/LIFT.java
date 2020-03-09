package org.firstinspires.ftc.teamcode.actions;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

public class LIFT extends Action {
    @Override
    public void start(Team2753LinearOpMode linearOpMode) {
        this.robot = linearOpMode.robot;
        linearOpMode.telemetry.addLine("BEEP");

        if (linearOpMode.gamepad2 != null)
            linearOpMode.robot.lift.setPower(linearOpMode.gamepad2.left_stick_y);
    }

    @Override
    public void update() {

    }

    @Override
    public void finish() {

    }
}
