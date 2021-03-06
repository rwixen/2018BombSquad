//Version 2.0 coded Sep. 30, 2017 by Steve, Isaac, and Marcus.
//Designed to test the functionality of OmniDrive

//package declaration
package org.firstinspires.ftc.teamcode;

//import statements
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;
import static com.qualcomm.robotcore.util.Range.clip;


@TeleOp(name = "OmniDrive", group = "OmniDriveBot")
//@Disabled
public class Drive {

    // DCMotors
    DcMotor rightMotor, leftMotor, frontMotor, backMotor;

    double leftPower;
    double rightPower;
    double frontPower;
    double backPower;


    public Drive (DcMotor newRightMotor, DcMotor newLeftMotor, DcMotor newFrontMotor, DcMotor newBackMotor) {
        rightMotor = newRightMotor;
        leftMotor = newLeftMotor;
        frontMotor = newFrontMotor;
        backMotor = newBackMotor;

        // Motor directions: set forward/reverse
        rightMotor.setDirection(REVERSE);
        leftMotor.setDirection(FORWARD);
        frontMotor.setDirection(FORWARD);
        backMotor.setDirection(REVERSE);
    }

    //turn the robot without moving
    //power is
    public void turn (double power)
    {
        leftPower = power;
        rightPower = -(power);
        frontPower = -power;
        backPower = power;
    }

    public void move (double xPower, double yPower)
    {
        leftPower = yPower;
        rightPower = yPower;
        frontPower = -(xPower);
        backPower = -(xPower);
    }

    public void run ()
    {
        // clip power to ensure we are not giving too high a value
        frontPower = Range.clip(frontPower, -1, 1);
        backPower = Range.clip(backPower, -1, 1);
        leftPower = Range.clip(leftPower, -1, 1);
        rightPower = Range.clip(rightPower, -1, 1);


        //set motor powers
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
        frontMotor.setPower(frontPower);
        backMotor.setPower(backPower);
    }
}   //end class
