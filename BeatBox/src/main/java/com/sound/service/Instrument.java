package com.sound.service;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Instrument {

	private int instrId;
	private String instrName;
	@XStreamOmitField private Beats beats ;

	public Instrument(int instrId, String instrName) {
		super();
		this.instrId = instrId;
		this.instrName = instrName;
		this.beats = new Beats();
	}
	public int getInstrId() {
		return instrId;
	}

	public String getInstrName() {
		return instrName;
	}

	public void setInstBeatStates(int location,boolean value){
		beats.setStates(location, value);
	}
	public boolean getInstBeatStates(int location){
		return beats.getStates(location);
	}
	public void setBeats(Beats b){
		this.beats=b;
	}
	public Beats getBeats(){
		return this.beats;
	}

}
