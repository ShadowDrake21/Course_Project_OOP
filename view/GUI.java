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

import transaction.Computer;
import transaction.Counter;
import transaction.Door;
import transaction.QueueWithSlider;
import transaction.Sound;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GUI {

	private boolean end = true;
	public JFrame frmKrapyvTurev;
	private JTextField textExit;
	private JTextField textQueue;
	private JSlider sliderMusic;
	private JButton startButton;
	private JButton endButton;
	public JSlider sliderDoor;
	public JSlider sliderComp;
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
	
	public Counter counterQueueEntry;
	public Counter counterQueueExit;
	public Counter counterQueueComp1;
	public Counter counterQueueComp2;
	public Counter counterQueueComp3;
	private JTextField textQueueComp1;
	private JTextField textQueueComp2;
	private JTextField textQueueComp3;

	public QueueWithSlider queueComp1;
	public QueueWithSlider queueComp2;
	public QueueWithSlider queueComp3;
	
	private Thread threadDoor;
	private Thread threadComp1;
	private Thread threadComp2;
	private Thread threadComp3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmKrapyvTurev.setVisible(true);
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
		frmKrapyvTurev = new JFrame();
		frmKrapyvTurev.setBounds(100, 100, 807, 489);
		frmKrapyvTurev.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKrapyvTurev.getContentPane().setLayout(null);
		
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
		frmKrapyvTurev.getContentPane().add(sliderDoor);
		
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
		frmKrapyvTurev.getContentPane().add(sliderComp);
		
		labelDoorExit = new JLabel("");
		labelDoorExit.setBounds(690, 188, 90, 100);
		try {
			labelDoorExit.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/opendoor.png"))
					.getScaledInstance(labelDoorExit.getWidth(), labelDoorExit.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frmKrapyvTurev.getContentPane().add(labelDoorExit);
		
		labelDoorEntry = new JLabel("");
		labelDoorEntry.setBounds(19, 188, 90, 100);
		try {
			labelDoorEntry.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/opendoor.png"))
					.getScaledInstance(labelDoorEntry.getWidth(), labelDoorEntry.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frmKrapyvTurev.getContentPane().add(labelDoorEntry);
		
		labelDoorQueue = new JLabel("");
		labelDoorQueue.setBounds(249, 188, 90, 100);
		try {
			labelDoorQueue.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/closedoor.png"))
					.getScaledInstance(labelDoorQueue.getWidth(), labelDoorQueue.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frmKrapyvTurev.getContentPane().add(labelDoorQueue);
		
		labelComp1 = new JLabel("");
		labelComp1.setBounds(465, 81, 80, 80);
		try {
			labelComp1.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp1.getWidth(), labelComp1.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmKrapyvTurev.getContentPane().add(labelComp1);
		
		labelComp2 = new JLabel("");
		labelComp2.setBounds(465, 188, 80, 80);
		try {
			labelComp2.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp2.getWidth(), labelComp2.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmKrapyvTurev.getContentPane().add(labelComp2);
		
		labelComp3 = new JLabel("");
		labelComp3.setBounds(465, 303, 80, 80);
		try {
			labelComp3.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp3.getWidth(), labelComp3.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmKrapyvTurev.getContentPane().add(labelComp3);
		
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
		frmKrapyvTurev.getContentPane().add(sliderMusic);
		
		textExit = new JTextField();
		textExit.setText("0");
		textExit.setHorizontalAlignment(SwingConstants.CENTER);
		textExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textExit.setEditable(false);
		textExit.setColumns(10);
		textExit.setBounds(723, 314, 40, 40);
		frmKrapyvTurev.getContentPane().add(textExit);
		
		Computers = new JLabel("Computers");
		Computers.setHorizontalAlignment(SwingConstants.CENTER);
		Computers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Computers.setBounds(465, 59, 80, 26);
		frmKrapyvTurev.getContentPane().add(Computers);
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startend();
				threadMusic = new Thread() {
					public void run() {
						soundtrack = new Sound("/music/Eiffel 65 Ч Blue.wav", sliderMusic);
						soundtrack.playMusic();
						soundtrack.loopMusic();

						new Thread(() -> {
							while(true) {
								soundtrack.setVolume();
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
				// л≥чильник на GUI
				counterQueueEntry = new Counter(textQueue);
				counterQueueExit = new Counter(textExit);
				counterQueueComp1 = new Counter(textQueueComp1);
				counterQueueComp2 = new Counter(textQueueComp2);
				counterQueueComp3 = new Counter(textQueueComp3);
				counterQueueExit = new Counter(textExit);
				
				counterQueueEntry.setCount(0);
				counterQueueExit.setCount(0);
				counterQueueComp1.setCount(0);
				counterQueueComp2.setCount(0);
				counterQueueComp3.setCount(0);
				
				// черги
				queueComp1 = new QueueWithSlider(3, counterQueueComp1);
				queueComp2 = new QueueWithSlider(3, counterQueueComp2);
				queueComp3 = new QueueWithSlider(3, counterQueueComp3);
				
				// об'Їкти дл€ поток≥в
				Door entryDoor = new Door(GUI.this, labelDoorEntry);
				Computer computer1 = new Computer(GUI.this, labelComp1, sliderComp, queueComp1, counterQueueComp1);
				Computer computer2 = new Computer(GUI.this, labelComp2, sliderComp, queueComp2, counterQueueComp2);
				Computer computer3 = new Computer(GUI.this, labelComp3, sliderComp, queueComp3, counterQueueComp3);
				
				// потоки
				threadDoor = new Thread(entryDoor);
				threadComp1 = new Thread(computer1);
				threadComp2 = new Thread(computer2);
				threadComp3 = new Thread(computer3);
				
				// запуск потоков
//				threadDoor.start();
//				threadComp1.start();
//				threadComp2.start();
//				threadComp3.start();
				
				threadMusic.start();
			}

		});
		startButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		startButton.setBounds(111, 0, 89, 35);
		frmKrapyvTurev.getContentPane().add(startButton);
		
		endButton = new JButton("End");
		endButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		endButton.setEnabled(false);
		endButton.setBounds(110, 35, 89, 35);
		frmKrapyvTurev.getContentPane().add(endButton);
		
		lblMusic = new JLabel("Music volume");
		lblMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMusic.setBounds(1, 0, 100, 26);
		frmKrapyvTurev.getContentPane().add(lblMusic);
		
		lblExit = new JLabel("Exit");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExit.setBounds(700, 152, 80, 26);
		frmKrapyvTurev.getContentPane().add(lblExit);
		
		lblEntry = new JLabel("Entry");
		lblEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEntry.setBounds(29, 152, 80, 26);
		frmKrapyvTurev.getContentPane().add(lblEntry);
		
		lblQueue = new JLabel("Queue");
		lblQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueue.setBounds(249, 152, 80, 26);
		frmKrapyvTurev.getContentPane().add(lblQueue);
		
		textQueue = new JTextField();
		textQueue.setText("0");
		textQueue.setHorizontalAlignment(SwingConstants.CENTER);
		textQueue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textQueue.setEditable(false);
		textQueue.setColumns(10);
		textQueue.setBounds(273, 298, 40, 40);
		frmKrapyvTurev.getContentPane().add(textQueue);
		
		textQueueComp1 = new JTextField();
		textQueueComp1.setText("0");
		textQueueComp1.setHorizontalAlignment(SwingConstants.CENTER);
		textQueueComp1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textQueueComp1.setEditable(false);
		textQueueComp1.setColumns(10);
		textQueueComp1.setBounds(551, 96, 40, 40);
		frmKrapyvTurev.getContentPane().add(textQueueComp1);
		
		textQueueComp2 = new JTextField();
		textQueueComp2.setText("0");
		textQueueComp2.setHorizontalAlignment(SwingConstants.CENTER);
		textQueueComp2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textQueueComp2.setEditable(false);
		textQueueComp2.setColumns(10);
		textQueueComp2.setBounds(551, 200, 40, 40);
		frmKrapyvTurev.getContentPane().add(textQueueComp2);
		
		textQueueComp3 = new JTextField();
		textQueueComp3.setText("0");
		textQueueComp3.setHorizontalAlignment(SwingConstants.CENTER);
		textQueueComp3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textQueueComp3.setEditable(false);
		textQueueComp3.setColumns(10);
		textQueueComp3.setBounds(551, 325, 40, 40);
		frmKrapyvTurev.getContentPane().add(textQueueComp3);
	}
	
	public void startend() {
		end = !end;
		startButton.setEnabled(end);
		endButton.setEnabled(!end);
	}
	
	public boolean getEndState() {
		return end;
	}
}
