package com.sound.service;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PlayerTest {
	
	private final static Logger log = LoggerFactory.getLogger(PlayerTest.class);
	private Player p;
	
  @Test
  public void startPlayerTest() {
	  try {
		p.startPlayer();
	} catch (MidiUnavailableException e) {
		log.error("Inside MidiUnavailableExceptoin" );
		e.printStackTrace();
	} catch (InvalidMidiDataException e) {
		log.error("Inside InvalidMidiDataException " );
		e.printStackTrace();
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	  p = new Player();
  }

  @AfterMethod
  public void afterMethod() {
	  p=null;
  }

  @BeforeTest
  public void beforeTest() {
	  log.info("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  log.info("After Test");
  }

}
