package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;
import org.firstinspires.ftc.teamcode.actions.DOWN;
import org.firstinspires.ftc.teamcode.actions.GRAB;
import org.firstinspires.ftc.teamcode.actions.LIFT;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@TeleOp(name = "test teleop")
public class teleop extends Team2753LinearOpMode {

    boolean wasTriggerDown = false;
    @Override
    public void runOpMode() {

        invoke();
        waitForStart();

        while (opModeIsActive()) {

            robot.drive.backLeft.setPower(gamepad1.left_stick_y);
            robot.drive.frontLeft.setPower(gamepad1.left_stick_y);
            robot.drive.backRight.setPower(gamepad1.right_stick_y);
            robot.drive.frontRight.setPower(gamepad1.right_stick_y);

            //if (!running.contains(DOWN) && gamepad1.a) {
               // DOWN = new DOWN();
                //runAction(DOWN);
            //}
            runAction(new LIFT());
            telemetry.addData("TIME: ", time);
            telemetry.addData("Is \"running\" empty? ", running.isEmpty());
            if (!wasTriggerDown && gamepad2.right_bumper) {
                telemetry.addLine(":)");
                runAction(new GRAB());
                wasTriggerDown = true;
            } else if (!gamepad2.right_bumper) {
                wasTriggerDown = false;
            }
            if (gamepad2.left_bumper) {
                robot.v4b.rotate(0.45);
            }
            if (gamepad2.y) {
                robot.v4b.rotate(0);
            }
            if (gamepad2.x) {
                robot.v4b.rotate(1);
            }



            run();

        }

    }
}
