package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class CircleFactory implements FigureFactory {
    
    private final int centerX;
    private final int centerY;
    private final int radius;
    private final int segments;
    
    public CircleFactory(int centerX, int centerY, int radius, int segments) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.segments = segments;
    }
    
    public CircleFactory(int centerX, int centerY, int radius) {
        this(centerX, centerY, radius, 36);
    }
    
    @Override
    public DriverCommand createFigure() {
        List<DriverCommand> commands = new ArrayList<>();
        
        double angleStep = 2 * Math.PI / segments;
        
        int firstX = centerX + (int) (radius * Math.cos(0));
        int firstY = centerY + (int) (radius * Math.sin(0));
        
        commands.add(new SetPositionCommand(firstX, firstY));
        
        for (int i = 1; i <= segments; i++) {
            double angle = i * angleStep;
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));
            commands.add(new OperateToCommand(x, y));
        }
        
        return new ComplexCommand(commands);
    }
}
