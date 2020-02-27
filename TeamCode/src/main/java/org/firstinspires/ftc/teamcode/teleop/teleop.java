package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@TeleOp(name = "test teleop")
public class teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        Robot robot = new Robot(this);

        waitForStart();

        while (opModeIsActive()) {

            robot.drive.backLeft.setPower(gamepad1.left_stick_y);
            robot.drive.frontLeft.setPower(gamepad1.left_stick_y);
            robot.drive.backRight.setPower(gamepad1.right_stick_y);
            robot.drive.frontRight.setPower(gamepad1.right_stick_y);


        }

    }
}
