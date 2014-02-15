package com.sound.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

class XmlOperation {

	private static final Logger log = LoggerFactory.getLogger(XmlOperation.class);

	@SuppressWarnings({ "unchecked"})
	public static <T> ArrayList<T> readFromXml(String fileName) throws BeatBoxException{

		InputStream is =XmlOperation.class.getClassLoader().getResourceAsStream(fileName+".xml");
		BufferedReader br = null;
		String temp=null;
		ArrayList<T> currentList = new ArrayList<T>();
		StringBuilder sb = new StringBuilder();

		try {
			br = new BufferedReader(new InputStreamReader(is));
			while((temp=br.readLine())!= null){
				sb.append(temp.trim());
			}
			XStream xstream = new XStream(new StaxDriver());
			xstream.alias(fileName, List.class);
			if(sb.length()!=0){
				currentList = (ArrayList<T>)xstream.fromXML(sb.toString());
				log.debug("Total {} Read From Xml : {} ",currentList.getClass().getSimpleName(),currentList.size());
			}else{
				log.debug(" {} Xml is Empty ",fileName);
			}
		} catch (IOException e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new BeatBoxException("Error Reading Instruments",e1);
		}
		return (ArrayList<T>) currentList;
	}
}
