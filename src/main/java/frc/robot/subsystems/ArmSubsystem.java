package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends PIDSubsystem implements AutoCloseable {
  public static CANSparkMax ArmMotor1;
  public static CANSparkMax ArmMotor2;
  private static Encoder encoder;
  public static DoubleSolenoid ExtendingSolenoid;
  public static DoubleSolenoid ClawSolenoid;

  public ArmSubsystem() {
    super(new PIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD));
    ArmMotor1 = new CANSparkMax(ArmConstants.kArmMotor1, MotorType.kBrushless);
    ArmMotor2 = new CANSparkMax(ArmConstants.kArmMotor2, MotorType.kBrushless);

    ExtendingSolenoid =
        new DoubleSolenoid(
            PneumaticsModuleType.CTREPCM, ArmConstants.kExtSolPort1, ArmConstants.kExtSolPort2);
    ClawSolenoid =
        new DoubleSolenoid(
            PneumaticsModuleType.CTREPCM, ArmConstants.kClawSolPort1, ArmConstants.kClawSolPort2);

    // Encoder encoder = new Encoder(0, 1, false, EncodingType.k2X);
  }

  // public void GravityOffset(int ktargetPos) {
  //   int kMeasuredPosHorizontal =
  //       840; // position measured when arm is horizontal (with Pheonix Tuner)
  //   double kTicksPerDegree = 4092 / 360; // sensor is 1:1 with arm rotation
  //   double currentPos = ArmMotor1.getSelectedSensorPosition();
  //   double degrees = (currentPos - kMeasuredPosHorizontal) / kTicksPerDegree;
  //   double radians = java.lang.Math.toRadians(degrees);
  //   double cosineScalar = java.lang.Math.cos(radians);
  //   double maxGravityFF = 0.7;
  //   ArmSubsystem.ArmMotor1.set(
  //       ControlMode.MotionMagic,
  //       ktargetPos,
  //       DemandType.ArbitraryFeedForward,
  //       maxGravityFF * cosineScalar);
  // }

  public void ArmExtendMedCommand() {
    // will likely use pneumatics
    System.out.println("Extending to moderate length...");
  }

  public void ArmExtendFarCommand() {
    // will likely use pneumatics
    System.out.println("Extending to maximum length...");
  }

  public void ArmRetractCommand() {
    // will likely use pneumatics
    System.out.println("Returning to default length...");
  }

  public void ArmMidHeightCommand() {
    // GravityOffset(ArmConstants.kMidHeight);

    System.out.println("Raising arm to moderate elevation...");
  }

  public void ArmMaxHeightCommand() {
    // GravityOffset(ArmConstants.kMaxHeight);

    System.out.println("Raising arm to maximum elevation...");
  }

  public void ArmDefaultHeightCommand() {
    // GravityOffset(ArmConstants.kDefaultHeight);

    System.out.println("Returning to default elevation...");
  }

  public void ClawGraspCommand() {
    // will likely use pneumatics
    System.out.println("Closing claw...");
  }

  public void ClawReleaseCommand() {
    // will likely use pneumatics
    System.out.println("Releasing claw...");
  }

  @Override
  public void periodic() {
    // encoder.getDistance();
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    // TODO Auto-generated method stub

  }

  @Override
  protected double getMeasurement() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void close() throws Exception {
    ArmMotor1.close();
    ArmMotor2.close();
    ExtendingSolenoid.close();
    ClawSolenoid.close();
    // encoder.close();
  }
}
