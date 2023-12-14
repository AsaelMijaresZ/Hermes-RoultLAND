// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints; 


public final class Constants
{
  public static final class DriverConstants
  {
    public static final int mechaPort = 0;

    public static final boolean fieldOriented = true;
  }

  public static final class ArmConstants
  {
    public static final int[] armMotorIDs = new int[] {2, 9, 16, 11};
    public static final int[] armEncoderChannels = new int[] {3, 2};

    public static final boolean[] armMotorInverted = new boolean[] {false, false, false, false};

    public static final double[] armOffsets = new double[] {0, 0, 0};

    public static final double[] armP = new double[] {1.8735, 4.1883};
    public static final double[] armI = new double[] {0, 0};
    public static final double[] armD = new double[] {0.027183, 0.13731};

    public static final Constraints shoulderConstraints = new Constraints(147.87, 0.7854);
    public static final Constraints elbowConstraints = new Constraints(187, 0.7854);

    public static final double armDistancePerRotation = 2 * Math.PI;

    public static final int wristCPR = 2048 * /*Elbow Gearing*/(1/200);

    //Add all the goals
    public static final double[] shoulderGoals = new double[] {0};
    public static final double[] elbowGoals = new double[] {0};
    //public static final double[] wristGoals = new double[] {0};
  }
}
