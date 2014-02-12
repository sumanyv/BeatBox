package com.sound.service;

import java.util.ArrayList;
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
	private static final float TEMPO_FACTOR_UP =1.03f;
	private static final float TEMPO_FACTOR_DOWN = 0.97f;
	private static Sequencer device ;
	private static Track track ;
	private static Sequence seq;

	final void setUpPlayer(){

		try {
			device = MidiSystem.getSequencer();
			device.open();
			log.debug("Player Opened");
			seq = new Sequence(Sequence.PPQ,4);
			track = seq.createTrack();
			log.debug("Track Created");
			device.setTempoInBPM(120);


		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("Player SetUp Succesful");
	}

	static void playTrack(ArrayList<Instrument> checkedInstrument) {
		try {
			makeTracks(checkedInstrument);
			device.setSequence(seq);
			device.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			device.start();
			log.info("Play Track Started");
		} catch (InvalidMidiDataException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

	}

	static void stopTrack(){
		device.stop();
		log.info("Track Stopped");
	}

	static void incrementTempo(){
		float tempFactor = device.getTempoFactor();
		device.setTempoFactor((float) (tempFactor * TEMPO_FACTOR_UP));
		log.info("Tempo Increased by : {}",TEMPO_FACTOR_UP);
	}

	static void decrementTempo(){
		float tempFactor = device.getTempoFactor();
		device.setTempoFactor((float)(tempFactor * TEMPO_FACTOR_DOWN));
		log.info("Tempo Decreased by : {}",TEMPO_FACTOR_DOWN);
	}

	static void makeTracks(ArrayList<Instrument> checkedInstrument) throws InvalidMidiDataException{

		log.trace("Building Track");
		for(Instrument inst : checkedInstrument){

			String instName = inst.getInstrName();
			int instId = inst.getInstrId();
			log.debug(" Instrument : {} , Instrument Id : {} ",instName,instId);

			for(int i=0;i<Beats.TOTOAL_BEATS;++i){
				if(inst.getInstBeatStates(i)==true){
					track.add(makeEvent(144, 9, instId, 100, i));
					track.add(makeEvent(128, 9, instId, 100, i+1));
					//TODO (Verify Agagin )Add Listener for Animation
					track.add(makeEvent(176, 1, 127, 9, 16));

				}
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

