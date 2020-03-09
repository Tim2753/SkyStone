package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class drivetrain extends Robot {

    public DcMotor frontLeft,frontRight,backLeft,backRight;


    public drivetrain(LinearOpMode linearOpMode) {

        super.linearOpMode = linearOpMode;
        init();
        brake();

    }
    public void move(double angle, double speed, double turn) {
        if (speed > 1)
            speed = 1;
        frontLeft.setPower((speed * Math.cos(angle)) + 0.3*turn);
        frontRight.setPower((speed * Math.sin(angle)) - 0.3*turn);
        backLeft.setPower((speed * Math.sin(angle)) + 0.3*turn);
        backRight.setPower((speed * Math.cos(angle) ) - 0.3*turn);

    }
    public void init() {
        super.linearOpMode.telemetry.addLine("InitDrive");
        super.linearOpMode.telemetry.update();
        backLeft = super.linearOpMode.hardwareMap.get(DcMotor.class, "left_back");
        backRight = super.linearOpMode.hardwareMap.get(DcMotor.class, "right_back");
        frontLeft = super.linearOpMode.hardwareMap.get(DcMotor.class, "left_front");
        frontRight = super.linearOpMode.hardwareMap.get(DcMotor.class, "right_front");

        backRight.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);


    }
    public void brake() {
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void kill() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}
