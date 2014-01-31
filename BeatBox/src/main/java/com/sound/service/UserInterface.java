package com.sound.service;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
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

 class UserInterface extends JPanel {

	private static final long serialVersionUID = 1L;
	static final Logger log = LoggerFactory.getLogger(UserInterface.class);

	private final String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
			"Crash Cymbai","Hand Clap","High Tom","Hi Bong","Maracas","Whistle",
			"Low Conga","Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi conga"};
	int[] instruments ={35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

	JFrame theFrame ;
	JPanel mainPanel;
	private static ArrayList<JCheckBox> cBoxList = new ArrayList<JCheckBox>();;

	MusicPlayer mPlayer;


	public void setUpGui(){

		theFrame = new JFrame("BeatBox");
		theFrame.setTitle("Cyber Beat Box");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout bLayout = new BorderLayout();
		JPanel backPanel = new JPanel(bLayout);
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		/* Beat Box obj for listners TODO Not Sure abt implementation*/
		BeatBox bBox = new BeatBox();
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(bBox.new StartButtonListner());
		buttonBox.add(startButton);

		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(bBox.new StopButtonListner());
		buttonBox.add(stopButton);

		JButton upTempoButton = new JButton("Tempo Up");
		upTempoButton.addActionListener(bBox.new UpTempoButtonListner());
		buttonBox.add(upTempoButton);

		JButton downTempoButton = new JButton("Tempo Down");
		downTempoButton.addActionListener(bBox.new DownTempoButtonListner());
		buttonBox.add(downTempoButton);


		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i=0 ;i<BeatBox.TOTAL_INSTRUMENTS;i++){
			nameBox.add(new Label(instrumentNames[i]));
		}

		backPanel.add(BorderLayout.EAST, buttonBox);
		backPanel.add(BorderLayout.WEST, nameBox);

		theFrame.getContentPane().add(backPanel);

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

		log.debug("Check Box List Size : {}",cBoxList.size());

		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",theFrame.getHeight());

	}

	public int[][] getCheckBoxVal(){

		log.debug("Getting Checkbox value from screen");
		int[][] trackList =new int[BeatBox.TOTAL_INSTRUMENTS][BeatBox.TOTAL_INSTRUMENTS];
		for(int i=0;i<BeatBox.TOTAL_INSTRUMENTS;++i){

			int key = instruments[i];

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


}