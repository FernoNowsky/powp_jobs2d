package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class SetPositionCommand implements DriverCommand {

    private final int x;
    private final int y;

    public SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        currentDriver.setPosition(x, y);
    }

}
