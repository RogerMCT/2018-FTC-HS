package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="Auto: Drive Turn Crater", group="Auto")
public class Auto_TurnToCrater extends OpMode {
    MyRobot myRobot = new MyRobot();

    @Override
    public void init() {
        myRobot.init(hardwareMap);
    }

    @Override
    public void start() {
        myRobot.autoDriveDistance(24, 24, 1);
        myRobot.autoDriveTurn(1, -1, 2);
        myRobot.autoDriveDistance(120, 120, 1);
    }

    @Override
    public void loop() {

    }

}
