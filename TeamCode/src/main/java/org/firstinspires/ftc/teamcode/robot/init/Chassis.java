package org.firstinspires.ftc.teamcode.robot.init;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Chassis {
    private DcMotor rightFront, rightRear, leftFront, leftRear;
    private static Telemetry telemetry;

    public Chassis(HardwareMap hardwareMap, Telemetry telemetry){
        Chassis.telemetry = telemetry;

        rightFront = hardwareMap.get(DcMotor.class, "rf");
        rightRear = hardwareMap.get(DcMotor.class, "rr");
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        leftRear = hardwareMap.get(DcMotor.class, "lr");
    }
    public void move(double forwardPower, double leftPower, double turnPower){
        //ly = forward, lx = leftRun, rx = turnRight
        double leftY;
        double leftX;
        double rightX;

        //MAKE THE VARIABLES ZERO IN CASE OF ERROR
        if(forwardPower < 0.2 && forwardPower > -0.2){
            leftY = 0;
        }else{
            leftY = forwardPower;
        }
        if(leftPower < 0.2 && leftPower > -0.2){
            leftX = 0;
        }else{
            leftX = leftPower;
        }
        if(turnPower < 0.2 && turnPower > -0.2){
            rightX = 0;
        }else{
            rightX = turnPower;
        }

        if(leftX != 0 && leftY != 0 && rightX != 0){
            rightFront.setPower((leftY + leftX + rightX)/3);
            rightRear.setPower((leftY - leftX + rightX)/3);
            leftFront.setPower((-leftY + leftX + rightX)/3);
            leftRear.setPower((-leftY - leftX + rightX)/3);
        }else if((leftX != 0  && leftY != 0 && rightX == 0)
                || (leftX != 0  && leftY == 0 && rightX != 0)
                || (leftX == 0  && leftY != 0 && rightX != 0)){
            rightFront.setPower((leftY + leftX + rightX)/2);
            rightRear.setPower((leftY - leftX + rightX)/2);
            leftFront.setPower((-leftY + leftX + rightX)/2);
            leftRear.setPower((-leftY - leftX + rightX)/2);
        }else if((leftX != 0  && leftY == 0 && rightX == 0)
                || (leftX == 0  && leftY != 0 && rightX == 0)
                || (leftX == 0  && leftY == 0 && rightX != 0)){
            rightFront.setPower(leftY + leftX + rightX);
            rightRear.setPower(leftY - leftX + rightX);
            leftFront.setPower(-leftY + leftX + rightX);
            leftRear.setPower(-leftY - leftX + rightX);
        }else{
            rightFront.setPower(0);
            rightRear.setPower(0);
            leftFront.setPower(0);
            leftRear.setPower(0);
        }
    }
    public void forward(double power){
        rightFront.setPower(-power);
        rightRear.setPower(-power);
        leftFront.setPower(power);
        leftRear.setPower(power);
    }
    public void leftRun(double power){
        rightFront.setPower(-power);
        rightRear.setPower(power);
        leftFront.setPower(power);
        leftRear.setPower(-power);
    }
    public void turnRight(double power){
        rightFront.setPower(-power);
        rightRear.setPower(-power);
        leftFront.setPower(-power);
        leftRear.setPower(-power);
    }
    public void stopChassis(){
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftFront.setPower(0);
        leftRear.setPower(0);
    }
}
