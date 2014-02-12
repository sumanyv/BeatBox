package com.sound.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PlayerTest {
	
	private final static Logger log = LoggerFactory.getLogger(PlayerTest.class);
	
  @Test
  public void startPlayerTest(){
	//	p.setUpPlayer();
	  log.info("Sample Test");
  }
  @BeforeMethod
  public void beforeMethod() {
	//  p = new MusicPlayer();
  }

  @AfterMethod
  public void afterMethod() {
	//  p=null;
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
