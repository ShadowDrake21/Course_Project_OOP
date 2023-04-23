package transaction;

import java.awt.Component;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class QueueWithSlider implements IfromTo {
	
	private BlockingQueue<Student> queue;
	private int maxSize;
	private Counter counter;

	public QueueWithSlider(int maxSize, Counter counter) {
		this.maxSize = maxSize;
		this.queue = new ArrayBlockingQueue<>(maxSize);
		this.counter = counter;
	}

	@Override
	public void onOut(Student st) {
		
	}

	@Override
	public void onIn(Student st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getComponent() {
		return counter.getComponent();
	}

	public int getQueueSize() {
		return queue.size();
	}

	public Student removeFirst() {
		Student st = this.queue.remove();
		counter.setCount(counter.getCount()-1);
		return st;
	}

	public void setQueue(BlockingQueue<Student> queue) {
		this.queue = queue;
	}

	public BlockingQueue<Student> getQueue() {
		return queue;
	}

}