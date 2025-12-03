package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureJaneOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
        AbstractDriver abstractDriverAdapter = new AbstractDriverAdapter();
        FiguresJane.figureScript(abstractDriverAdapter);
	}
}
