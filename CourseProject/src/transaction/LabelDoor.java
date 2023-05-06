package transaction;

import java.awt.Component;

import javax.swing.JLabel;

import view.VisualPart;

public class LabelDoor implements IfromTo{
	private VisualPart gui;
	private JLabel label;
	private Counter counterExit;
	private QueueWithSlider queue;
	private boolean isExit;

	public LabelDoor(VisualPart gui, JLabel label, Counter counterExit, QueueWithSlider queue, boolean isExit) {
		this.gui = gui;
		this.label = label;
		this.counterExit = counterExit;
		this.queue = queue;
		this.isExit = isExit;
	}

	@Override
	public void onOut(Student st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIn(Student st) {
		if(!isExit) {
			queue.onIn(st);
		}
		else {
			counterExit.onIn(st);
		}
	}

	@Override
	public Component getComponent() {
		return label;
	}

}
