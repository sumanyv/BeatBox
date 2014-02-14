package com.sound.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sound.service.view.MainFrame;

public class BeatBox {

	private final Logger log = LoggerFactory.getLogger(BeatBox.class);
	private MusicPlayer mPlayer;
	private MainFrame frame;
	private ArrayList<Instrument> instList = new ArrayList<Instrument>();
	private Controller control;

	/**
	 * Set Up the Music Player and the User Inteface and Controller
	 */
	public void launch(){
		try {
			this.instList = InstrumentFactory.getInstruments();
			log.trace("Initialized Instruments From Xml File instList := {}",instList);
			this.mPlayer = new MusicPlayer();
			log.trace("Music Player Created mPlayer := {}",mPlayer);
			this.mPlayer.setUpPlayer();
			log.trace("Music Player Setup Finished");
			this.frame = new MainFrame(instList);
			log.trace("Main Frame for View Set Up Finished  frame= : {}",frame);
			this.control= new Controller(instList);
			log.trace("Controller SetUp Finished  control =: {} ",control);
		} catch (BeatBoxException e) {
			JOptionPane.showMessageDialog(frame,e.getMessage(),"Error Launching",JOptionPane.ERROR_MESSAGE);
			log.error("Exception !! {}",e);
		}

	}
}
