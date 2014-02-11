package com.sound.service;

import java.util.ArrayList;

public class InstrumentFactory {

	private static ArrayList<Instrument> instrumentButton;
	private static final String fileName="instruments";
	
	static{
		instrumentButton= XmlOperation.readFromXml(fileName);
	}
	
	public static ArrayList<Instrument> getInstruments(){
		return instrumentButton;
	}
	
	public static void saveInstruments(ArrayList<Instrument> checkedList){
		
		XmlOperation.writeToXml(checkedList, fileName);
	}
	
	public static void restoreInstruments(){
		
	}
}
