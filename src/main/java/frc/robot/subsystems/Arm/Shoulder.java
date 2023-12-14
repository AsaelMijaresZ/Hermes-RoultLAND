// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;

import static frc.robot.Constants.ArmConstants.*;

public class Shoulder extends ProfiledPIDSubsystem
{
  private final CANSparkMax shoulder1 = new CANSparkMax(armMotorIDs[0], MotorType.kBrushless);
  private final CANSparkMax shoulder2 = new CANSparkMax(armMotorIDs[1], MotorType.kBrushless);

  private final MotorControllerGroup shoulder = new MotorControllerGroup(shoulder1, shoulder2);

  private final DutyCycleEncoder shoulderEncoder = new DutyCycleEncoder(armEncoderChannels[0]);

  public Shoulder()
  {
    super(
        new ProfiledPIDController(
            armP[0],
            armI[0],
            armD[0],
            shoulderConstraints));
    
    shoulder1.restoreFactoryDefaults();
    shoulder2.restoreFactoryDefaults();

    shoulder1.setIdleMode(IdleMode.kBrake);
    shoulder2.setIdleMode(IdleMode.kBrake);

    shoulder1.setInverted(armMotorInverted[0]);
    shoulder1.setInverted(armMotorInverted[1]);

    shoulder2.follow(shoulder1);

    shoulderEncoder.setDistancePerRotation(armDistancePerRotation);
    shoulderEncoder.setPositionOffset(armOffsets[0]);

    

  }

  @Override
  public void useOutput(double output, TrapezoidProfile.State setpoint)
  {
    shoulder.set(output);
  }

  @Override
  public double getMeasurement()
  {
    return shoulderEncoder.getAbsolutePosition() - shoulderEncoder.getPositionOffset();
  }

  @Override
  public void periodic()
  {
    SmartDashboard.putNumber("SHOULDER", getMeasurement());
  }

  public void manual(double input)
  {
    shoulder.set(input);
  }
}
