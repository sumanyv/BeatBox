package com.sound.service;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MainFrame extends JFrame {
	public MainFrame() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 2148367511626434256L;
	private static final Logger log = LoggerFactory.getLogger(MainFrame.class);

	void setUpGui(){

		setTitle("Cyber Beat Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(BorderLayout.CENTER,new CheckboxPanel());
		getContentPane().add(BorderLayout.EAST, new ButtonPanel());
		getContentPane().add(BorderLayout.WEST, new NamePanel());


		setBounds(50,50,300,300);
		pack();
		setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",getHeight());

	}

	//TODO Add Animation for Playing Music
	public void paintComponent(Graphics g){

	}
}
