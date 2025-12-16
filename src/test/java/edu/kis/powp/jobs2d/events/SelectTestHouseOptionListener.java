package edu.kis.powp.jobs2d.events;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectTestHouseOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestHouseOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int baseX = -50;
        int baseY = -50;
        int squareSize = 100;
        int roofHeight = 60;
        
        List<DriverCommand> squareCommands = new ArrayList<>();
        squareCommands.add(new SetPositionCommand(baseX, baseY));
        squareCommands.add(new OperateToCommand(baseX + squareSize, baseY));
        squareCommands.add(new OperateToCommand(baseX + squareSize, baseY + squareSize));
        squareCommands.add(new OperateToCommand(baseX, baseY + squareSize));
        squareCommands.add(new OperateToCommand(baseX, baseY));
        
        ComplexCommand squareCommand = new ComplexCommand(squareCommands);
        
        List<DriverCommand> roofCommands = new ArrayList<>();
        roofCommands.add(new SetPositionCommand(baseX, -(baseY + squareSize)));
        roofCommands.add(new OperateToCommand(baseX + squareSize / 2, -(baseY + squareSize + roofHeight)));
        roofCommands.add(new OperateToCommand(baseX + squareSize, -(baseY + squareSize)));
        
        ComplexCommand roofCommand = new ComplexCommand(roofCommands);
        
        List<DriverCommand> houseCommands = new ArrayList<>();
        houseCommands.add(squareCommand);
        houseCommands.add(roofCommand);
        
        ComplexCommand houseCommand = new ComplexCommand(houseCommands);
        
        houseCommand.execute(driverManager.getCurrentDriver());
    }
}
