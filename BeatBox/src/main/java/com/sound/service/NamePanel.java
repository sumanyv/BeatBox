package com.sound.service;

import java.awt.GridLayout;
import java.awt.Label;

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
	public final String[] instrumentNames = {	"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
		"Crash Cymbai","Hand Clap","High Tom","Hi Bong","Maracas","Whistle",
		"Low Conga","Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi conga"
	};

	/**
	 * Create the panel.
	 */
	public NamePanel() {
		
		setLayout(new GridLayout());
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i=0 ;i<BeatBox.TOTAL_INSTRUMENTS;i++){
			log.trace("Add New Name Panel : {} , At Position : {}",instrumentNames[i],i);
			nameBox.add(new Label(instrumentNames[i]));
		}

	}

}
