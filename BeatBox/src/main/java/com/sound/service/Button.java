package com.sound.service;

import java.awt.event.ActionListener;

public class Button {

	private static int[] insert = new int[4];
	private static ActionListener listener;
	private String bName;
	private String bFill;
	private int gridX;
	private int gridY;

	public Button(String bName, String bFill, int gridX, int gridY) {
		super();
		this.bName = bName;
		this.bFill = bFill;
		this.gridX = gridX;
		this.gridY = gridY;
	}

	public static int[] getInsert() {
		return insert;
	}
	public static void setInsert(int top,int left , int bottom , int right) {
		Button.insert[0] = top;
		Button.insert[1] =left;
		Button.insert[2] = bottom;
		Button.insert[3] = right;
	}
	public static ActionListener getListener() {
		return listener;
	}
	public static void setListener(ActionListener listener) {
		Button.listener = listener;
	}

	public String getbFill() {
		return bFill;
	}

	public int getGridX() {
		return gridX;
	}
	public int getGridY() {
		return gridY;
	}
	public String getbName() {
		return bName;
	}


}
