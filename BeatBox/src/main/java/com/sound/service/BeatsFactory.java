package com.sound.service;

import java.io.IOException;

public class BeatsFactory {
	
	private static SerialOperation so = new SerialOperation();
	private static final String FILE_NAME = "BEATS.SER";
	public static void saveBeats(Beats beat){
				try {
					so.saveObject(beat, FILE_NAME);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public static Beats getBeats(){
		Beats b = null;
			try {
				b=(Beats) so.getObject(FILE_NAME);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

}
