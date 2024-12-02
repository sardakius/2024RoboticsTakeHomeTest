// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase;

import frc.robot.Constants.questionOneConstants;

public class Drive extends SubsystemBase {

  private final CANSparkMax leftFront = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax leftRear = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax rightFront = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax rightRear = new CANSparkMax(3, MotorType.kBrushless);

  private final SparkPIDController[] m_pidControllers =  {
    leftFront.getPIDController(),
    leftRear.getPIDController(),
    rightFront.getPIDController(),
    rightRear.getPIDController()
  };

  private final DifferentialDrive  m_driveTrain;

  private final CommandPS4Controller m_controller;

  public Drive(final CommandPS4Controller controller) {
    leftRear.follow(leftFront);
    leftFront.setInverted(true);

    rightRear.follow(rightFront);


    m_driveTrain = new DifferentialDrive(leftFront, rightFront);
    m_controller = controller;

    for (int i = 0; i < 4; i++) {m_pidControllers[i].setP(questionOneConstants.kP);  m_pidControllers[i].setI(questionOneConstants.kI); m_pidControllers[i].setD(questionOneConstants.kD);}

    setDefaultCommand(new RunCommand(() -> {this.arcadeDrive(m_controller.getLeftY(), m_controller.getLeftX());})); // joystick control command
  }

  public void arcadeDrive(final double moveVel, final double turnVel) {
    for (int i = 0; i < 4; i++) {m_pidControllers[i].setReference(turnVel, CANSparkBase.ControlType.kVelocity); m_pidControllers[i].setReference(moveVel, CANSparkBase.ControlType.kVelocity); }
    m_driveTrain.arcadeDrive(moveVel, turnVel);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}