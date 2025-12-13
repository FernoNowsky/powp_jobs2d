package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTestDriverCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
        List<DriverCommand> driverCommands = new ArrayList<DriverCommand>();
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();

        driverCommands.add(new SetPositionCommand(0,0, currentDriver));
        driverCommands.add(new OperateToCommand(100,0, currentDriver));
        driverCommands.add(new OperateToCommand(100,100, currentDriver));
        driverCommands.add(new OperateToCommand(0,0, currentDriver));

        for  (DriverCommand driverCommand : driverCommands) {
            driverCommand.execute();
        }
	}
}
