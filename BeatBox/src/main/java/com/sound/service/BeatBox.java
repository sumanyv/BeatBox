package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeatBox {

	/*Constants */
	public static final int TOTAL_INSTRUMENTS= 16;
	public static final int[] instruments =			{35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	private final Logger log = LoggerFactory.getLogger(BeatBox.class);

	/* HAS-A obj of Both Music Player and User Interface */
	private MusicPlayer mPlayer;

	public BeatBox(){
		/*Initialize Objects */
		mPlayer = new MusicPlayer();
		
	}

	/**
	 * Set Up the Music Player and the User Inteface
	 */
	public void launch(){

		/* Set Up Music Player and User Interface */
		mPlayer.setUpPlayer();
		MainFrame ui = new MainFrame();
	}

	private void start() {

		int[][] CheckBox =new int[TOTAL_INSTRUMENTS][TOTAL_INSTRUMENTS]; 
		/*Get User Selected CheckBox */
		CheckBox= CheckboxPanel.getCheckBoxVal();
		for(int i=0;i<TOTAL_INSTRUMENTS;++i){
			try {
				mPlayer.makeTracks(CheckBox[i]);
			} catch (InvalidMidiDataException e) {
				e.printStackTrace();
				log.error(e.getMessage());
			}
			log.trace("Music beat for device "+CheckBox[i]);
		}
		try {
			mPlayer.playTrack();
		} catch (InvalidMidiDataException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
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
