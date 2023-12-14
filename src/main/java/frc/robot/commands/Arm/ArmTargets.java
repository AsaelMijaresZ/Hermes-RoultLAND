// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Arm.Elbow;
import frc.robot.subsystems.Arm.Shoulder;
import frc.robot.subsystems.Arm.Wrist;
import static frc.robot.Constants.ArmConstants.*;

public class ArmTargets
{
    Shoulder shoulder = new Shoulder();
    Elbow elbow = new Elbow();
    Wrist wrist = new Wrist();

    public ParallelCommandGroup resetArm()
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[0]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[0]), elbow)
        );
    }

    public ParallelCommandGroup frontInitial() 
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[1]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[1]), elbow)
        );
    }

    public ParallelCommandGroup backInitial() 
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[2]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[2]), elbow)
        );
    }

    public ParallelCommandGroup frontHook() 
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[3]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[3]), elbow)
        );
    }

    public ParallelCommandGroup backHook() 
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[4]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[4]), elbow)
        );
    }

    public ParallelCommandGroup frontDrop() 
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[5]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[5]), elbow)
        );
    }

    public ParallelCommandGroup backDrop() 
    {
        return new ParallelCommandGroup
        (
            new InstantCommand(() -> shoulder.setGoal(shoulderGoals[6]), shoulder),
            new InstantCommand(() -> elbow.setGoal(elbowGoals[6]), elbow)
        );
    }
   /* public RunCommand forwardShoulder(boolean trigger)
    {
        return null;
        //boolean input = shoulderLimiter.calculate(input) *armRateLimiter[0];
        //return new RunCommand(shoulder1.set(1*.3), shoulder);

    }*/
}