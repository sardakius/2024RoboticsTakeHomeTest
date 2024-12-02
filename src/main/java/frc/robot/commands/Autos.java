// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.questionOneConstants;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command arcadeAuto(Drive m_drive) {
    return Commands.sequence(new RunCommand(() -> m_drive.arcadeDrive(questionOneConstants.defMoveVel, 0), m_drive).withTimeout(15), new RunCommand(() -> m_drive.arcadeDrive(0, questionOneConstants.defTurnVel), m_drive).withTimeout(180/questionOneConstants.defTurnVel));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
