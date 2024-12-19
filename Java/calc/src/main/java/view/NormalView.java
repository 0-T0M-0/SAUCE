package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.CalculatorController;
import model.MathUtils;

public class NormalView extends JFrame {
	
	private CalculatorController controller;
	private Buttons boutons;
	private TextField textField = new TextField();
	
    public NormalView(CalculatorController controller) {
    	this.controller = controller;
    	
    	boutons = new Buttons(textField, controller);
    	setTitle("Calculatrice");
    	setLayout(new BorderLayout());
        
        add(textField, BorderLayout.NORTH);
    	add(boutons, BorderLayout.CENTER);
    	
    	setSize(500, 600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    }
    
    public Buttons getButtons() { return boutons; }
    public TextField getTextField() { return textField; }
    
}
