package com.sound.service;

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

 class MusicPlayer  {
	
	private static final Logger log = LoggerFactory.getLogger(MusicPlayer.class);
	private static Sequencer mPlayer ;
	private static Track track ;
	private static Sequence seq;


	public final void setUpPlayer(){
		
		try {
			mPlayer = MidiSystem.getSequencer();
			mPlayer.open();
			log.debug("Player Opened");
			seq = new Sequence(Sequence.PPQ,4);
			track = seq.createTrack();
			log.debug("Track Created");
			mPlayer.setTempoInBPM(120);
			
			
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	
	public void playTrack() throws InvalidMidiDataException{
		mPlayer.setSequence(seq);
		mPlayer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		mPlayer.start();
	}
	
	public void stopTrack(){
		mPlayer.stop();
	}
	
	public void makeTracks(int[] list) throws InvalidMidiDataException{
		
		log.debug("Building Track");
		
		for(int i=0;i<BeatBox.TOTAL_INSTRUMENTS;i++){
			int key = list[i];
			if(key !=0){
					track.add(makeEvent(144, 9, key, 100, i));
					track.add(makeEvent(128, 9, key, 100, i+1));
					log.debug("Building track for Key {} ",key);
					track.add(makeEvent(176, 1, 127, 0, 16));// For Animation Listener
			}
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

}

