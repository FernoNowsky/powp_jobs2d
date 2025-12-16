package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory implements FigureFactory {
    
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final int x3;
    private final int y3;
    
    public TriangleFactory(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
    
    @Override
    public DriverCommand createFigure() {
        List<DriverCommand> commands = new ArrayList<>();
        
        commands.add(new SetPositionCommand(x1, y1));
        commands.add(new OperateToCommand(x2, y2));
        commands.add(new OperateToCommand(x3, y3));
        commands.add(new OperateToCommand(x1, y1));
        
        return new ComplexCommand(commands);
    }
}
