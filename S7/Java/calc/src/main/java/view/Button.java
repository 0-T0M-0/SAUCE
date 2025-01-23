package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.CalculatorController;

public class Button extends JButton {
	
	private int action;
	private TextField textField;
	private CalculatorController controller;
	
	protected Button(int action, String label, TextField textField, CalculatorController controller) {
		
		this.action = action;
		this.textField = textField;
		this.controller = controller;
		
		setText(label);
		setBounds(50, 50, 50, 50);
		
		addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction();
            }
        });
		
	}
	
	private void performAction() {
		System.out.println("Button pressed: " + getText());
		if (controller.getError()) {
			textField.setText("");
			controller.errorFalse();
		}
		switch (action) {
		case 0:
			// chiffre
			textField.addText(getText());
			//...
            break;
		case 1:
			// opérateur
			textField.addText(getText());
			//...
            break;
		case 2:
			// =
			controller.calculateResult();
			//...
            break;
		case 3:
			// C
			controller.clearCalculator();
			//...
            break;
		case 4:
			// scientifique
			//faire apparaitre le panel
            break;
		case 5:
			// (
			textField.addText(getText());
            break;
		case 6:
			// )
			textField.addText(getText());
            break;
		}
	}
	
	protected int getActionValue() { return this.action; }

}
