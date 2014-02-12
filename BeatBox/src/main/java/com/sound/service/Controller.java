package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.view.CheckboxPanel;

public class Controller implements ActionListener{

	private final Logger log = LoggerFactory.getLogger(Controller.class);


	/* For Button to Add Listeners*/
	public Controller() {
		super();
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
			checkedInstrument=CheckboxPanel.getCheckBoxVal();
			InstrumentFactory.saveInstruments(checkedInstrument);
			
			break;
		case "Restore" :
			log.trace("Inside Restore Listner");
			break;
		}
	}

	//	private void start() {
	/*Get User Selected CheckBox */
	//		instList= CheckboxPanel.getCheckBoxVal();
	//		for(int i=0;i<Instrument.TOTAL;++i){
	//			try {
	//				mPlayer.makeTracks(CheckBox[i]);
	//			} catch (InvalidMidiDataException e) {
	//				e.printStackTrace();
	//				log.error(e.getMessage());
	//			}
	//			log.trace("Music beat for device "+CheckBox[i]);
	//		}
	//		try {
	//			mPlayer.playTrack();
	//		} catch (InvalidMidiDataException e) {
	//			log.error(e.getMessage());
	//			e.printStackTrace();
	//		}
	//	}


}
