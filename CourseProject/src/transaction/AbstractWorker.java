package transaction;

import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;

import view.VisualPart;
import view.VisualPart;

public abstract class AbstractWorker implements IfromTo, Runnable{
	protected VisualPart gui;
	protected JLabel label;
	protected JSlider minWorkTimeSlider;
	protected QueueWithSlider queue;
	protected QueueWithSlider queue1;
	protected Student std;
	
	public AbstractWorker(VisualPart gui, JLabel label, JSlider minWorkTimeSlider, QueueWithSlider queue, QueueWithSlider queue1) {		
		this.gui = gui;
		this.label = label;
		this.minWorkTimeSlider = minWorkTimeSlider;
		this.queue = queue;
		this.queue1 = queue1;
	}

	@Override
	public void onOut(Student tr) {}

	@Override
	public void onIn(Student tr) {}

	@Override
	public Component getComponent() {
		return label;
	}
	
	protected void showWorking(String[] strings) {
		
	}
	
	protected void display(String pct) throws IOException {
//		URL u = getClass().getResource(pct);
//		ImageIcon image = new ImageIcon(u);
//		label.setIcon(image);
		URL u = getClass().getResource(pct);
		// зчитуємо зображення в icon
		Image image = ImageIO.read(u);
		image = image.getScaledInstance(this.label.getWidth(), this.label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(image));
	}
}
