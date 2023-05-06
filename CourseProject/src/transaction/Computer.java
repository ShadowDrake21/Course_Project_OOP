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
			// Цикл перевірки та, можливо, чекання транзакції у черзі
			synchronized (queue) {
				while (queue.getQueueSize() <= 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}// кінець цикду чекання
				std = (Student) queue.removeFirst();
				queue.notify();
			}// конец блока synchronized (queue)
			// Створює поток переміщення транзакції до себе
			Thread t = std.moveFromTo(queue, this, true);
			//Призупиняється на час переміщення транзакції
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			queue1.addToQueue(std);
			
			// Імітує процес обробки транзакції
			try {
				Thread.sleep(this.gui.sliderComp.getValue() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Створює поток переміщення транзакції від себе до лічильник
			queue1.removeFirst();

			std.moveFromTo(this, this.gui.labelExitDoor, false);
		}
	}

}