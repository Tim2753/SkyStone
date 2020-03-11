package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Team2753LinearOpMode;
import org.firstinspires.ftc.teamcode.actions.DOWN;
import org.firstinspires.ftc.teamcode.actions.FOUNDATION;
import org.firstinspires.ftc.teamcode.actions.GRAB;
import org.firstinspires.ftc.teamcode.actions.LIFT;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

@TeleOp(name = "test teleop")
public class teleop extends Team2753LinearOpMode {

    boolean wasTriggerDown = false;
    boolean foundationDown = false;
    @Override
    public void runOpMode() {

        invoke();
        waitForStart();

        while (opModeIsActive()) {

            robot.drive.move(Math.toRadians(optimize(Math.atan2(gamepad1.left_stick_y,gamepad1.left_stick_x)-robot.getTheta()-45)),Math.hypot(gamepad1.left_stick_y,gamepad1.left_stick_x),gamepad1.right_stick_x);

            runAction(new LIFT());

            if (!wasTriggerDown && gamepad2.right_bumper) {
                runAction(new GRAB());
                wasTriggerDown = true;
            } else if (!gamepad2.right_bumper) {
                wasTriggerDown = false;
            }

            robot.intake.setSpeed(gamepad1.right_trigger - gamepad1.left_trigger);
            if (!foundationDown && gamepad1.a) {
                runAction(new FOUNDATION());
                foundationDown = true;
            } else if (!gamepad1.a) {
                foundationDown = false;
            }

            if (gamepad2.y) {
                robot.v4b.rotate(0.45);
            }
            if (gamepad2.x) {
                robot.v4b.rotate(0);
            }
            if (gamepad2.b) {
                robot.v4b.rotate(1);
            }
            if (gamepad2.a) {
                robot.lift.setSteadyState(gamepad2.left_stick_y);
            }



            run();

        }

    }
}
