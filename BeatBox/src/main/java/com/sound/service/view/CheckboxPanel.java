package com.sound.service.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.Beats;
import com.sound.service.Instrument;

public class CheckboxPanel extends JPanel {

	private static final long serialVersionUID = 6723387682407232936L;
	private static Logger log = LoggerFactory.getLogger(CheckboxPanel.class);
	private static ArrayList<Instrument> instList;
	private static HashMap<String,JCheckBox[]> cBoxMap;

	public CheckboxPanel(ArrayList<Instrument> instList) {
		CheckboxPanel.instList=instList;
		CheckboxPanel.cBoxMap= new HashMap<String,JCheckBox[]>();
		GridLayout grid = new GridLayout(instList.size(),Beats.TOTOAL_BEATS);
		grid.setVgap(1);grid.setHgap(2);
		String instName=null;
		JCheckBox[] singleInstArr = null;
		setLayout(grid);
		setBorder(BorderFactory.createLineBorder(Color.black));
		log.debug("Number of Instruments to Add {} ",instList.size());

		for(Instrument inst : instList){

			instName= inst.getInstrName();
			singleInstArr = new JCheckBox[Beats.TOTOAL_BEATS];

			log.debug("Instrument {} set ",instName);
			for(int i=0;i<Beats.TOTOAL_BEATS;++i){
				JCheckBox c = new JCheckBox();
				c.setSelected(false);
				singleInstArr[i]=c;
				add(singleInstArr[i]);
			}
			CheckboxPanel.cBoxMap.put(instName, singleInstArr);
		}
		log.trace("Total CheckBox Mapped : {} ",cBoxMap.size());
		log.trace("Finished Add CheckBox");

	}
	public void removeCheckbox(){
		removeAll();
	}

	public static ArrayList<Instrument> getCheckBoxVal(){

		for(Instrument inst : instList){
			String instName = inst.getInstrName();
			JCheckBox[] singleInstArr = CheckboxPanel.cBoxMap.get(instName);
			log.debug("Getting Checkbox for Instrument : {} ",instName);
			for(int i=0;i<Beats.TOTOAL_BEATS;++i){
				JCheckBox jc = singleInstArr[i];

				if(jc.isSelected()==true){
					inst.setInstBeatStates(i, true);
					log.trace(" Instrument : {} Beat : {} Checked ",inst.getInstrName(),i);
				} else {
					inst.setInstBeatStates(i, false);
				}
			}
		}
		return instList ;
	}

	public static void setCheckBoxVal(ArrayList<Instrument> checkedInstrument){

		String instName=null;
		JCheckBox[] singleInstArr = null;
		for(Instrument inst : checkedInstrument){

			instName= inst.getInstrName();
			
			singleInstArr = cBoxMap.get(instName);
			log.debug("Instrument {} set ",instName);

			for(int i=0;i<Beats.TOTOAL_BEATS;++i){
				JCheckBox c = singleInstArr[i];
				if(inst.getInstBeatStates(i)==true){
					c.setSelected(true);
					log.trace(" Instrument : {} Beat : {} Checked ",inst.getInstrName(),i);
				}else{
					c.setSelected(false);
				}
				singleInstArr[i]=c;
			}
			CheckboxPanel.cBoxMap.put(instName, singleInstArr);
		}
		log.trace("Total CheckBox Mapped : {} ",cBoxMap.size());
		log.trace("Finished Add CheckBox");
	}
	
	public static void clearAllCheckboxVal(){
		String instName =null;
		JCheckBox[] singleInstArr = null;
		for(Instrument inst : instList){

			instName= inst.getInstrName();
			
			singleInstArr = cBoxMap.get(instName);
			log.debug("Instrument {} set ",instName);

			for(int i=0;i<Beats.TOTOAL_BEATS;++i){
				JCheckBox c = singleInstArr[i];
				c.setSelected(false);
				singleInstArr[i]=c;
			}
			CheckboxPanel.cBoxMap.put(instName, singleInstArr);
			log.debug("Cleared All Checkbox values");
		}
	}
}

