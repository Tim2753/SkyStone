package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class intake {

    public double speed = 0;
    LinearOpMode linearOpMode;
    Servo leftIntake, rightIntake;
    DcMotor intake;
    static final double UP_POS = 0;
    static final double DOWN_POS = 0;
    static final double MID_POS = 0;

    public intake(LinearOpMode linearOpMode) {

        this.linearOpMode = linearOpMode;
        init();

    }
    public void init() {

        intake = linearOpMode.hardwareMap.get(DcMotor.class, "intake");
        leftIntake = linearOpMode.hardwareMap.get(Servo.class, "left_intake");
        rightIntake = linearOpMode.hardwareMap.get(Servo.class, "right_intake");

    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void run() {
        intake.setPower(speed);
    }
    public void toPos(double pos) {
        leftIntake.setPosition(1-pos);
        rightIntake.setPosition(pos);
    }
    public void mid(){
        toPos(MID_POS);
    }
    public void up() {
        toPos(UP_POS);
    }
    public void down() {
        toPos(DOWN_POS);
    }
}
