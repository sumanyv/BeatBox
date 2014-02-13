package com.sound.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstrumentFactory {

	private static final Logger log = LoggerFactory.getLogger(InstrumentFactory.class);
	private static ArrayList<Instrument> instrumentButton;
	private static final String FILE_NAME_XML="instruments";
	private static final String FILE_NAME_SERIAL ="BEATS.SER";
	private static final String resPath ="src/main/resources/";


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

		FileOutputStream fo =null;
		ObjectOutputStream oo=null ;
		try {
			fo = new FileOutputStream(resPath+FILE_NAME_SERIAL);
			oo = new ObjectOutputStream(fo);
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		for(Instrument inst : instList){
			try {
				oo.writeObject(inst);
				log.debug("Saving Instrument Obj : {} at Location {} ",inst.getInstrName(),instList.indexOf(inst));
			} catch (IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		try {
			oo.close();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static ArrayList<Instrument> restoreInstBeats(){
		ArrayList<Instrument> readList = new ArrayList<Instrument>();
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		try {
			fi = new FileInputStream(resPath+FILE_NAME_SERIAL);
			oi= new ObjectInputStream(fi);

		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		for(int i=0;i<TOTAL_INSTRUMENTS;++i){
			try {
				readList.add((Instrument) oi.readObject());
			} catch (ClassNotFoundException | IOException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

			log.debug("Restored Instrumetn Obj : {} at Location {} ",readList.get(i),i);
		}
		try {
			oi.close();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return readList;

	}
}
