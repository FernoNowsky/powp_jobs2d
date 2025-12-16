package edu.kis.powp.jobs2d.events;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTestDriverCommandOptionListener implements ActionListener {

    private Job2dDriver currentDriver;

    public SelectTestDriverCommandOptionListener(DriverManager driverManager) {
        this.currentDriver = driverManager.getCurrentDriver();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        List<DriverCommand> commands = new ArrayList<>();

        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(-80, -80));
        commands.add(new OperateToCommand(-80, 0));
        commands.add(new OperateToCommand(0, 0));

        for (DriverCommand command : commands){
            command.execute(currentDriver);
        }
	}
}
