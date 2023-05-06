package transaction;

import java.awt.Component;

import javax.swing.JLabel;

import view.VisualPart;

public class LabelDoor implements IfromTo{
	private VisualPart gui;
	private JLabel label;
	private Counter counterExit;
	private QueueWithSlider queue1;
	private QueueWithSlider queue2;
	private QueueWithSlider queue3;

	public LabelDoor(VisualPart gui, JLabel label, Counter counterExit, QueueWithSlider queue1, QueueWithSlider queue2, QueueWithSlider queue3) {
		this.gui = gui;
		this.label = label;
		this.counterExit = counterExit;
		this.queue1 = queue1;
		this.queue2 = queue2;
		this.queue3 = queue3;
	}

	@Override
	public void onOut(Student st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIn(Student st) {
		if(queue2 == null && queue3 == null) {
			queue1.onIn(st);
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
