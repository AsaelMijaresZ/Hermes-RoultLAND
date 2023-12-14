// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import static frc.robot.Constants.ArmConstants.*;

public class Wrist
{
  private final TalonFX wrist = new TalonFX (armMotorIDs[3]);



  public Wrist()
  {
    wrist.setNeutralMode(NeutralMode.Brake);
    wrist.setInverted(armMotorInverted[2]);
  }

  /*@Override
  public void useOutput(double output, TrapezoidProfile.State setpoint)
  {
    wrist.set(ControlMode.PercentOutput, output);
  }

  @Override
  public double getMeasurement()
  {
    return ((wrist.getSelectedSensorPosition() / wristCPR) * armDistancePerRotation);
  }

  @Override
  public void periodic()
  {
    SmartDashboard.putNumber("WRIST", getMeasurement());
  }

  public void manual(double input)
  {
    wrist.set(ControlMode.PercentOutput, input);
  }*/
}