package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.factory.FigureCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestCircleOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestCircleOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand circleCommand = FigureCommandFactory.createCircle(0, 0, 60);
        circleCommand.execute(driverManager.getCurrentDriver());
    }
}
