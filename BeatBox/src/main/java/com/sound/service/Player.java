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

public class Player implements ControllerEventListener {
	
	private static final Logger log = LoggerFactory.getLogger(Player.class);
	Sequencer mPlayer ;
	Track track ;
	Sequence seq;

	public Sequence getSeq() {
		return seq;
	}

	public void setSeq(Sequence seq) {
		this.seq = seq;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public final void setUpPlayer(){
		
		try {
			mPlayer = MidiSystem.getSequencer();
			mPlayer.open();
			log.debug("Player Opened");
			Sequence seq = new Sequence(Sequence.PPQ,4);
			track = seq.createTrack();
			log.debug("Track Created");
			mPlayer.setTempoInBPM(120);
			
			
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	
	public void makeTracks() throws InvalidMidiDataException{
		
		log.debug("Building Track");
		BeatBoxGui gui = new BeatBoxGui();
		int[] list =gui.getCheckBoxVal();
		
		for(int i=0;i<gui.INSTRUMENT_SIZE;i++){
			int key = list[i];
			if(key !=0){
					track.add(makeEvent(144, 9, key, 100, i));
					track.add(makeEvent(128, 9, key, 100, i+1));
					log.debug("Building track for Key {} ",key);
			}
			track.add(makeEvent(176, 1, 127, 0, 16));
		}
		
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

