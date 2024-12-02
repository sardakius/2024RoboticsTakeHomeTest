package frc.robot.subsystems.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class IntakeSparkMax implements IntakeIO{
    private final CANSparkMax intakeFront = new CANSparkMax(8, MotorType.kBrushless);
    private final CANSparkMax intakeBack = new CANSparkMax(9, MotorType.kBrushless);
    
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
