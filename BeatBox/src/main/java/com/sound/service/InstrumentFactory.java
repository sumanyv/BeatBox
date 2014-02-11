package com.sound.service;

import java.util.ArrayList;

public class InstrumentFactory {

	private static ArrayList<Instrument> instrumentButton;
	
	static{
		instrumentButton= XmlOperation.readFromXml("instruments");
	}
	
	public static ArrayList<Instrument> getInstruments(){
		return instrumentButton;
	}
}
