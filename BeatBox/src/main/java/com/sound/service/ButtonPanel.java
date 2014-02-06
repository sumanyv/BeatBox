package com.sound.service;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/** 
 * This is our Side Button Panel
 * @author adityas
 *
 */
public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5530997149568660460L;
	/* Beat Box obj for listners TODO Not Sure abt implementation*/
	BeatBox bBox = new BeatBox();


	/**
	 * Create the panel.
	 */
	public ButtonPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(bBox.new StartButtonListner());
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnTempoUp = new JButton("Tempo Up");
		btnTempoUp.addActionListener(bBox.new UpTempoButtonListner());
		GridBagConstraints gbc_btnTempoUp = new GridBagConstraints();
		gbc_btnTempoUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTempoUp.insets = new Insets(0, 0, 5, 5);
		gbc_btnTempoUp.gridx = 3;
		gbc_btnTempoUp.gridy = 1;
		add(btnTempoUp, gbc_btnTempoUp);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(bBox.new StopButtonListner());
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 1;
		gbc_btnStop.gridy = 3;
		add(btnStop, gbc_btnStop);
		
		JButton btnTempoDown = new JButton("Tempo Down");
		btnTempoDown.addActionListener(bBox.new DownTempoButtonListner());
		GridBagConstraints gbc_btnTempoDown = new GridBagConstraints();
		gbc_btnTempoDown.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTempoDown.insets = new Insets(0, 0, 5, 5);
		gbc_btnTempoDown.gridx = 3;
		gbc_btnTempoDown.gridy = 3;
		add(btnTempoDown, gbc_btnTempoDown);
		
		JButton btnSave = new JButton("Save");// TODO Add Listeners
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 5;
		add(btnSave, gbc_btnSave);
		
		JButton btnRestore = new JButton("Restore"); //TODO Add Listeners
		GridBagConstraints gbc_btnRestore = new GridBagConstraints();
		gbc_btnRestore.insets = new Insets(0, 0, 0, 5);
		gbc_btnRestore.fill = GridBagConstraints.BOTH;
		gbc_btnRestore.gridx = 3;
		gbc_btnRestore.gridy = 5;
		add(btnRestore, gbc_btnRestore);

	}

}
