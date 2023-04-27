package transaction;

import javax.swing.JLabel;
import javax.swing.JSlider;

import view.GUI;
import view.VisualPart;

public class Computer extends AbstractWorker {
	private Counter counter;
	private Counter exit;

	public Computer(GUI gui, JLabel label, JSlider minWorkTimeSlider, QueueWithSlider queue, Counter exit) {
		super(gui, label, minWorkTimeSlider, queue);
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
			Thread t = std.moveFromTo(queue, this);
			//Призупиняється на час переміщення транзакції
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Імітує процес обробки транзакції
			//showWorking(pcts);
			// Створює поток переміщення транзакції від себе до лічильник
			std.moveFromTo(this, counter);
		}
	}

}