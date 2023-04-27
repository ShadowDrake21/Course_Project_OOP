package transaction;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.GUI;
import view.VisualPart;

public class Student implements Runnable{
	private GUI gui;
	private Door doorEntry;
	private int maxQueueSize;
	private JLabel label;
	private String picture;
	private int step = 1;
	
	public Student(GUI gui, Door door, int maxQueueSize) {
		this.gui = gui;
		this.doorEntry = door;
		this.maxQueueSize = maxQueueSize;
		this.label = new JLabel();
		label.setBounds(this.doorEntry.getComponent().getX(), this.doorEntry.getComponent().getY(), 40, 40);
		this.gui.frmKrapyvTurev.add(label);
		this.picture = "";
	}

	@Override
	public void run() {
		try {
			if(this.gui.queueComp1.getQueue().size() < maxQueueSize - 1) {
				this.moveFromTo(this.doorEntry, this.gui.queueComp1).join();
				Thread.sleep(this.gui.sliderComp.getValue() * 1000);
				if(this.gui.queueComp2.getQueue().size() < maxQueueSize) {
					this.moveFromTo(this.doorEntry, this.gui.queueComp2).join();
					Thread.sleep(this.gui.sliderComp.getValue() * 1000);
					this.moveFromTo(this.gui.queueComp2, this.gui.queueExitDoor).join();
					if(this.gui.queueComp3.getQueue().size() < maxQueueSize) {
						this.moveFromTo(this.doorEntry, this.gui.queueComp3).join();
						Thread.sleep(this.gui.sliderComp.getValue() * 1000);
						this.moveFromTo(this.gui.queueComp3, this.gui.queueExitDoor).join();
					} else {
						this.moveFromTo(this.gui.queueComp2, this.gui.queueExitDoor).join();
					}
				} else {
					this.moveFromTo(this.gui.queueComp1, this.gui.queueExitDoor).join();
				}
			}
			else {
				this.moveFromTo(this.gui.queueComp3, this.gui.queueExitDoor).join();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public Thread moveFromTo(final IfromTo from, final IfromTo to) {
		Thread t = new Thread() {
			public void run() {
				int xFrom = from.getComponent().getX();
				int xTo = to.getComponent().getX();
				int lenX = xTo - xFrom;
				int yFrom = from.getComponent().getY();
				int yTo = to.getComponent().getY();
				int lenY = yTo - yFrom;
				int len = (int) Math.round(Math.sqrt((double) (lenX * lenX + lenY * lenY)));
				
				int lenT = (Student.this.label.getWidth() + Student.this.label.getHeight()) / 2;
				int n = len / lenT + step;
				int dx = lenX / n;
				int dy = lenY / n;
				from.onOut(Student.this);
				
				// цикл перемещения
				for(int i = 0, x = xFrom, y = yFrom; i < n; ++i, x += dx, y += dy) {
					URL u = this.getClass().getResource(picture);
					try {
						Image image = ImageIO.read(u);
						image = image.getScaledInstance(Student.this.label.getWidth(), Student.this.label.getHeight(), Image.SCALE_SMOOTH);
						Student.this.label.setIcon(new ImageIcon(image));
						Student.this.label.setBounds(x, y, Student.this.label.getWidth(), Student.this.label.getHeight());
						
						try {
							Thread.sleep(500);
						} catch(InterruptedException e) {
							e.printStackTrace();
						}
						Student.this.label.setBounds(x, y, Student.this.label.getWidth(), Student.this.label.getHeight());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				Student.this.label.setIcon(null);
				to.onIn(Student.this);
			}
		};
		t.start();
		return t;
	}

}
