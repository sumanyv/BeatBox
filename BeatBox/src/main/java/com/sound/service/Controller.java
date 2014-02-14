package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.view.CheckboxPanel;

public class Controller implements ActionListener{

	private final Logger log = LoggerFactory.getLogger(Controller.class);
	private static ArrayList<Instrument>instList ;

	/* For Button to Add Listeners*/
	public Controller() {
		super();
	}

	public Controller(ArrayList<Instrument> instList) {
		Controller.instList=instList;
	}

	public void actionPerformed(ActionEvent e) {
		String buttonText = e.getActionCommand();
		log.debug("Key Pressed : {} ",buttonText);
		ArrayList<Instrument> checkedInstrument = null;

		switch(buttonText){
		case "Start" :
			log.trace("Inside Start Listner");
			checkedInstrument=CheckboxPanel.getCheckBoxVal();
			MusicPlayer.playTrack(checkedInstrument);

			break;
		case "Stop" :
			log.trace("Inside Stop Listner");
			MusicPlayer.stopTrack();
			break;
		case "Tempo Up" :
			log.trace("Inside Tempo Up Listner");
			MusicPlayer.incrementTempo();

			break;
		case "Tempo Down" :
			log.trace("Inside Tempo Down Listner");
			MusicPlayer.decrementTempo();

			break;
		case "Save" :
			log.trace("Inside Save Listner");
			instList=CheckboxPanel.getCheckBoxVal();
			try {
				InstrumentFactory.saveInstBeats(instList);
			} catch (BeatBoxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Restore" :
			log.trace("Inside Restore Listner");
			try {
				instList = InstrumentFactory.restoreInstBeats();
			} catch (BeatBoxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CheckboxPanel.setCheckBoxVal(instList);
			
			break;
		}
	}
}
