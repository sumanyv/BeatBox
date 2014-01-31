package com.sound.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.UserInteface;
import com.sound.service.MusicPlayer;

public class ClientA {
	
	private static final Logger log = LoggerFactory.getLogger(ClientA.class);
	
	public static void main(String[] args){
		log.debug("Started ClientA ");
		
		MusicPlayer p = new MusicPlayer();
		p.setUpPlayer();
	
		
		UserInteface gui = new UserInteface();
		gui.setUpGui();
		
	}

}
