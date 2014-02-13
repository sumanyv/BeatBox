package com.sound.service;

import java.io.IOException;
import java.util.ArrayList;

public class InstrumentFactory {

	private static ArrayList<Instrument> instrumentButton;
	private static final String FILE_NAME_XML="instruments";
	private static final String FILE_NAME_SERIAL ="BEATS.SER";
	
	public static int TOTAL_INSTRUMENTS;
	
	static{
		instrumentButton= XmlOperation.readFromXml(FILE_NAME_XML);
		TOTAL_INSTRUMENTS=instrumentButton.size();
	}
	
	public static ArrayList<Instrument> getInstruments(){
		for(Instrument inst : instrumentButton){
			inst.setBeats(new Beats());
		}
		return instrumentButton;
	}
	
	public static void addInstrument(Instrument inst){
		XmlOperation.appendToXml(inst, FILE_NAME_XML);
	}
	

	public static void saveInstBeats(ArrayList<Instrument> instList){
		
		for(Instrument inst : instList){
			try {
				SerialOperation.saveObject(inst, FILE_NAME_SERIAL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static ArrayList<Instrument> restoreInstBeats(){
		ArrayList<Instrument> instList = new ArrayList<Instrument>();
		for(int i=0;i< TOTAL_INSTRUMENTS;++i){
			try {
				instList.add((Instrument) SerialOperation.getObject(FILE_NAME_SERIAL));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instList;
		
	}
}
