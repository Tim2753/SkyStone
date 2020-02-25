package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

public abstract class Action {

    Robot robot;
    boolean running = false;
    boolean runable = true;
    public abstract void start();
    public abstract void update();
    public abstract void finish();
}
