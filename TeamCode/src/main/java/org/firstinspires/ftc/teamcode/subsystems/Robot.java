package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.util.Odometry.OdometryGlobalCoordinatePosition;

public class Robot {

    private double x;
    private double y;
    private double theta;

    public BNO055IMU imu;
    public Orientation angles;
    BNO055IMU.Parameters IMUparameters = new BNO055IMU.Parameters();
    DcMotor verticalRight, verticalLeft, horizontal;
    public void initOdometry() {
        //Odometry encoder wheels
        DcMotor verticalRight, verticalLeft, horizontal;

        //The amount of encoder ticks for each inch the robot moves. This will change for each robot and needs to be changed here
        final double COUNTS_PER_INCH = 307.699557;

        //Hardware map names for the encoder wheels. Again, these will change for each robot and need to be updated below
        String verticalLeftEncoderName = "rf", verticalRightEncoderName = "lf", horizontalEncoderName = "lb";
    }


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
        //Odometry encoder wheels


        //The amount of encoder ticks for each inch the robot moves. This will change for each robot and needs to be changed here
        final double COUNTS_PER_INCH = 307.699557;

        //Hardware map names for the encoder wheels. Again, these will change for each robot and need to be updated below
        String verticalLeftEncoderName = "rf", verticalRightEncoderName = "lf", horizontalEncoderName = "lb";
        OdometryGlobalCoordinatePosition globalPositionUpdate = new OdometryGlobalCoordinatePosition(verticalLeft, verticalRight, horizontal, COUNTS_PER_INCH, 75);
        Thread positionThread = new Thread(globalPositionUpdate);
        positionThread.start();
        x = globalPositionUpdate.returnXCoordinate();
        return x;
    }
    public double getY() {
        //Odometry encoder wheels

        //The amount of encoder ticks for each inch the robot moves. This will change for each robot and needs to be changed here
        final double COUNTS_PER_INCH = 307.699557;

        //Hardware map names for the encoder wheels. Again, these will change for each robot and need to be updated below
        String verticalLeftEncoderName = "rf", verticalRightEncoderName = "lf", horizontalEncoderName = "lb";
        OdometryGlobalCoordinatePosition globalPositionUpdate = new OdometryGlobalCoordinatePosition(verticalLeft, verticalRight, horizontal, COUNTS_PER_INCH, 75);
        Thread positionThread = new Thread(globalPositionUpdate);
        positionThread.start();
        y = globalPositionUpdate.returnYCoordinate();
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
