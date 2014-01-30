package com.sound.service;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
	
	static final Logger log = LoggerFactory.getLogger(Player.class);

	public final void startPlayer() throws MidiUnavailableException, InvalidMidiDataException{
		
		Sequencer p = MidiSystem.getSequencer();
		p.open();
		log.debug("Player Started");
		Sequence seq = new Sequence(Sequence.PPQ,4);
		Track track = seq.createTrack();
		
		//Event to Listen
		int[] eventToListen = {127};
		p.addControllerEventListener(new PlayListner(), eventToListen);
		
		for(int i=5;i<61;i+=4){
			track.add(makeEvent(144, 1, i, 100, i));
			track.add(makeEvent(176, 1, 127, 0, i));
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
		log.trace("Event Details : command {} : channel {} : data1 {} : data2 {} : tick {}",comd,chan,one,two,tick);
		return event;
		
	}
}

class PlayListner implements ControllerEventListener{

	@Override
	public void controlChange(ShortMessage event) {
		
		Player.log.info("Inside Listner Data 1 : {} Data 2 : {} ",event.getData1(),event.getData2());
		
	}
	
}
