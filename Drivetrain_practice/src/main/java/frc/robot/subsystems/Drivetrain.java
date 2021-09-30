// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private  WPI_VictorSPX m_leftFrontMotor = new WPI_VictorSPX (Constants.CAN.drive_lf);
    private WPI_TalonSRX  m_leftBackMotor = new WPI_TalonSRX(Constants.CAN.drive_lb);
    public SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(m_leftFrontMotor,m_leftBackMotor);

    private WPI_VictorSPX  m_rightFrontMotor = new WPI_VictorSPX(Constants.CAN.drive_rf);
    private WPI_TalonSRX m_rightBackMotor = new WPI_TalonSRX (Constants.CAN.drive_rb);
    public SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(m_rightFrontMotor, m_rightBackMotor);

    public DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  public Drivetrain() {}

  public void arcadeDrive(double xSpeed, double zRotation){
    m_drive.arcadeDrive(xSpeed, zRotation);
  }
}
