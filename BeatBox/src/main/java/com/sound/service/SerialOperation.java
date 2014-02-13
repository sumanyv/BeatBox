package com.sound.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 class SerialOperation {
	private static final Logger log = LoggerFactory.getLogger(SerialOperation.class);
	
	public static void saveObject(Object obj,String fileName) throws IOException{
		log.trace("Saving Object : {} into file : {}",obj.getClass().getSimpleName(),fileName);
		FileOutputStream fo = new FileOutputStream(fileName);
		ObjectOutputStream oo = new ObjectOutputStream(fo);
		oo.writeObject(obj);
		oo.close();
	}

	public static Object getObject(String fileName) throws IOException, ClassNotFoundException{
		log.trace("Getting Object from file : {}",fileName);
		FileInputStream fi = new FileInputStream(fileName);
		ObjectInputStream oi = new ObjectInputStream(fi);
		Object obj = oi.readObject();
		oi.close();
		return obj;
	}
}
