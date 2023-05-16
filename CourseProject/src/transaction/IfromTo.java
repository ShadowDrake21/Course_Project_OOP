package transaction;

import java.awt.Component;

public interface IfromTo {
	public void onOut(Student st); 
	public void onIn(Student st);
	public Component getComponent();
}
