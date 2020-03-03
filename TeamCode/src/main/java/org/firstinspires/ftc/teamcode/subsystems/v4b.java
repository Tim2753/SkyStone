package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class v4b {

    Servo grabber, armLeft, armRight, capper;

    public boolean isGrabbed = false;
    public boolean isCapped = false;


    public static final double GRAB_POS = 0.6;
    public static final double RELEASE_POS = 0.2;
    public static final double CAP_POS = 1.0;
    public static final double HOLD_POS = 0.7;

    LinearOpMode linearOpMode;

    public v4b(LinearOpMode linearOpMode) {
        this.linearOpMode = linearOpMode;
        init();
    }


    public void init() {

        grabber = linearOpMode.hardwareMap.get(Servo.class, "grabber");
        armLeft = linearOpMode.hardwareMap.get(Servo.class, "armservoleft");
        armRight = linearOpMode.hardwareMap.get(Servo.class, "armservoright");
        capper = linearOpMode.hardwareMap.get(Servo.class, "caprelease");

    }
    public void grab() {
        grabber.setPosition(GRAB_POS);
        isGrabbed = true;
    }
    public void release() {
        grabber.setPosition(RELEASE_POS);
        isGrabbed = false;
    }
    public void cap() {
        capper.setPosition(CAP_POS);
        isCapped = true;
    }
    public void lock() {
        capper.setPosition(HOLD_POS);
        isCapped = false;
    }
}
