package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@TeleOp(name = "odometry test")
public class OdometryTest extends Team2753LinearOpMode {

    @Override
    public void runOpMode() {

        invoke();
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("X ", robot.getX());
            telemetry.addData("Y ", robot.getY());
            telemetry.update();

        }
    }
}
