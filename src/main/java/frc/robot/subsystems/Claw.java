// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends SubsystemBase {
  private final Compressor pcomp = new Compressor(4, PneumaticsModuleType.CTREPCM);
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 5);

  boolean clawExtended = false;

  public void enablePneumatics() {
    if(!pcomp.isEnabled()) { 
        pcomp.enableDigital();
    }
  }

  public void disablePneumatics(){
    if(pcomp.isEnabled()) {
      pcomp.disable();
    }
  }

  public Claw() {
    enablePneumatics();
  }

  public void toggleSolenoid(){
    clawExtended = !clawExtended;
    m_solenoid.toggle();
  }

  public boolean isClawExtended() {
    return clawExtended;
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("claw extended?", isClawExtended());
  }
}
