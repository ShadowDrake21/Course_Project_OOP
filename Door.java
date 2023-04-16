package transaction;

import java.awt.Component;

import javax.swing.JLabel;

import view.VisualPart;

public class Door implements IfromTo, Runnable{
	private VisualPart gui;
	private int speed = 3;
	private Student student;
	private JLabel label;
	
	public Door(VisualPart gui, JLabel label) {
		this.gui = gui;
		this.label = label;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOut(Student tr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIn(Student tr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
