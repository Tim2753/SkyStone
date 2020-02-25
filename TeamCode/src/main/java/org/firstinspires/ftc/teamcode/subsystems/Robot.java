package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class Robot {

    private double x;
    private double y;
    private double theta;

    public BNO055IMU imu;
    public Orientation angles;
    BNO055IMU.Parameters IMUparameters = new BNO055IMU.Parameters();

    // LinearOpMode required for telemetry and hardwareMap
    public LinearOpMode linearOpMode = null;

    // give linearOpMode a reference to the calling OpMode
    public Robot(LinearOpMode linearOpMode) {
        this.linearOpMode = linearOpMode;
    }
    // update robot position and angle
    public void run() {
        updateAngle();
        theta = angles.firstAngle;
        linearOpMode.telemetry.update();
        clipTheta();
    }
    // initialize IMU to get angle
    public void initIMU() {

        imu = linearOpMode.hardwareMap.get(BNO055IMU.class, "imu");
        IMUparameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        IMUparameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        IMUparameters.calibrationDataFile = "BNO055IMUCalibration.json";
        IMUparameters.loggingEnabled = true;
        IMUparameters.loggingTag = "IMU";
        imu.initialize(IMUparameters);
    }

    public void updateAngle() {
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void resetPos() {
        x=0;
        y=0;
    }
    public double getTheta() {
        return theta;
    }
    public void clipTheta() {
        if (theta > 180) {
            theta = - 180;
        } else if (theta < -180){
            theta = 180;
        }
    }
}
