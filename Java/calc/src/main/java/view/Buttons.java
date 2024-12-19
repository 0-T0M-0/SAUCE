package view;

import java.awt.GridLayout;
import javax.swing.JPanel;

import controller.CalculatorController;

public class Buttons extends JPanel {
		
	protected Buttons(TextField textField, CalculatorController controller) {
		
		setLayout(new GridLayout(5, 4));
		
		add(new Button(5, "(", textField, controller));
    	add(new Button(6, ")", textField, controller));
    	add(new Button(1, "%", textField, controller));
    	add(new Button(1, "/", textField, controller));
    	add(new Button(0, "7", textField, controller));
    	add(new Button(0, "8", textField, controller));
    	add(new Button(0, "9", textField, controller));
    	add(new Button(1, "*", textField, controller));
    	add(new Button(0, "4", textField, controller));
    	add(new Button(0, "5", textField, controller));
    	add(new Button(0, "6", textField, controller));
    	add(new Button(1, "-", textField, controller));
    	add(new Button(0, "1", textField, controller));
    	add(new Button(0, "2", textField, controller));
    	add(new Button(0, "3", textField, controller));
    	add(new Button(1, "+", textField, controller));
    	add(new Button(4, "S", textField, controller));
    	add(new Button(0, "0", textField, controller));
    	add(new Button(3, "C", textField, controller));
    	add(new Button(2, "=", textField, controller));	
	}
}