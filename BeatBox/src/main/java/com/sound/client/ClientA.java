package com.sound.client;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.Player;

public class ClientA {
	
	private static final Logger log = LoggerFactory.getLogger(ClientA.class);
	
	public static void main(String[] args){
		log.debug("Started ClientA ");
		Player player = new Player();
		try {
			player.startPlayer();
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}finally{
		}
	}

}
