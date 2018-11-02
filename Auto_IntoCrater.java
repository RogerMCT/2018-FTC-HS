package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="Auto: Drive Crater", group="Auto")
public class Auto_IntoCrater extends OpMode {
    MyRobot myRobot = new MyRobot();

    @Override
    public void init() {
        myRobot.init(hardwareMap);
    }

    @Override
    public void start() {
        myRobot.autoDriveDistance(60, 60, 1);
    }

    @Override
    public void loop() {

    }
}