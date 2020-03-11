package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class foundation {

    Servo foundation;
    LinearOpMode linearOpMode;
    public boolean grabbed;

    public foundation(LinearOpMode linearOpMode) {
        this.linearOpMode = linearOpMode;
        init();
    }
    public void init() {
        foundation = linearOpMode.hardwareMap.get(Servo.class, "foundation");
    }
    public void toPos(double pos) {
        foundation.setPosition(pos);
    }
    public void grab() {
        grabbed = true;
        foundation.setPosition(1);
    }
    public void release() {
        grabbed = false;
        foundation.setPosition(0.66);
    }
}
