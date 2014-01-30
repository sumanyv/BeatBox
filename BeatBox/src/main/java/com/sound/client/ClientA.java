package com.sound.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.BeatBoxGui;
import com.sound.service.Player;

public class ClientA {
	
	private static final Logger log = LoggerFactory.getLogger(ClientA.class);
	
	public static void main(String[] args){
		log.debug("Started ClientA ");
		BeatBoxGui gui = new BeatBoxGui();
		gui.setUpGui();
		
		Player p = new Player();
		p.setUpPlayer();
		
	}

}
