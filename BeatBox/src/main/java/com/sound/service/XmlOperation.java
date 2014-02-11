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

public class XmlOperation {

	private static final Logger log = LoggerFactory.getLogger(XmlOperation.class);
	private static ArrayList<?> currentList = null;

	/**
	 * 
	 * @param writeInst
	 * @param root Root Node of Xml Name ex : Instruments
	 */
	@SuppressWarnings("unchecked")
	public static <T> void writeToXml( T writeInst,String fileName){

		/* First Read the Data from xml */
		currentList=readFromXml(fileName+".xml");
		ArrayList <T>writeList = new ArrayList<T>();
		if(currentList!=null){
			writeList = (ArrayList<T>) currentList;
		}
		writeList.add(writeInst);
		
		log.debug("Argument Passed root Node : {} ",fileName);
		log.debug("Individual node Name : {} ",writeList.getClass().getName());
		File file = new File(fileName) ;
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
	public static <T> ArrayList<T> readFromXml(String fileName){
		
		File file = new File(fileName+".xml") ;
		BufferedReader br = null;
		String xml=null;
		currentList = new ArrayList<T>();

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
