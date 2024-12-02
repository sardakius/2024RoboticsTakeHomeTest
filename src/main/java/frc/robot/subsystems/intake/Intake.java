// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Intake extends SubsystemBase {
  private final IntakeIO m_intake;
  private final IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();
  private final DigitalInput colorSensor = new DigitalInput(12);
  
  public Intake(IntakeIO intake) {
    m_intake = intake;
  }

  @Override
  public void periodic() {
    m_intake.updateInputs(inputs);
    Logger.recordOutput("intake status ", colorSensor.get());
  }

  public double getSpeedFront() {
    return inputs.speedFrontIntake;
  }

  public double getSpeedBack() {
    return inputs.speedBackIntake;
  }

  public void stopAll() {
    m_intake.stopAll();
  }

  public void setFront(double speed) {
    m_intake.setFront(speed);
  }

  public void setBack(double speed) {
    m_intake.setBack(speed);
  }
}
