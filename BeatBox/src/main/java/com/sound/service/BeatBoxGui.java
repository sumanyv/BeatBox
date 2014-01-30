package com.sound.service;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeatBoxGui extends JPanel {

	private static final int INSTRUMENT_SIZE =16;
	private static final long serialVersionUID = 1L;
	private final int FRAME_X=500;
	private final int FRAME_Y=500;
	static final Logger log = LoggerFactory.getLogger(BeatBoxGui.class);

	private final String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
											"Crash Cymbai","Hand Clap","High Tom","Hi Bong","Maracas","Whistle",
											"Low Conga","Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi conga"};
	int[] instruments ={35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

	JFrame theFrame ;
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	

	public void setUpGui(){

		theFrame = new JFrame("BeatBox");
		theFrame.setTitle("Cyber Beat Box");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout bLayout = new BorderLayout();
		JPanel backPanel = new JPanel(bLayout);
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new StartButtonListner());
		buttonBox.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new StopButtonListner());
		buttonBox.add(stopButton);
		
		JButton upTempoButton = new JButton("Tempo Up");
		upTempoButton.addActionListener(new UpTempoButtonListner());
		buttonBox.add(upTempoButton);
		
		JButton downTempoButton = new JButton("Tempo Down");
		downTempoButton.addActionListener(new DownTempoButtonListner());
		buttonBox.add(downTempoButton);
		
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i=0 ;i<INSTRUMENT_SIZE;i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		backPanel.add(BorderLayout.EAST, buttonBox);
		backPanel.add(BorderLayout.WEST, nameBox);
		
		theFrame.getContentPane().add(backPanel);
		
		GridLayout grid = new GridLayout(INSTRUMENT_SIZE,INSTRUMENT_SIZE);
		grid.setVgap(1);
		grid.setHgap(2);
		
		mainPanel = new JPanel(grid);
		backPanel.add(BorderLayout.CENTER,mainPanel);
		
		for(int i=0;i<256;i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",theFrame.getHeight());

	}

}

class StartButtonListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class StopButtonListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class UpTempoButtonListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class DownTempoButtonListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

