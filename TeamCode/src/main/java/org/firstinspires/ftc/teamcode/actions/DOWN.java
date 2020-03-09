package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Action;
import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;

public class DOWN extends Action {

    ElapsedTime time;
    @Override
    public void start(Team2753LinearOpMode linearOpMode) {
        this.robot = linearOpMode.robot;
        time = new ElapsedTime();
        running = true;

    }

    @Override
    public void update() {

        robot.lift.setPower(-robot.lift.pid.getSpeed(1,robot.lift.encoder.getCurrentPosition()/10000, time.milliseconds()));
        if (robot.lift.encoder.getCurrentPosition() < 2000) {
            running = false;
        }
    }

    @Override
    public void finish() {

        robot.lift.setPower(0);
    }
}
