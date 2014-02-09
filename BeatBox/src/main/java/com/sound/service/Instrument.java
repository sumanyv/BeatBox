package com.sound.service;

public class Instrument {

	public static final int TOTAL_INSTRUMENTS=16;
	private int instr_Id;
	private String instr_name;
	private boolean[] inst_beats;

	public Instrument(int instr_Id, String instr_name) {
		super();
		this.instr_Id = instr_Id;
		this.instr_name = instr_name;
		this.inst_beats = new boolean[TOTAL_INSTRUMENTS];
	}
	public int getInstr_Id() {
		return instr_Id;
	}

	public String getInstr_name() {
		return instr_name;
	}

	public boolean[] getInst_beats() {
		return inst_beats;
	}

	public void setInstBeats(int location,boolean value){
		inst_beats[location]=value;
	}
	public boolean getInstBeats(int location){
		return inst_beats[location];
	}

}
