package transaction;

import java.awt.Component;

public interface IfromTo {
	public void onOut(Student tr); // начало движения транзакции
	public void onIn(Student tr); // конец движения транзакции
	public Component getComponent();
}
