package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Auto: Drive Straight", group="Auto")
public class Auto_DriveStraightToCrater extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    MyRobot myRobot = new MyRobot();
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        myRobot.init(hardwareMap);
    }
    @Override
    public void start() {
        runtime.reset();
    }
    @Override
    public void loop() {
        if(runtime.seconds() < 4)
        {
            myRobot.bothDrive(1);
        }
        else
        {
            myRobot.bothDrive(0);
        }
        telemetry.addData("Status", "Seconds: %.02f", runtime.seconds());
    }
}
