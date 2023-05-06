package transaction;

import java.awt.Component;

import javax.swing.JTextField;

public class Counter implements IfromTo{
	private int count;
	private JTextField textField;
	
	public Counter(JTextField textField) {
		this.textField = textField;
		this.count = 0;
	}

	@Override
	public void onOut(Student st) {	
	}

	@Override
	public void onIn(Student st) {	
		textField.setText(String.valueOf(++count));
	}

	@Override
	public Component getComponent() {	
		return textField;
	}
	
	public void setCount(int count) {
		this.count = count;
		textField.setText(String.valueOf(count));
	}

	public int getCount() {
		this.count = Integer.parseInt(textField.getText());
		return count;
	}
	
}
