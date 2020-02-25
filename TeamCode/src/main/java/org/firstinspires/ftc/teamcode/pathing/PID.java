package org.firstinspires.ftc.teamcode.pathing;

public class PID {

    public static double kP = 4;
    public static double kI = 0;
    public static double kD = 1;
    public double prevError;
    public double prevTime;
    public double i = 0;
    public double p;
    public double d;
    public static double maxI = 1;



    public static void setValues(double P, double I, double D) {
        kP = P;
        kI = I;
        kD = D;
    }
    public double getSpeed(double speed, double error, double time) {

        p = kP * error;
        i += kI *  (error * (time - prevTime));
        if (i > maxI)
            i = maxI;
        else if (i < -maxI)
            i = - maxI;

        d = kD * (error - prevError)/(time-prevTime);

        prevError = error;
        prevTime = time;

        return speed * (p + i + d);

    }
}
