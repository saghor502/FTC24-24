package org.firstinspires.ftc.teamcode.robot.tlop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.init.Chassis;

@TeleOp
public class BasicTlop extends LinearOpMode {

    @Override
    public void runOpMode() {
        Chassis chassis = new Chassis(hardwareMap, telemetry);

        waitForStart();
        while (!isStopRequested()){
            /**CHASSIS**/
            chassis.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        }
    }
}
