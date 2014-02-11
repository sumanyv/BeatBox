package com.sound.service.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import com.sound.service.Button;
import com.sound.service.ButtonFactory;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

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
	private ArrayList<Button> buttonList;

	/**
	 * Create the panel.
	 */
	public ButtonPanel() {
		
		buttonList = ButtonFactory.getButtons();
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		for(Button b : buttonList){
			
			JButton button = new JButton(b.getbName());
			button.addActionListener(Button.getListener());
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			int[] insert = Button.getInsert();
			gbc_button.insets = new Insets(insert[0],insert[1],insert[2],insert[3]);
			gbc_button.gridx = b.getGridX();
			gbc_button.gridy = b.getGridY();
			add(button,gbc_button);
		}
		
	}

}
