package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="Auto: Drive 12 inch", group="Auto")
public class Auto_DriveStraightForDistance  extends OpMode {
    MyRobot myRobot = new MyRobot();
    @Override
    public void init() {
        myRobot.init(hardwareMap);
    }
    @Override
    public void start(){
        myRobot.autoDriveDistance(12, 12, 1);
    }
    @Override
    public void loop() {

    }
}
