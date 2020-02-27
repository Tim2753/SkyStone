package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;

@Autonomous(name = "Auto")
public class sampleAuto extends Team2753LinearOpMode {


    @Override
    public void runOpMode() {

        invoke();
        waitForStart();

        build(newTrajectory().radius(8)
                .usePID(true)
                .startingPoint(0,-1)
                .speed(1.0)
                .addPoint(0,21)
                .addPoint(9,30)
                .addPoint(31,30)
                .addPoint(63,15)
                .addPoint(84,33));

        while (true){
            robot.run();
            telemetry.addData("X: ", robot.getX());
            telemetry.addData("Y: ", robot.getY());
            telemetry.addData("THETA: ", robot.getTheta());
            telemetry.update();
        }

    }

}
