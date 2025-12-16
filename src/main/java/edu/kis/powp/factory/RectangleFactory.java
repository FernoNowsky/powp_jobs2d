package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class RectangleFactory implements FigureFactory {
    
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    
    public RectangleFactory(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public DriverCommand createFigure() {
        List<DriverCommand> commands = new ArrayList<>();
        
        commands.add(new SetPositionCommand(x, y));
        commands.add(new OperateToCommand(x + width, y));
        commands.add(new OperateToCommand(x + width, y + height));
        commands.add(new OperateToCommand(x, y + height));
        commands.add(new OperateToCommand(x, y));
        
        return new ComplexCommand(commands);
    }
}
