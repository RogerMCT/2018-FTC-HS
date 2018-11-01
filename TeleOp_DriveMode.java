package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Drive: Normal", group="Drive")
public class TeleOp_DriveMode extends OpMode{
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
        myRobot.leftDrive(-gamepad1.left_stick_y);
        myRobot.rightDrive(-gamepad1.right_stick_y);

        myRobot.armDrive(-gamepad2.left_stick_y);

        if (gamepad2.a) {
            myRobot.intakeDrive(1);
        } else if (gamepad2.b) {
            myRobot.intakeDrive(-1);
        } else {
            myRobot.intakeDrive(0);
        }
        telemetry.addData("Status", "Seconds: %.02f", runtime.seconds());
    }
}
