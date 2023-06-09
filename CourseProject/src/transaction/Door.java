package transaction;

import java.awt.Component;

import javax.swing.JLabel;

import view.VisualPart;
import view.VisualPart;

public class Door implements IfromTo, Runnable{
	private VisualPart gui;
	private Student student;
	private Thread thread;
	private JLabel label;
	
	public Door(VisualPart gui, JLabel label) {
		this.gui = gui;
		this.label = label;
	}
	
	@Override
	public void run() {
		synchronized (gui) {
			do {
				student = new Student(this.gui, this, 5);
				(this.thread = new Thread(this.student)).start();
				try {
					Thread.sleep(this.gui.sliderDoor.getValue() * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while(!this.gui.getEndState());
		}
		
	}

	@Override
	public void onOut(Student tr) {}

	@Override
	public void onIn(Student tr) {}

	@Override
	public Component getComponent() {
		return label;
	}
	
}
