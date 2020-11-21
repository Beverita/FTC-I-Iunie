package org.firstinspires.ftc.teamcode.strafer;

import com.technototes.library.command.Command;
import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.InstantCommand;
import com.technototes.library.command.simple.MecanumDriveCommand;
import com.technototes.library.control.gamepad.CommandGamepad;
import com.technototes.library.subsystem.drivebase.DrivebaseSubsystem;

import static com.technototes.subsystem.DrivebaseSubsystem.DriveSpeed.NORMAL;
import static com.technototes.subsystem.DrivebaseSubsystem.DriveSpeed.TURBO;

public class OI {

    public Robot robot;
    public CommandGamepad driverGamepad;

    public OI(CommandGamepad g1, CommandGamepad g2, Robot r) {
        driverGamepad = g1;
        robot = r;
        setDriverControls();
    }

    public void setDriverControls() {
        driverGamepad.y.whenToggled(new InstantCommand(() -> robot.drivebaseSubsystem.driveSpeed = TURBO))
                .whenInverseToggled(new InstantCommand(() -> robot.drivebaseSubsystem.driveSpeed = NORMAL));
    }

}
