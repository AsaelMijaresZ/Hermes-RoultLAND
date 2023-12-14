// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.DriverConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Arm.ArmTargets;
import frc.robot.subsystems.Arm.Elbow;
import frc.robot.subsystems.Arm.Shoulder;
import frc.robot.subsystems.Arm.Wrist;


public class RobotContainer
{
    public CommandXboxController mecha = new CommandXboxController(mechaPort);

    Shoulder shoulder = new Shoulder();
    Elbow elbow = new Elbow();
    Wrist wrist = new Wrist();

    ArmTargets armTargets = new ArmTargets();

    Trigger resetArm = mecha.a();

    Trigger frontInitial = mecha.y();
    Trigger frontHook = mecha.x();
    Trigger frontDrop = mecha.b();

    Trigger backInitial = mecha.povDown();
    Trigger backHook = mecha.povLeft();
    Trigger backDrop = mecha.povRight();

    public RobotContainer()
    {
        configureButtonBindings();
    }

    private void configureButtonBindings()
    {
        resetArm.onTrue(armTargets.resetArm());

        frontInitial.onTrue(armTargets.frontInitial());
        frontHook.onTrue(armTargets.frontHook());
        frontDrop.onTrue(armTargets.frontDrop());

        backInitial.onTrue(armTargets.backInitial());
        backHook.onTrue(armTargets.backHook());
        backDrop.onTrue(armTargets.backDrop());
    }
    
    public Command getAutonomousCommand()
    {
        return null;
    }
}