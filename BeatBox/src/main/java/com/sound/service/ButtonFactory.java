package com.sound.service;

import java.util.ArrayList;

public class ButtonFactory {

	private static ArrayList<Button> buttonList;
	private static final String FILE_NAME ="buttons";

	static{
		Button.setListener(new Controller());
		Button.setInsert(0, 0, 5, 5);
		buttonList = XmlOperation.readFromXml(FILE_NAME);
	}

	public static ArrayList<Button> getButtons(){
		return buttonList;
	}
	
	public static void addButton(Button b){
		
		XmlOperation.appendToXml(b, FILE_NAME);
	}

}
