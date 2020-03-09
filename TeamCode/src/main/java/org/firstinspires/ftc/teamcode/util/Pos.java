package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Pos extends Point{

    public double theta;
    public Pos(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
    }
    public void debug(LinearOpMode linearOpMode) {
        linearOpMode.telemetry.addLine("X:" + x + "  Y:" + y);
    }
}
