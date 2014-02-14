package com.sound.service;

import java.util.ArrayList;

public class ButtonFactory {

	private static ArrayList<Button> buttonList;
	private static final String FILE_NAME ="buttons";

	static{
		Button.setListener(new Controller());
		Button.setInsert(0, 0, 5, 5);
	}

	public static ArrayList<Button> getButtons() throws BeatBoxException{
		buttonList = XmlOperation.readFromXml(FILE_NAME);
		return buttonList;
	}
	
	/*public static void addButton(Button b) throws BeatBoxException{
		
		XmlOperation.appendToXml(b, FILE_NAME);
	}
*/
}
