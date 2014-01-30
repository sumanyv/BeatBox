package com.sound.service;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player implements ControllerEventListener {
	
	private static final Logger log = LoggerFactory.getLogger(Player.class);

	public final void startPlayer() throws MidiUnavailableException, InvalidMidiDataException{
		
		Sequencer mPlayer = MidiSystem.getSequencer();
		mPlayer.open();
		log.debug("Player Opened");
		Sequence seq = new Sequence(Sequence.PPQ,4);
		Track track = seq.createTrack();
		log.debug("Track Created");
		
		//Event to Listen
		int[] eventToListen = {127};
		mPlayer.addControllerEventListener(this, eventToListen);
		
		for(int i=5;i<61;i+=4){
			track.add(makeEvent(144, 1, i, 100, i));
			track.add(makeEvent(176, 1, 127, 0, i));
			track.add(makeEvent(128, 1, i, 100, i+2));
		}
		
		mPlayer.setSequence(seq);
		mPlayer.setTempoInBPM(220);
		mPlayer.start();
	}

	private static MidiEvent makeEvent(int comd,int chan ,int one ,int two ,int tick) throws InvalidMidiDataException{
		MidiEvent event = null;
		ShortMessage sMsg = new ShortMessage();
		sMsg.setMessage(comd, chan, one, two);
		event = new MidiEvent(sMsg,tick); 
		log.trace("Event Details : command {} : channel {} : data1 {} : data2 {} : tick {}",comd,chan,one,two,tick);
		return event;	
	}

	@Override
	public void controlChange(ShortMessage event) {
		
		
	}
	
	
	
}

