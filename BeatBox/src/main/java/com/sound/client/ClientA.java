package com.sound.client;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import com.sound.service.Player;

public class ClientA {
	
	public static void main(String[] args){
		
		Player player = new Player();
		try {
			player.startPlayer();
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			System.out.println(e.getMessage());
		}finally{
		}
	}

}
