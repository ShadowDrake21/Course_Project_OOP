package transaction;

import java.awt.Component;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class QueueWithSlider implements IfromTo {
	
	private BlockingQueue<Student> queue;
	private int maxSize;
	private Counter counter;
    private boolean infinity;

	public QueueWithSlider(int maxSize, Counter counter, boolean infinity) {
		this.maxSize = maxSize;
		this.queue = new ArrayBlockingQueue<>(maxSize);
		this.counter = counter;
		this.infinity = infinity;
	}

	@Override
	public void onOut(Student st) {
		
	}

	@Override
	public void onIn(Student st) {
		synchronized (this) {
			if(infinity) {
				counter.setCount(counter.getCount()+1);
				return;
			}
			if(this.queue.size() < maxSize) {
				this.addToQueue(st);
				this.notify();
				return;
			}
		}
	}
	
	public void addToQueue(Student student) {
	    this.queue.add(student);
	    counter.setCount(counter.getCount() + 1);
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