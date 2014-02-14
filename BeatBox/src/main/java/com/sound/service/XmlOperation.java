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

 class XmlOperation {

	private static final Logger log = LoggerFactory.getLogger(XmlOperation.class);
	private static final String resPath ="src/main/resources/";
	
	 static <T> void appendToXml(T append , String fileName) throws BeatBoxException{
		 ArrayList<T> currentList = new ArrayList<T>();
		 ArrayList<T> readList = readFromXml(fileName);
		 log.trace("Inside Append to Xml for File : {} ",fileName);
		 if(readList!=null){
			 currentList = readList;
			 log.debug("Appended the Exisiting Xml Of Size : {}",readList.size());
			 currentList.add(append);
		 }else{
			 currentList.add(append);
			 log.debug("File Is Empty fileName : {} ",fileName);
		 }
		 
		 writeToXml(currentList, fileName);
	}

	/**
	 * 
	 * @param writeInst
	 * @param fileName Root Node of Xml Name ex : instruments
	 * @throws BeatBoxException 
	 */
	 static <T> void writeToXml(ArrayList< T> writeList,String fileName) throws BeatBoxException{
		
		log.trace("Size of list : {}  to  Wirte to  Xml File : {} ",writeList.size(),fileName);
		log.debug("Argument Passed root Node : {} ",fileName);
		log.debug("Individual node Name : {} ",writeList.getClass().getName());
		File file = new File(resPath+fileName+".xml") ;
		FileOutputStream fo=null;

		XStream xstream = new XStream(new StaxDriver());
		xstream.alias(fileName, List.class);
		
		log.debug("Added {} Size : {} ",writeList.getClass().getSimpleName(),writeList.size() );
		String xml = xstream.toXML(writeList);

		byte[] xmlInChar = xml.getBytes();
		// if file does not exists, then create it
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				throw new BeatBoxException("Error Writing new Instruments");

			}
		}try {
			fo = new FileOutputStream(file);
			fo.write(xmlInChar);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BeatBoxException("Error Writing new Instruments");
		}finally {
			try {
				if (fo != null) {
					fo.close();
					throw new BeatBoxException("Error Writing new Instruments");
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new BeatBoxException("Error Writing new Instruments");
			}
		}
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public static <T> ArrayList<T> readFromXml(String fileName) throws BeatBoxException{
		
		File file = new File(resPath+fileName+".xml") ;
		BufferedReader br = null;
		String xml=null;
		ArrayList<T> currentList = new ArrayList<T>();

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			log.error(e1.getMessage());
			e1.printStackTrace();
			throw new BeatBoxException("Error Reading Instruments");
		}
		StringBuilder sb = new StringBuilder();
		try {
			while((xml=br.readLine())!= null){
			    sb.append(xml.trim());
			}
		}catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new BeatBoxException("Error Reading Instruments");
		}
		
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias(fileName, List.class);
		
		if(sb.length()!=0){
		currentList = (ArrayList<T>)xstream.fromXML(sb.toString());
		log.debug("Total {} Read From Xml : {} ",currentList.getClass().getSimpleName(),currentList.size());
		}else{
			log.debug(" {} Xml is Empty ",fileName);
		}
		return (ArrayList<T>) currentList;
	}
}
