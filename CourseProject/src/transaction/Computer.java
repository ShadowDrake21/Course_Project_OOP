package transaction;

import javax.swing.JLabel;
import javax.swing.JSlider;

import view.VisualPart;


public class Computer extends AbstractWorker {
	
	public Computer(VisualPart gui, JLabel label, JSlider minWorkTimeSlider, QueueWithSlider queue, QueueWithSlider queue1) {
		super(gui, label, minWorkTimeSlider, queue,queue1);
	}

	@Override
	public void run() {
		while (!this.gui.getEndState() || queue.getQueueSize() > 0) {
			synchronized (queue) {
				while (queue.getQueueSize() <= 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				std = (Student) queue.removeFirst();
				queue.notify();
			}
			
			Thread t = std.moveFromTo(queue, this, true);
			
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			queue1.addToQueue(std);
			
			
			try {
				Thread.sleep(this.gui.sliderComp.getValue() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			queue1.removeFirst();

			std.moveFromTo(this, this.gui.labelExitDoor, false);
		}
	}

}