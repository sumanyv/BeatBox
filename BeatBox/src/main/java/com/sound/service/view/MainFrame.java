package com.sound.service.view;

import java.awt.BorderLayout;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sound.service.BeatBoxException;
import com.sound.service.Instrument;

public class MainFrame extends JFrame {
	
	private JPanel mainPanel;

	private static final long serialVersionUID = 2148367511626434256L;
	private static final String TITLE = "Cyber Beat Box";
	private final URL LOGO = MainFrame.class.getClassLoader().getResource("BeatBoxIcon.jpg");
	private static final Logger log = LoggerFactory.getLogger(MainFrame.class);

	 public MainFrame(ArrayList<Instrument> instList) throws BeatBoxException{

		setTitle(TITLE);
		ImageIcon logoImg = new ImageIcon(LOGO);
		setIconImage(logoImg.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50,300,300);
		mainPanel = new JPanel(new BorderLayout(0,0));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		mainPanel.add(BorderLayout.EAST, new ButtonPanel());
		mainPanel.add(BorderLayout.WEST, new NamePanel(instList));
		mainPanel.add(BorderLayout.CENTER,new CheckboxPanel(instList));

		pack();
		setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",getHeight());

	}
}
