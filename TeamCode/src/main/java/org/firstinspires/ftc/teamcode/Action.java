package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

public abstract class Action {

    protected Robot robot;
    public boolean running = false;
    public boolean runable = true;
    public abstract void start(Team2753LinearOpMode linearOpMode);
    public abstract void update();
    public abstract void finish();
}
