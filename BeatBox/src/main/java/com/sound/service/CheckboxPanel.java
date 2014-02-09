package com.sound.service;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckboxPanel extends JPanel {

	private static final long serialVersionUID = 6723387682407232936L;
	private static Logger log = LoggerFactory.getLogger(CheckboxPanel.class);
	private static ArrayList<Instrument> instList;
	private static ArrayList<JCheckBox> cBoxList;

	/**
	 * Create the panel.
	 * @param instList 
	 */
	public CheckboxPanel(ArrayList<Instrument> instList) {
		CheckboxPanel.instList=instList;
		CheckboxPanel.cBoxList= new ArrayList<JCheckBox>();
		GridLayout grid = new GridLayout(Instrument.TOTAL_INSTRUMENT,Instrument.TOTAL_BEAT);
		grid.setVgap(1);grid.setHgap(2);
		setLayout(grid);
		setBorder(BorderFactory.createLineBorder(Color.black));
		log.debug("Number of Instruments to Add {} ",instList.size());
		for(Instrument inst : instList){
			log.debug("Instrument {} set ",inst.getInstrName());
			for(int i=0;i<Instrument.TOTAL_BEAT;++i){
				JCheckBox c = new JCheckBox();
				if(inst.getInstBeatStates(i)==true){
					c.setSelected(true);
				}else {
					c.setSelected(false);
				}
				cBoxList.add(c);
				log.debug("Set Beat : {} , with Value : {} " ,i,inst.getInstBeatStates(i));
				add(c);
			}
		}
		log.trace("Finished Add CheckBox");

	}

	static ArrayList<Instrument> getCheckBoxVal(){

		for(Instrument inst : instList){
			log.debug("Getting Checkbox for Instrument : {} ",inst.getInstrName());
			for(int i=0;i<Instrument.TOTAL_BEAT;++i){
				JCheckBox jc = (JCheckBox) cBoxList.get(Instrument.TOTAL_BEAT);

				if(jc.isSelected()==true){
					inst.setInstBeatStates(i, true);
				} else {
					inst.setInstBeatStates(i, false);
				}
			}
		}
		return instList ;
	}

}
