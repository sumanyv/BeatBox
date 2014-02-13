package com.sound.service;

import java.io.Serializable;

public class Beats implements Serializable{


	private static final long serialVersionUID = -2564169395770493591L;
	public static final int TOTOAL_BEATS =16;
	private boolean states[]= new boolean[TOTOAL_BEATS];
	
	public void setStates(int location,boolean value){
		this.states[location]=value;
	}
	public boolean getStates(int location){
		return this.states[location];
	}
	

}
