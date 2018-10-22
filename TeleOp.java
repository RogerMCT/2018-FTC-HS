package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Teleop Mode", group="Iterative Opmode")
//@Disabled
public class TeleOp extends OpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    //Motors
    private DcMotor left_drive = null;
    private DcMotor right_drive = null;
    private DcMotor arm_raise = null;
    private DcMotor arm_eat = null;
    //Color Sensor
    ColorSensor sensorColor;
    DistanceSensor sensorDistance;
    float hsvValues[] = {0F, 0F, 0F};
    final float values[] = hsvValues;
    final double SCALE_FACTOR = 255;


    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        //MotersDrive
        left_drive  = hardwareMap.get(DcMotor.class, "left_drive");
        left_drive.setDirection(DcMotor.Direction.REVERSE);

        right_drive  = hardwareMap.get(DcMotor.class, "right_drive");
        right_drive.setDirection(DcMotor.Direction.FORWARD);

        //OtherMoters
        arm_raise  = hardwareMap.get(DcMotor.class, "arm_raise");
        arm_raise.setDirection(DcMotor.Direction.FORWARD);

        arm_eat  = hardwareMap.get(DcMotor.class, "arm_eat");
        arm_eat.setDirection(DcMotor.Direction.FORWARD);

        //Color Sensor
        sensorColor = hardwareMap.get(ColorSensor.class, "color_cassie");
        sensorDistance = hardwareMap.get(DistanceSensor.class, "color_cassie");

    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        // Drive Motors
        left_drive.setPower(Range.clip(-gamepad1.left_stick_y, -1.0, 1.0));
        right_drive.setPower(Range.clip(-gamepad1.right_stick_y, -1.0, 1.0));

        //Motors
        arm_raise.setPower(Range.clip(-gamepad2.left_stick_y, -1.0, 1.0));


        if(gamepad2.a){
            arm_eat.setPower(1);
        }
        else if(gamepad2.b){
            arm_eat.setPower(-1);
        }
        else{
            arm_eat.setPower(0);
        }


        //Color Sensor Data
        telemetry.addData("Alpha", sensorColor.alpha());
        telemetry.addData("Red  ", sensorColor.red());
        telemetry.addData("Green", sensorColor.green());
        telemetry.addData("Blue ", sensorColor.blue());
        telemetry.addData("Hue", hsvValues[0]);

    }

    @Override
    public void stop() {
    }
}