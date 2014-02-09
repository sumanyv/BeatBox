package com.sound.service;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MainFrame extends JFrame {
	
	private JPanel mainPanel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2148367511626434256L;
	private static final String TITLE = "Cyber Beat Box";
	private static final Logger log = LoggerFactory.getLogger(MainFrame.class);

	 MainFrame(ArrayList<Instrument> instList){

		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50,300,300);
		mainPanel = new JPanel(new BorderLayout(0,0));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		mainPanel.add(BorderLayout.CENTER,new CheckboxPanel(instList));
		mainPanel.add(BorderLayout.EAST, new ButtonPanel());
		mainPanel.add(BorderLayout.WEST, new NamePanel(instList));

		pack();
		setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",getHeight());

	}

	//TODO Add Animation for Playing Music
	public void paintComponent(Graphics g){

	}
}
