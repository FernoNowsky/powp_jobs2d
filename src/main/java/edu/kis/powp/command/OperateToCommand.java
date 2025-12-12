package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class OperateToCommand implements DriverCommand {

    private final int x;
    private final int y;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        currentDriver.operateTo(x, y);
    }
}
