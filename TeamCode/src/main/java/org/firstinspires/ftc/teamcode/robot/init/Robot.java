package org.firstinspires.ftc.teamcode.robot.init;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    private DcMotor slider, turret;
    private CRServo claw1, claw2, artClaw;

    private static Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        Robot.telemetry = telemetry;
        slider = hardwareMap.get(DcMotor.class, "slider");
        turret = hardwareMap.get(DcMotor.class, "turret");
        claw1 = hardwareMap.get(CRServo.class, "c1");
        claw2 = hardwareMap.get(CRServo.class, "c2");
        artClaw = hardwareMap.get(CRServo.class, "ac");
    }

    public void moveSlider(double power){
        slider.setPower(power);
    }
    public void moveTurret(double power){
        turret.setPower(power);
    }

    public void turnClaw(double power){
        artClaw.setPower(power);
    }
    public void claw(double power){
        claw1.setPower(-power);
        claw2.setPower(power);
    }
}
