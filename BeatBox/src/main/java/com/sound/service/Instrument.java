package com.sound.service;

public class Instrument {

	public static final int TOTAL_INSTRUMENT=16;
	public static final int TOTAL_BEAT=16;
	private int instrId;
	private String instrName;
	private boolean[] instBeatStates;

	public Instrument(int instrId, String instrName) {
		super();
		this.instrId = instrId;
		this.instrName = instrName;
		this.instBeatStates = new boolean[TOTAL_BEAT];
	}
	public int getInstrId() {
		return instrId;
	}

	public String getInstrName() {
		return instrName;
	}

	public void setInstBeatStates(int location,boolean value){
		instBeatStates[location]=value;
	}
	public boolean getInstBeatStates(int location){
		return instBeatStates[location];
	}

}
