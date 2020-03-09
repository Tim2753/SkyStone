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

        run(newTrajectory().radius(3)
                .usePID(true)
                .startingPoint(0,0)
                .speed(1.0)
                .addPoint(0,24,0)
                //.addPoint(24,24,0)
        );

    }

}
