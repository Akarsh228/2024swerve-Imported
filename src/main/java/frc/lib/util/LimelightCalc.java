package frc.lib.util;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Constants;
import frc.robot.Robot;

public class LimelightCalc {
    /* Calculations For Distances/Angles*/

    //get distance to target
    public static double getDistance(double ty){
       /*  double targetAngle = ty;
        double angleToGoalDegrees = targetAngle + Constants.Limelight.cameraAngle;
        double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);
        
        //calculate distance
        double distanceFromLimelightToGoalMeters = (Constants.Limelight.targetHeight - Constants.Limelight.cameraHeight)/Math.tan(angleToGoalRadians);
        return distanceFromLimelightToGoalMeters;
        */
        return Robot.distance;
    }


    /* Power Calculations */
    public static double forwardPower(double goalDistance, double currentDistance){
        double kp = 0.8;
        double error = currentDistance - goalDistance;
        double output = MathUtil.clamp(kp * error, -0.3, 0.3);
        return output;
    }

    public static double strafePower(double goalStrafe, double currentStrafe){
        double kp = 0.02;
        double error = currentStrafe - goalStrafe;
        double output = MathUtil.clamp(kp * error, -0.3, 0.3);
        return output;


    }

    public static double rotPower(double goalRotation, double currentRotation)
    {
        double kp = 0.01;
        double error = currentRotation - goalRotation;
        double output = MathUtil.clamp(kp * error, -0.2, 0.2);
        return output;
    }



}
