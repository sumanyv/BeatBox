package com.sound.service;

import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class InstrumentXml {

	public void write(Instrument inst){
		
		XStream xstream = new XStream(new StaxDriver());

		xstream.alias("Instrument", Instrument.class);
		
		String xml = xstream.toXML(inst);
		
		System.out.println("Sample XML Printed "+xml);
		
	}
	
	public static ArrayList<Instrument> read(){
		return null;
		
		
	}
}
