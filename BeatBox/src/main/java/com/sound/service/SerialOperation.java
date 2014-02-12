package com.sound.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialOperation {
	
	public void saveObject(Object obj,String fileName) throws IOException{
		FileOutputStream fo = new FileOutputStream(fileName);
		ObjectOutputStream oo = new ObjectOutputStream(fo);
		oo.writeObject(obj);
		oo.close();
	}

	public Object getObject(String fileName) throws IOException, ClassNotFoundException{
		
		FileInputStream fi = new FileInputStream(fileName);
		ObjectInputStream oi = new ObjectInputStream(fi);
		Object obj = oi.readObject();
		oi.close();
		return obj;
	}
}
