package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.view.CheckboxPanel;
import com.sound.service.view.MainFrame;

public class BeatBox {

	/*Constants */
	private final Logger log = LoggerFactory.getLogger(BeatBox.class);
	private MusicPlayer mPlayer;
	private MainFrame gui;
	private static ArrayList<Instrument> instList = new ArrayList<Instrument>();
	
	static{
		
		instList = InstrumentXml.readFromXml();
	}
	
	public BeatBox(){
		/*Initialize Objects */
		mPlayer = new MusicPlayer(instList);
		gui = new MainFrame(instList);
		
	}
	/**
	 * Set Up the Music Player and the User Inteface
	 */
	public void launch(){

		/* Set Up Music Player and User Interface */
		mPlayer.setUpPlayer();
		//TODO Check ui object is need
	}

	private void start() {

		/*Get User Selected CheckBox */
		instList= CheckboxPanel.getCheckBoxVal();
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
	}
	
	private void stop(){
		mPlayer.stopTrack();
	}
	
	private void tempoUp(){
		mPlayer.incrementTempo();
	}
	
	private void tempoDown(){
		mPlayer.decrementTempo();
	}
	

	class StartButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			log.trace("Start Button Clicked");
			start();
		}

	}
	class StopButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			log.trace("Stop Button Clicked");
			stop();
		}
	}

	class UpTempoButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			log.trace("Tempo Up Button Clicked");
			tempoUp();
		}
	}

	class DownTempoButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			log.trace("Tempo Down Button Clicked");
			tempoDown();
		}
	}
}
