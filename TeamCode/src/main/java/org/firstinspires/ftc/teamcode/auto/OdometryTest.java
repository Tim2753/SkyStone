package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@TeleOp(name = "odometry test")
public class OdometryTest extends LinearOpMode {

    Robot robot = new Robot(this);
    @Override
    public void runOpMode() throws InterruptedException {
        while (opModeIsActive()) {
            telemetry.addData("X ", robot.getX());
            telemetry.addData("Y ", robot.getY());
            telemetry.update();

        }
    }
}
