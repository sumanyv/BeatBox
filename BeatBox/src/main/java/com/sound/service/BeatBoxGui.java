package com.sound.service;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
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

	public final int INSTRUMENT_SIZE =16;
	private static final long serialVersionUID = 1L;
	static final Logger log = LoggerFactory.getLogger(BeatBoxGui.class);

	private final String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
			"Crash Cymbai","Hand Clap","High Tom","Hi Bong","Maracas","Whistle",
			"Low Conga","Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi conga"};
	int[] instruments ={35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

	JFrame theFrame ;
	JPanel mainPanel;
	private ArrayList<JCheckBox> cBoxList;

	MusicPlayer mPlayer;


	public void setUpGui(){

		theFrame = new JFrame("BeatBox");
		theFrame.setTitle("Cyber Beat Box");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout bLayout = new BorderLayout();
		JPanel backPanel = new JPanel(bLayout);
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		cBoxList = new ArrayList<JCheckBox>();
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
			cBoxList.add(c);
			mainPanel.add(c);
		}

		log.debug("Check Box List Size : {}",cBoxList.size());

		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
		log.info("Beat Box Gui Set Up complete size : {}",theFrame.getHeight());

	}

	public void buildTrackAndStart(){

		// TODO Issue Code Debug Tmr
		log.debug("Started Building track");
		if(mPlayer.getSeq()!=null&&mPlayer.getTrack()!=null){
			mPlayer.getSeq().deleteTrack(mPlayer.getTrack());
			mPlayer.setTrack(mPlayer.getSeq().createTrack());
		}

		try {
			mPlayer.makeTracks();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	public int[] getCheckBoxVal(){

		log.debug("Getting Checkbox value from screen");
		int[] trackList = null; 
		for(int i=0;i<INSTRUMENT_SIZE;++i){

			trackList = new int[INSTRUMENT_SIZE];
			int key = instruments[i];

			log.debug("Key Seleted : {}",key);
			log.debug("Check Box List size : {} ",cBoxList.size());
			for(int j=0;j<INSTRUMENT_SIZE;++j){
				JCheckBox jc = (JCheckBox) cBoxList.get(j+(INSTRUMENT_SIZE*i));

				if(jc.isSelected()){
					trackList[j]=key;
				} else {
					trackList[j]=0;
				}
			}

		}
		return trackList;
	}


	class StartButtonListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			log.debug("Start Button Clicked");
			buildTrackAndStart();
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
}
