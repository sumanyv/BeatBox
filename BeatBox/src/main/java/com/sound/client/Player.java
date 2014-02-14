package com.sound.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sound.service.BeatBox;

public class Player {
	
	private static final Logger log = LoggerFactory.getLogger(Player.class);
	
	public static void main(String[] args){
		log.info("\n\t======================================\n"+
				 "\t========== BEAT BOX 1.0 ==============\n"+
				 "\t======================================\n");
		log.debug("Started Beat Box ");
		BeatBox bBox = new BeatBox();
		bBox.launch();	
	}
}
