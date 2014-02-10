package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.view.MainFrame;

public class Controller implements ActionListener{
	
	private final Logger log = LoggerFactory.getLogger(Controller.class);
	private MusicPlayer mPlayer;
	private MainFrame frame;
	private ArrayList<Instrument> instList = new ArrayList<Instrument>();
	
	Controller(MusicPlayer mPlayer, MainFrame frame, ArrayList<Instrument> instList){
		this.mPlayer=mPlayer;
		this.frame=frame;
		this.instList=instList;
	}

	/* For Button to Add Listeners*/
	public Controller() {
		super();
	}

	public void actionPerformed(ActionEvent e) {
		log.debug("Key Pressed : {} ",e.getActionCommand());
		
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
	
//	private void stop(){
//		mPlayer.stopTrack();
//	}
//	
//	private void tempoUp(){
//		mPlayer.incrementTempo();
//	}
//	
//	private void tempoDown(){
//		mPlayer.decrementTempo();
//	}
//	
//
//	class StartButtonListner implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			log.trace("Start Button Clicked");
//			start();
//		}
//
//	}
//	class StopButtonListner implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			log.trace("Stop Button Clicked");
//			stop();
//		}
//	}
//
//	class UpTempoButtonListner implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			log.trace("Tempo Up Button Clicked");
//			tempoUp();
//		}
//	}
//
//	class DownTempoButtonListner implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			log.trace("Tempo Down Button Clicked");
//			tempoDown();
//		}
//	}

}
