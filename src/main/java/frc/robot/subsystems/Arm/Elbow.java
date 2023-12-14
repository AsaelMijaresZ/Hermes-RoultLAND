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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import static frc.robot.Constants.ArmConstants.*;

public class Elbow extends ProfiledPIDSubsystem
{
  private final CANSparkMax elbow = new CANSparkMax(armMotorIDs[2], MotorType.kBrushless);

  private final DutyCycleEncoder elbowEncoder = new DutyCycleEncoder(armEncoderChannels[1]);


  public Elbow()
  {
    super(
        new ProfiledPIDController(
            armP[1],
            armI[1],
            armD[1],
            elbowConstraints));
    
    elbow.restoreFactoryDefaults();

    elbow.setIdleMode(IdleMode.kBrake);

    elbow.setInverted(armMotorInverted[2]);

    elbowEncoder.setDistancePerRotation(armDistancePerRotation);
    elbowEncoder.setPositionOffset(armOffsets[1]);
  }

  @Override
  public void useOutput(double output, TrapezoidProfile.State setpoint)
  {
    elbow.set(output);
  }

  @Override
  public double getMeasurement()
  {
    return elbowEncoder.getAbsolutePosition() - elbowEncoder.getPositionOffset();
  }

  @Override
  public void periodic()
  {
    SmartDashboard.putNumber("ELBOW", getMeasurement());
  }

  public void manual(double input)
  {
    elbow.set(input);
  }
}
