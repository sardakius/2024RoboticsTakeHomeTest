package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeIOTalon implements IntakeIO{
    private final WPI_TalonSRX intakeFront = new WPI_TalonSRX(10);
    private final WPI_TalonSRX intakeBack = new WPI_TalonSRX(11);
    
    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.speedFrontIntake = intakeFront.get();
        inputs.speedBackIntake = intakeBack.get();
    }

    @Override public void setFront(double speed) {intakeFront.set(speed);}
    @Override public void setBack(double speed) {intakeBack.set(speed);}
    
    @Override
    public void stopAll() {
        intakeFront.set(0);
        intakeBack.set(0);
    }
}
