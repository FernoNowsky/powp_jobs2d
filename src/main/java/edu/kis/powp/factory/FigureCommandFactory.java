package edu.kis.powp.factory;

import edu.kis.powp.command.DriverCommand;

public class FigureCommandFactory {

    public static DriverCommand createRectangle(int x, int y, int width, int height) {
        FigureFactory factory = new RectangleFactory(x, y, width, height);
        return factory.createFigure();
    }

    public static DriverCommand createCircle(int centerX, int centerY, int radius) {
        FigureFactory factory = new CircleFactory(centerX, centerY, radius);
        return factory.createFigure();
    }

    public static DriverCommand createTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        FigureFactory factory = new TriangleFactory(x1, y1, x2, y2, x3, y3);
        return factory.createFigure();
    }
}

