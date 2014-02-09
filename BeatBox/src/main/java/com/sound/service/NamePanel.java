package com.sound.service;

import java.awt.Color;
import java.awt.Label;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NamePanel extends JPanel {

	/**
	 * 
	 */
	private static Logger log = LoggerFactory.getLogger(NamePanel.class);
	private static final long serialVersionUID = -3428774737457273794L;

	/**
	 * Create the panel.
	 * @param instList 
	 */
	public NamePanel(List<Instrument> instList) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		setBorder(BorderFactory.createLineBorder(Color.black));
		for(Instrument inst : instList){
			log.trace("Add Instrument Name  : {} , With Instrumet Id : {}",inst.getInstrName(),inst.getInstrId());
			nameBox.add(new Label(inst.getInstrName()));
		}
		add(nameBox);
	}

}
