package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;
import org.firstinspires.ftc.teamcode.util.Point;

@Autonomous(name = "Auto")
public class sampleAuto extends Team2753LinearOpMode {


    @Override
    public void runOpMode() {

        invoke();
        waitForStart();

            build(newCurve().add(new Point(0,0)).add(new Point(0,20)).add(new Point(30,30)).density(20).compile());


    }

}
