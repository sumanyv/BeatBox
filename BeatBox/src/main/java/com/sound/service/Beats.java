package com.sound.service;

public class Beats {

	public static final int TOTOAL_BEATS =16;
	private boolean states[]= new boolean[TOTOAL_BEATS];
	
	public void setStates(int location,boolean value){
		this.states[location]=value;
	}
	public boolean getStates(int location){
		return this.states[location];
	}
	

}
