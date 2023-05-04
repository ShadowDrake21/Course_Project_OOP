package transaction;

import java.awt.Component;

import javax.swing.JLabel;

import view.VisualPart;

public class LabelDoor implements IfromTo{
	private VisualPart gui;
	private JLabel label;
	private QueueWithSlider queue;

	public LabelDoor(VisualPart gui, JLabel label, QueueWithSlider queue) {
		this.gui = gui;
		this.label = label;
		this.queue = queue;
	}

	@Override
	public void onOut(Student st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIn(Student st) {
		queue.onIn(st);
		
	}

	@Override
	public Component getComponent() {
		return label;
	}

}
