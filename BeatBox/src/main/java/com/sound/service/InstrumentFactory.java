package com.sound.service;

import java.util.ArrayList;

public class InstrumentFactory {

	private static ArrayList<Instrument> instrumentButton;
	private static final String fileName="instruments";
	public static int TOTAL_INSTRUMENTS;
	
	static{
		instrumentButton= XmlOperation.readFromXml(fileName);
		TOTAL_INSTRUMENTS=instrumentButton.size();
	}
	
	public static ArrayList<Instrument> getInstruments(){
		for(Instrument inst : instrumentButton){
			inst.setBeats(new Beats());
		}
		return instrumentButton;
	}
	
	public static void saveInstruments(ArrayList<Instrument> checkedList){
		
		XmlOperation.writeToXml(checkedList, fileName);
	}
	
	public static void restoreInstruments(){
		
	}
}
