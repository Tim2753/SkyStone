package org.firstinspires.ftc.teamcode;

public abstract class Action {

    boolean running = false;
    boolean runable = true;
    public abstract void start();
    public abstract void update();
    public abstract void finish();
}
