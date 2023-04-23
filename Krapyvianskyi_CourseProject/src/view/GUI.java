package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import transaction.Sound;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GUI {

	private boolean end = true;
	private JFrame frame;
	private JTextField textExit;
	private JTextField textQueue;
	private JSlider sliderMusic;
	private JButton startButton;
	private JButton endButton;
	private JSlider sliderDoor;
	private JSlider sliderComp;
	private JLabel lblMusic;
	private JLabel lblEntry;
	private JLabel lblQueue;
	private JLabel Computers;
	private JLabel lblExit;
	private JLabel labelDoorExit;
	private JLabel labelComp3;
	private JLabel labelComp2;
	private JLabel labelComp1;
	private JLabel labelDoorQueue;
	private JLabel labelDoorEntry;
	private Thread threadMusic;
	private Sound soundtrack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 807, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		sliderDoor = new JSlider();
		sliderDoor.setValue(2);
		sliderDoor.setToolTipText("EntryTime");
		sliderDoor.setPaintTicks(true);
		sliderDoor.setPaintLabels(true);
		sliderDoor.setMinorTickSpacing(1);
		sliderDoor.setMinimum(1);
		sliderDoor.setMaximum(4);
		sliderDoor.setMajorTickSpacing(1);
		sliderDoor.setFont(new Font("Courier New", Font.BOLD, 18));
		sliderDoor.setBounds(19, 298, 100, 50);
		frame.getContentPane().add(sliderDoor);
		
		sliderComp = new JSlider();
		sliderComp.setValue(2);
		sliderComp.setToolTipText("TestTime");
		sliderComp.setPaintTicks(true);
		sliderComp.setPaintLabels(true);
		sliderComp.setMinorTickSpacing(1);
		sliderComp.setMinimum(1);
		sliderComp.setMaximum(4);
		sliderComp.setMajorTickSpacing(1);
		sliderComp.setFont(new Font("Courier New", Font.BOLD, 18));
		sliderComp.setBounds(464, 393, 100, 50);
		frame.getContentPane().add(sliderComp);
		
		labelDoorExit = new JLabel("");
		labelDoorExit.setBounds(690, 188, 90, 100);
		try {
			labelDoorExit.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/opendoor.png"))
					.getScaledInstance(labelDoorExit.getWidth(), labelDoorExit.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frame.getContentPane().add(labelDoorExit);
		
		labelDoorEntry = new JLabel("");
		labelDoorEntry.setBounds(19, 188, 90, 100);
		try {
			labelDoorEntry.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/opendoor.png"))
					.getScaledInstance(labelDoorEntry.getWidth(), labelDoorEntry.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frame.getContentPane().add(labelDoorEntry);
		
		labelDoorQueue = new JLabel("");
		labelDoorQueue.setBounds(249, 188, 90, 100);
		try {
			labelDoorQueue.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/closedoor.png"))
					.getScaledInstance(labelDoorQueue.getWidth(), labelDoorQueue.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.getContentPane().add(labelDoorQueue);
		
		labelComp1 = new JLabel("");
		labelComp1.setBounds(465, 81, 80, 80);
		try {
			labelComp1.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp1.getWidth(), labelComp1.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().add(labelComp1);
		
		labelComp2 = new JLabel("");
		labelComp2.setBounds(465, 188, 80, 80);
		try {
			labelComp2.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp2.getWidth(), labelComp2.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().add(labelComp2);
		
		labelComp3 = new JLabel("");
		labelComp3.setBounds(465, 303, 80, 80);
		try {
			labelComp3.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp3.getWidth(), labelComp3.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().add(labelComp3);
		
		sliderMusic = new JSlider();
		sliderMusic.setValue(3);
		sliderMusic.setToolTipText("MusicVolume");
		sliderMusic.setPaintTicks(true);
		sliderMusic.setPaintLabels(true);
		sliderMusic.setMinorTickSpacing(1);
		sliderMusic.setMinimum(1);
		sliderMusic.setMaximum(5);
		sliderMusic.setMajorTickSpacing(1);
		sliderMusic.setFont(new Font("Courier New", Font.BOLD, 18));
		sliderMusic.setBounds(0, 35, 100, 50);
		frame.getContentPane().add(sliderMusic);
		
		textExit = new JTextField();
		textExit.setText("0");
		textExit.setHorizontalAlignment(SwingConstants.CENTER);
		textExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textExit.setEditable(false);
		textExit.setColumns(10);
		textExit.setBounds(723, 314, 40, 40);
		frame.getContentPane().add(textExit);
		
		Computers = new JLabel("Computers");
		Computers.setHorizontalAlignment(SwingConstants.CENTER);
		Computers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Computers.setBounds(465, 59, 80, 26);
		frame.getContentPane().add(Computers);
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startend();
				threadMusic = new Thread() {
					public void run() {
						soundtrack = new Sound("/music/Eiffel_65_-_Blue_Da_Ba_Dee.wav", sliderMusic);
						soundtrack.playMusic();
						soundtrack.loopMusic();

						new Thread(() -> {
							while(true) {
								soundtrack.setVolume();
								System.out.println("Works");
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start();	

						// thread
					}
				};
				threadMusic.start();
			}

		});
		startButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		startButton.setBounds(111, 0, 89, 35);
		frame.getContentPane().add(startButton);
		
		endButton = new JButton("End");
		endButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		endButton.setEnabled(false);
		endButton.setBounds(110, 35, 89, 35);
		frame.getContentPane().add(endButton);
		
		lblMusic = new JLabel("Music volume");
		lblMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMusic.setBounds(1, 0, 100, 26);
		frame.getContentPane().add(lblMusic);
		
		lblExit = new JLabel("Exit");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExit.setBounds(700, 152, 80, 26);
		frame.getContentPane().add(lblExit);
		
		lblEntry = new JLabel("Entry");
		lblEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEntry.setBounds(29, 152, 80, 26);
		frame.getContentPane().add(lblEntry);
		
		lblQueue = new JLabel("Queue");
		lblQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueue.setBounds(249, 152, 80, 26);
		frame.getContentPane().add(lblQueue);
		
		textQueue = new JTextField();
		textQueue.setText("0");
		textQueue.setHorizontalAlignment(SwingConstants.CENTER);
		textQueue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textQueue.setEditable(false);
		textQueue.setColumns(10);
		textQueue.setBounds(274, 298, 40, 40);
		frame.getContentPane().add(textQueue);
	}
	
	public void startend() {
		end = !end;
		startButton.setEnabled(end);
		endButton.setEnabled(!end);
	}
}
