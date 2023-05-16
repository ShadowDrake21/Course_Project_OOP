package transaction;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.VisualPart;
import view.VisualPart;

public class Student implements Runnable{
	private VisualPart gui;
	private Door doorEntry;
	private int maxQueueSize;
	private JLabel label;
	private String picture;
	private int step = 1;
	
	public Student(VisualPart gui, Door door, int maxQueueSize) {
		this.gui = gui;
		this.doorEntry = door;
		this.maxQueueSize = maxQueueSize;
		this.label = new JLabel();
		label.setBounds(this.doorEntry.getComponent().getX(), this.doorEntry.getComponent().getY(), 56, 56);
		this.gui.frmKrapyvTurev.add(label);
		this.picture = "/source/1.1.png";
	}

	@Override
	public void run() {
		try {
			if (this.gui.queueDoor.getQueue().size() < maxQueueSize - 1) {
				this.moveFromTo(this.doorEntry, this.gui.labelDoor, false).join();
				Thread.sleep(this.gui.sliderDoor.getValue() * 1000);			
			} else {
				if (this.gui.queueComp1.getQueue().size() < maxQueueSize) {
					this.moveFromTo(this.gui.labelDoor, this.gui.computer1, true).join();
					Thread.sleep(this.gui.sliderComp.getValue() * 1000);
					this.moveFromTo(this.gui.computer1, this.gui.labelExitDoor, false).join();
				} else {
					if (this.gui.queueComp2.getQueue().size() < maxQueueSize) {
						this.moveFromTo(this.gui.labelDoor, this.gui.computer2, true).join();
						Thread.sleep(this.gui.sliderComp.getValue() * 1000);
						this.moveFromTo(this.gui.computer2, this.gui.labelExitDoor, false).join();
					} else {
						if (this.gui.queueComp3.getQueue().size() < maxQueueSize) {
							this.moveFromTo(this.gui.labelDoor, this.gui.computer3, true).join();
							Thread.sleep(this.gui.sliderComp.getValue() * 1000);
							this.moveFromTo(this.gui.computer3, this.gui.labelExitDoor, false).join();
						} else {
							this.moveFromTo(this.doorEntry, this.gui.labelExitDoor, false).join();
						}
					}
				}
			}
		}		
		catch(InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public Thread moveFromTo(final IfromTo from, final IfromTo to, boolean isDoor) {
		Thread t = new Thread() {
			public void run() {
				int xFrom;
				if(isDoor) {
					xFrom = from.getComponent().getX() + 30;
				} else {
					xFrom = from.getComponent().getX() + 20;
				}
				int xTo = to.getComponent().getX();
				int lenX = xTo - xFrom;
				int yFrom;
				if(isDoor) {
					yFrom = from.getComponent().getY() - 80;
				} else {
					yFrom = from.getComponent().getY() + 20;
				}
				
				int yTo = to.getComponent().getY() + 20;
				int lenY = yTo - yFrom;
				int len = (int) Math.round(Math.sqrt((double) (lenX * lenX + lenY * lenY)));
				
				int lenT = (Student.this.label.getWidth() + Student.this.label.getHeight()) / 2;
				int n = len / lenT + step;
				int dx = lenX / n;
				int dy = lenY / n;
				from.onOut(Student.this);
				
				for(int i = 0, x = xFrom, y = yFrom; i < n; ++i, x += dx, y += dy) {
					if(i%4==0)picture = "/source/1.1.png";
					if(i%4==1)picture = "/source/1.2.png";
					if(i%4==2)picture = "/source/1.3.png";
					if(i%4==3)picture = "/source/1.4.png";
					URL u = this.getClass().getResource(picture);				
					try {
						Image image = ImageIO.read(u);
						image = image.getScaledInstance(Student.this.label.getWidth(), Student.this.label.getHeight(), Image.SCALE_SMOOTH);
						Student.this.label.setIcon(new ImageIcon(image));
						Student.this.label.setBounds(x, y, Student.this.label.getWidth(), Student.this.label.getHeight());
						
						try {
							Thread.sleep(600);
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