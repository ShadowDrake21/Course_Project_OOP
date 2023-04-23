package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;

import transaction.QueueWithSlider;
import transaction.Sound;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class G {

	private JFrame frame;
	
	private JPanel contentPane;
	private boolean end = true;

	private JButton startButton;
	private JButton endButton;

	private JLabel labelDoorEntry;
	private JLabel labelDoorQueue;
	private JLabel labelComp1;
	private JLabel labelComp2;
	private JLabel labelComp3;
	private JLabel labelDoorExit;

	private JTextField textQueue;
	private JTextField textExit;

	private JSlider sliderMusic;
	private JSlider sliderDoor;
	private JSlider sliderComp;

	private Sound soundtrack;

	public QueueWithSlider queueComputer1;
	public QueueWithSlider queueComputer2;
	public QueueWithSlider queueComputer3;

	private Thread threadMusic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G window = new G();
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
	public G() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 836, 508);
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
		sliderDoor.setBounds(39, 308, 100, 50);

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
		sliderComp.setBounds(484, 403, 100, 50);
		contentPane.add(sliderComp);

		labelDoorEntry= new JLabel("");;
		labelDoorEntry.setBounds(710,198, 90, 100);
		try {
			labelDoorEntry.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/opendoor.png"))
					.getScaledInstance(labelDoorEntry.getWidth(), labelDoorEntry.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(labelDoorEntry);

		labelDoorExit= new JLabel("");;
		labelDoorExit.setBounds(39,198, 90, 100);
		try {
			labelDoorExit.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/opendoor.png"))
					.getScaledInstance(labelDoorExit.getWidth(), labelDoorExit.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(labelDoorExit);

		labelDoorQueue= new JLabel("");;
		labelDoorQueue.setBounds(269,198, 90, 100);
		try {
			labelDoorQueue.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/closedoor.png"))
					.getScaledInstance(labelDoorQueue.getWidth(), labelDoorQueue.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(labelDoorQueue);

		labelComp1 = new JLabel("");
		labelComp1.setBounds(485, 91, 80, 80);
		try {
			labelComp1.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp1.getWidth(), labelComp1.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contentPane.add(labelComp1);

		labelComp2 = new JLabel("");
		labelComp2.setBounds(485, 198, 80, 80);
		try {
			labelComp2.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp2.getWidth(), labelComp2.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(labelComp2);

		labelComp3 = new JLabel("");
		labelComp3.setBounds(485, 313, 80, 80);
		try {
			labelComp3.setIcon(new ImageIcon(ImageIO.read(VisualPart.class.getResource("/source/imgcomp.png"))
					.getScaledInstance(labelComp3.getWidth(), labelComp3.getHeight(), Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(labelComp3);

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
		sliderMusic.setBounds(20, 45, 100, 50);
		contentPane.add(sliderMusic);

		textExit = new JTextField();
		textExit.setText("0");
		textExit.setHorizontalAlignment(SwingConstants.CENTER);
		textExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textExit.setEditable(false);
		textExit.setColumns(10);
		textExit.setBounds(743, 324, 40, 40);
		contentPane.add(textExit);

		JLabel Computers = new JLabel("Computers");
		Computers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Computers.setHorizontalAlignment(SwingConstants.CENTER);
		Computers.setBounds(485, 69, 80, 26);
		contentPane.add(Computers);

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
		//				queueComputer1 = new QueueWithSlider(3, counterQueueComputer1);
		//				queueComputer2 = new QueueWithSlider(3, counterQueueComputer2);
		//				queueComputer3 = new QueueWithSlider(3, counterQueueComputer3);
		startButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		startButton.setBounds(131, 10, 89, 35);
		contentPane.add(startButton);

		endButton = new JButton("End");
		endButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		endButton.setEnabled(false);
		endButton.setBounds(130, 45, 89, 35);
		contentPane.add(endButton);

		JLabel lblMusic = new JLabel("Music volume");
		lblMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMusic.setBounds(21, 10, 100, 26);
		contentPane.add(lblMusic);

		JLabel lblExit = new JLabel("Exit");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExit.setBounds(720, 162, 80, 26);
		contentPane.add(lblExit);

		JLabel lblEntry = new JLabel("Entry");
		lblEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEntry.setBounds(49, 162, 80, 26);
		contentPane.add(lblEntry);

		JLabel lblQueue = new JLabel("Queue");
		lblQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueue.setBounds(269, 162, 80, 26);
		contentPane.add(lblQueue);

		textQueue = new JTextField();
		textQueue.setText("0");
		textQueue.setHorizontalAlignment(SwingConstants.CENTER);
		textQueue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textQueue.setEditable(false);
		textQueue.setColumns(10);
		textQueue.setBounds(294, 308, 40, 40);
		contentPane.add(textQueue);
	}
	
	public void startend() {
		end = !end;
		startButton.setEnabled(end);
		endButton.setEnabled(!end);
	}
}
