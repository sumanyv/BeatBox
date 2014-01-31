package com.sound.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sound.service.BeatBox;

public class ClientA {
	
	private static final Logger log = LoggerFactory.getLogger(ClientA.class);
	
	public static void main(String[] args){
		log.debug("Started ClientA ");
		
		BeatBox bBox = new BeatBox();
		bBox.launch();
		
	}

}
