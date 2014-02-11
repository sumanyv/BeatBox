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

import com.sound.service.Instrument;

public class CheckboxPanel extends JPanel {

	private static final long serialVersionUID = 6723387682407232936L;
	private static Logger log = LoggerFactory.getLogger(CheckboxPanel.class);
	private static ArrayList<Instrument> instList;
	private static HashMap<String,JCheckBox[]> cBoxMap;

	/**
	 * Create the panel.
	 * @param instList 
	 */
	public CheckboxPanel(ArrayList<Instrument> instList) {
		CheckboxPanel.instList=instList;
		CheckboxPanel.cBoxMap= new HashMap<String,JCheckBox[]>();
		GridLayout grid = new GridLayout(instList.size(),Instrument.TOTAL_BEAT);
		grid.setVgap(1);grid.setHgap(2);
		String instName=null;
		JCheckBox[] singleInstArr = null;
		//TODO Check if the Check Box are correct
		setLayout(grid);
		setBorder(BorderFactory.createLineBorder(Color.black));
		log.debug("Number of Instruments to Add {} ",instList.size());
		
		for(Instrument inst : instList){
			
			instName= inst.getInstrName();
			singleInstArr = new JCheckBox[Instrument.TOTAL_BEAT];

			log.debug("Instrument {} set ",instName);
			for(int i=0;i<Instrument.TOTAL_BEAT;++i){

				JCheckBox c = new JCheckBox();
				if(inst.getInstBeatStates(i)==true){
					c.setSelected(true);
				}else {
					c.setSelected(false);
				}
				log.debug("Set Beat : {} , with Value : {} " ,i,inst.getInstBeatStates(i));
				singleInstArr[i]=c;
				add(singleInstArr[i]);
			}
			CheckboxPanel.cBoxMap.put(instName, singleInstArr);
		}
		log.trace("Total CheckBox Mapped : {} ",cBoxMap.size());
		log.trace("Finished Add CheckBox");

	}

	public static ArrayList<Instrument> getCheckBoxVal(){

		for(Instrument inst : instList){
			String instName = inst.getInstrName();
			JCheckBox[] singleInstArr = CheckboxPanel.cBoxMap.get(instName);
			log.debug("Getting Checkbox for Instrument : {} ",instName);
			for(int i=0;i<Instrument.TOTAL_BEAT;++i){
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

}
