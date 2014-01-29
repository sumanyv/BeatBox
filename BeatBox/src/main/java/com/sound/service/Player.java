package com.sound.service;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Player {

	public final void startPlayer() throws MidiUnavailableException, InvalidMidiDataException{
		
		Sequencer p = MidiSystem.getSequencer();
		p.open();
		
		Sequence seq = new Sequence(Sequence.PPQ,4);
		Track track = seq.createTrack();
		
		for(int i=5;i<61;i+=4){
			
			track.add(makeEvent(144, 1, i, 100, i));
			track.add(makeEvent(128, 1, i, 100, i+2));
		}
		
		p.setSequence(seq);
		p.setTempoInBPM(220);
		p.start();
	}

	private static MidiEvent makeEvent(int comd,int chan ,int one ,int two ,int tick) throws InvalidMidiDataException{
		MidiEvent event = null;
		
		ShortMessage sMsg = new ShortMessage();
		sMsg.setMessage(comd, chan, one, two);
		
		event = new MidiEvent(sMsg,tick);
		
		return event;
		
	}
}
