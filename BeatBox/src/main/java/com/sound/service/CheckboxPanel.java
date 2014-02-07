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
	private static ArrayList<JCheckBox> cBoxList = new ArrayList<JCheckBox>();

	/**
	 * Create the panel.
	 */
	public CheckboxPanel() {
		GridLayout grid = new GridLayout(BeatBox.TOTAL_INSTRUMENTS,BeatBox.TOTAL_INSTRUMENTS);
		grid.setVgap(1);
		grid.setHgap(2);
		setLayout(grid);
		setBorder(BorderFactory.createLineBorder(Color.black));
		for(int i=0;i<256;i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			cBoxList.add(c);
			add(c);
		}

		log.trace("Check Box List Size : {}",cBoxList.size());
	}

	static int[][] getCheckBoxVal(){

		log.debug("Getting Checkbox value from screen");
		int[][] trackList =new int[BeatBox.TOTAL_INSTRUMENTS][BeatBox.TOTAL_INSTRUMENTS];
		for(int i=0;i<BeatBox.TOTAL_INSTRUMENTS;++i){
			int key = BeatBox.instruments[i];
			log.debug("Key Seleted : {}",key);
			for(int j=0;j<BeatBox.TOTAL_INSTRUMENTS;++j){
				JCheckBox jc = (JCheckBox) cBoxList.get(j+(BeatBox.TOTAL_INSTRUMENTS*i));

				if(jc.isSelected()){
					trackList[i][j]=key;
				} else {
					trackList[i][j]=0;
				}
			}
		}
		return trackList;
	}
}
