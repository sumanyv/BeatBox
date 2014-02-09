package com.sound.service;

public class Instrument {

	public static final int TOTAL_INSTRUMENT=16;
	public static final int TOTAL_BEAT=16;
	private int instrId;
	private String instrName;
	private boolean[] instBeatStates;

	public Instrument(int instr_Id, String instr_name) {
		super();
		this.instrId = instr_Id;
		this.instrName = instr_name;
		this.instBeatStates = new boolean[TOTAL_BEAT];
	}
	public int getInstr_Id() {
		return instrId;
	}

	public String getInstr_name() {
		return instrName;
	}

	public void setInstBeats(int location,boolean value){
		instBeatStates[location]=value;
	}
	public boolean getInstBeats(int location){
		return instBeatStates[location];
	}

}
