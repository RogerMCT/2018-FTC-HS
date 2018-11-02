package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class MyRobot {
    private DcMotor left_drive = null;
    private DcMotor right_drive = null;
    private DcMotor arm = null;
    private DcMotor intake = null;
    static final double COUNTS_PER_MOTOR_REV = 1000;
    static final double DRIVE_GEAR_REDUCTION = 1.0;
    static final double WHEEL_DIAMETER_INCHES = 4.0;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);

    public void init(HardwareMap myMap) {
        left_drive = myMap.get(DcMotor.class, "left");
        left_drive.setDirection(DcMotor.Direction.REVERSE);
        right_drive = myMap.get(DcMotor.class, "right");
        right_drive.setDirection(DcMotor.Direction.FORWARD);
        arm = myMap.get(DcMotor.class, "arm");
        arm.setDirection(DcMotor.Direction.FORWARD);
        intake = myMap.get(DcMotor.class, "intake");
        intake.setDirection(DcMotor.Direction.FORWARD);
    }

    public void leftDrive(double power)
    {
        left_drive.setPower(Range.clip(power, -1.0, 1.0));
    }
    public void rightDrive(double power)
    {
        right_drive.setPower(Range.clip(power, -1.0, 1.0));
    }
    public void armDrive(double power)
    {
        arm.setPower(Range.clip(power, -1.0, 1.0));
    }
    public void intakeDrive(double power)
    {
        intake.setPower(Range.clip(power, -1.0, 1.0));
    }
    public void bothDrive(double power)
    {
        left_drive.setPower(Range.clip(power, -1.0, 1.0));
        right_drive.setPower(Range.clip(power, -1.0, 1.0));
    }
    public void autoDriveDistance(double LeftInches, double RightInches, double power)
    {
        left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        left_drive.setTargetPosition(left_drive.getCurrentPosition() + (int)(LeftInches * COUNTS_PER_INCH));
        right_drive.setTargetPosition(right_drive.getCurrentPosition() + (int)(RightInches * COUNTS_PER_INCH));

        left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(left_drive.getCurrentPosition() < ((int)(LeftInches * COUNTS_PER_INCH)) ||
                right_drive.getCurrentPosition() < ((int)(RightInches * COUNTS_PER_INCH)))
        {
            if(left_drive.getCurrentPosition() < ((int)(LeftInches * COUNTS_PER_INCH))){
                left_drive.setPower(power);
            }
            else{
                left_drive.setPower(0);
            }
            if(right_drive.getCurrentPosition() < ((int)(RightInches * COUNTS_PER_INCH))){
                right_drive.setPower(power);
            }
            else{
                right_drive.setPower(0);
            }
        }

        left_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void autoDriveTurn(double leftPower, double rightPower, double seconds)
    {
        ElapsedTime myTime = new ElapsedTime();
        myTime.reset();
        while(myTime.seconds() < seconds) {
            leftDrive(leftPower);
            rightDrive(rightPower);
        }
    }
}
