package org.firstinspires.ftc.teamcode.robot.tlop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.init.Chassis;
import org.firstinspires.ftc.teamcode.robot.init.Robot;

@TeleOp
public class BasicTlop extends LinearOpMode {

    @Override
    public void runOpMode() {
        Chassis chassis = new Chassis(hardwareMap, telemetry);
        Robot robot = new Robot(hardwareMap, telemetry);

        waitForStart();
        while (!isStopRequested()){
            /**CHASSIS**/
            chassis.move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            /**MECANISMOS**/
            if(gamepad1.right_trigger > 0.2){
                robot.moveSlider(0.5);
            } else if (gamepad1.left_trigger > 0.2) {
                robot.moveSlider(-0.5);
            }else{
                robot.moveSlider(0);
            }

            if(gamepad1.dpad_up){
                robot.moveTurret(1);
            } else if (gamepad1.dpad_down) {
                robot.moveTurret(-1);
            }else{
                robot.moveTurret(0);
            }

            if(gamepad1.a){
                robot.claw(1);
            }else if(gamepad1.y){
                robot.claw(-1);
            }else{
                robot.claw(0);
            }
            if(gamepad1.x){
                robot.turnClaw(-1);
            }else if(gamepad1.b){
                robot.turnClaw(1);
            }else{
                robot.turnClaw(0);
            }
        }
    }
}
