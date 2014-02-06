package com.sound.service;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MainFrame  {
	public MainFrame() {
	}

	private static final Logger log = LoggerFactory.getLogger(MainFrame.class);

	private JFrame frame ;
	private JPanel mainPanel;
	private static ArrayList<JCheckBox> cBoxList = new ArrayList<JCheckBox>();;


	void setUpGui(){

		frame = new JFrame("BeatBox");
		frame.setTitle("Cyber Beat Box");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout bLayout = new BorderLayout();
		JPanel backPanel = new JPanel(bLayout);
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i=0 ;i<BeatBox.TOTAL_INSTRUMENTS;i++){
			nameBox.add(new Label(BeatBox.instrumentNames[i]));
		}

		backPanel.add(BorderLayout.EAST, new ButtonPanel());
		backPanel.add(BorderLayout.WEST, nameBox);

		frame.getContentPane().add(backPanel);

		GridLayout grid = new GridLayout(BeatBox.TOTAL_INSTRUMENTS,BeatBox.TOTAL_INSTRUMENTS);
		grid.setVgap(1);
		grid.setHgap(2);

		mainPanel = new JPanel(grid);
		backPanel.add(BorderLayout.CENTER,mainPanel);

		for(int i=0;i<256;i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			cBoxList.add(c);
			mainPanel.add(c);
		}
		log.trace("Check Box List Size : {}",cBoxList.size());

		frame.setBounds(50,50,300,300);
		frame.pack();
		frame.setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",frame.getHeight());

	}

	int[][] getCheckBoxVal(){

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

	//TODO Add Animation for Playing Music
	public void paintComponent(Graphics g){
		
	}
	

}
