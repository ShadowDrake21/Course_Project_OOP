package transaction;

import java.awt.Component;

public interface IfromTo {
	public void onOut(Transaction tr); // ������ �������� ����������
	public void onIn(Transaction tr); // ����� �������� ����������
	public Component getComponent();
}
