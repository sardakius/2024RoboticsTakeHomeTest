package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
    @AutoLog
    public static class IntakeIOInputs {
        public double speedFrontIntake = 0.0;
        public double speedBackIntake = 0.0;
    }
    
    public default void updateInputs(IntakeIOInputs inputs) {}
    public default void setFront(double speed) {}
    public default void setBack(double speed) {}
    public default void stopAll() {}
}
