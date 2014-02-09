package com.sound.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class InstrumentXml {

	private static final String FILE_NAME = "instruments.xml";
	private static final Logger log = LoggerFactory.getLogger(InstrumentXml.class);
	private static ArrayList<Instrument> instList = new ArrayList<Instrument>();
	
	static{
		readFromXml();
	}

	public static void writeToXml(ArrayList<Instrument> writeInst){

		instList.addAll(writeInst);
		File file = new File(FILE_NAME) ;
		FileOutputStream fo=null;

		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("Instrument", Instrument.class);
		xstream.alias("Instruments", List.class);
		
		log.debug("Added Instruments Size : {} ",instList.size() );
		String xml = xstream.toXML(instList);

		byte[] xmlInChar = xml.getBytes();
		// if file does not exists, then create it
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}try {
			fo = new FileOutputStream(file);
			fo.write(xmlInChar);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fo != null) {
					fo.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	@SuppressWarnings({ "unchecked", "resource" })
	public static ArrayList<Instrument> readFromXml(){
		
		File file = new File(FILE_NAME) ;
		BufferedReader br = null;
		String xml=null;

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		try {
			while((xml=br.readLine())!= null){
			    sb.append(xml.trim());
			}
		}catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("Instrument", Instrument.class);
		xstream.alias("Instruments", List.class);
		
		if(sb.length()!=0){
		instList = (ArrayList<Instrument>)xstream.fromXML(sb.toString());
		log.debug("Total Instruments Read From Xml : {} ",instList.size());
		}else{
			log.debug("Instruments List is Empty Size : {} ",sb);
		}
		
		return instList;
	}
}
