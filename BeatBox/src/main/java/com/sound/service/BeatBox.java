package com.sound.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;

public class BeatBox {

	/*Constants */
	public static final int TOTAL_INSTRUMENTS= 16;


	private MusicPlayer mPlayer;
	private UserInterface ui;
	private boolean PLAY_MUSIC =false ;

	public BeatBox(){
		/*Initialize Objects */
		mPlayer = new MusicPlayer();
		ui = new UserInterface();
	}

	public void launch(){

		/* Set Up Music Player and User Interface */
		mPlayer.setUpPlayer();
		ui.setUpGui();

		/*Start player loop*/
		try {
			start();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() throws InvalidMidiDataException {
		int[] CheckBox =null; 

		while(true){

			if(PLAY_MUSIC){

				/*Get User Selected CheckBox */
				CheckBox= ui.getCheckBoxVal();
				mPlayer.makeTracks(CheckBox);
				mPlayer.playTrack();
			}
		}
	}

	class StartButtonListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			PLAY_MUSIC =true;
			try {
				start();
			} catch (InvalidMidiDataException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	class StopButtonListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			PLAY_MUSIC =false;
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
