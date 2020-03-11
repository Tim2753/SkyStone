package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.pathing.PID;

public class lift {

    LinearOpMode linearOpMode;

    DcMotor leftLift, rightLift;

    public PID pid;

    public double steadyState;

    // encoder
    public DcMotor encoder;

    double leftSpeed = 0, rightSpeed = 0;

    public lift(LinearOpMode linearOpMode) {
        this.linearOpMode = linearOpMode;
        init();
    }
    public void run() {
        leftLift.setPower(leftSpeed);
        rightLift.setPower(rightSpeed);
    }

    public void init() {

        leftLift = linearOpMode.hardwareMap.get(DcMotor.class, "lift_left");

        // has encoder
        rightLift = linearOpMode.hardwareMap.get(DcMotor.class, "lift_right");
        encoder = linearOpMode.hardwareMap.get(DcMotor.class, "lift_right");

        leftLift.setDirection(DcMotor.Direction.REVERSE);
        rightLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        encoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        pid.setValues(1,0,0);

    }
    public void setPower(double power) {
        leftSpeed = power + steadyState;
        rightSpeed = power + steadyState;
    }
    public void setSteadyState(double power) {
        steadyState = power;
    }
}
