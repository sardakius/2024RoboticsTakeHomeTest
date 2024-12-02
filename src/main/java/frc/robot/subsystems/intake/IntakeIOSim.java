package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.simulation.PWMSim;

public class IntakeIOSim implements IntakeIO{
    private final PWMSim intakeFront = new PWMSim(6);
    private final PWMSim intakeBack = new PWMSim(7);
    
    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.speedFrontIntake = intakeFront.getSpeed();
        inputs.speedBackIntake = intakeBack.getSpeed();
    }

    @Override public void setFront(double speed) {intakeFront.setSpeed(speed);}
    @Override public void setBack(double speed) {intakeBack.setSpeed(speed);}
    
    @Override
    public void stopAll() {
        intakeFront.setSpeed(0);
        intakeBack.setSpeed(0);
    }
}
