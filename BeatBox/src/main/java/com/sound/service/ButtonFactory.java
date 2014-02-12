package com.sound.service;

import java.util.ArrayList;

public class ButtonFactory {

	private static ArrayList<Button> buttonList;

	static{
		Button.setListener(new Controller());
		Button.setInsert(0, 0, 5, 5);
		buttonList = XmlOperation.readFromXml("buttons");
	}

	public static ArrayList<Button> getButtons(){
		return buttonList;
	}

}
