package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;
    private DrawPanelController drawPanelController;
    private ILine selectedLine = LineFactory.getBasicLine();

    public LineDrawerAdapter() {
        this.drawPanelController = DrawerFeature.getDrawerController();
	}

    public LineDrawerAdapter(ILine selectedLine) {
        this.drawPanelController = DrawerFeature.getDrawerController();
        this.selectedLine = selectedLine;
    }

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		selectedLine.setStartCoordinates(this.startX, this.startY);
        selectedLine.setEndCoordinates(x, y);
		this.drawPanelController.drawLine(selectedLine);
        setPosition(x, y);
	}

    public void setSelectedLine(ILine selectedLine) {
        this.selectedLine = selectedLine;
    }

    public ILine getSelectedLine() {
        return this.selectedLine;
    }

    @Override
	public String toString() {
		return "@Q!$!@$!#@$(*#@&Q(%^*#@";
	}
}
