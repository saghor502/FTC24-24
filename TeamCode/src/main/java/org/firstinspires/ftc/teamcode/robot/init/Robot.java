package org.firstinspires.ftc.teamcode.robot.init;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    private DcMotor slider, turret;

    private static Telemetry telemetry;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry){
        Robot.telemetry = telemetry;
        slider = hardwareMap.get(DcMotor.class, "slider");
        turret = hardwareMap.get(DcMotor.class, "turret");

    }

    public void moveSlider(double power){
        slider.setPower(power);
    }
    public void moveTurret(double power){
        turret.setPower(power);
    }
}
