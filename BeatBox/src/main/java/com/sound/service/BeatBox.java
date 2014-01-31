package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeatBox {

	/*Constants */
	public static final int TOTAL_INSTRUMENTS= 16;
	private final Logger log = LoggerFactory.getLogger(BeatBox.class);

	private MusicPlayer mPlayer;
	private UserInterface ui;

	public BeatBox(){
		/*Initialize Objects */
		mPlayer = new MusicPlayer();
		ui = new UserInterface();
	}

	public void launch(){

		/* Set Up Music Player and User Interface */
		mPlayer.setUpPlayer();
		ui.setUpGui();
	}

	private void start() {

		int[][] CheckBox =new int[TOTAL_INSTRUMENTS][TOTAL_INSTRUMENTS]; 
		/*Get User Selected CheckBox */
		CheckBox= ui.getCheckBoxVal();
		for(int i=0;i<TOTAL_INSTRUMENTS;++i){
			try {
				mPlayer.makeTracks(CheckBox[i]);
			} catch (InvalidMidiDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.trace("Music beat for device "+CheckBox[i]);
		}
		try {
			mPlayer.playTrack();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void stop(){
		mPlayer.stopTrack();
	}

	class StartButtonListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			start();
		}

	}
	class StopButtonListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			stop();
		}
	}

	class UpTempoButtonListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}

	class DownTempoButtonListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
}
