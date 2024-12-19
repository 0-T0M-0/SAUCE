package controller;

import model.MathUtils;
import view.TextField;
import view.NormalView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
	/**
	 * Modèle associé au contrôleur
	 */
    private MathUtils model = new MathUtils();
    /**
     * Vue associée au contrôleur
     */
    private NormalView view = new NormalView(this);
    /**
     * Zone de texte de la vue, plus pratique à manipuler
     */
    private TextField textField = view.getTextField();
    /**
     * Booléen décrivant si la dernière opération comportait une erreur de syntaxe/math
     */
    private boolean erreur = false;

    
    public void calculateResult() {
        try {
            // Reset the model before new calculation
            model.clear();

            String expression = textField.getText();
            parseAndCalculate(expression);
        } catch (Exception e) {
        	erreur = true;
            textField.setText("Erreur de saisie");
        }
    }

    private void parseAndCalculate(String expression) {
        // Validate basic expression structure
        if (!isValidExpression(expression)) {
            textField.setText("Invalid Expression");
            return;
        }

        // Split the expression into numbers and operators
        Pattern pattern = Pattern.compile("(\\d+\\.?\\d*)|([+\\-*/%()])", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("\\d+\\.?\\d*")) {
                model.addValue(Double.parseDouble(token));
            } else if (isOperator(token)) {
                model.addOperator(token);
            }
        }

        // Calculate the result
        model.calculateResult();
        double result = model.getCurrentValue();

        // Display the result
        textField.setText(String.valueOf(result));
    }

    public void clearCalculator() {
        textField.setText("");
        model.clear();
    }

    private boolean isValidExpression(String expression) {
        // Basic validation to prevent invalid input
        return expression.matches("^[0-9+\\-*/%().]+$") && 
               expression.chars().filter(ch -> ch == '(').count() == 
               expression.chars().filter(ch -> ch == ')').count();
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/%]");
    }
    
    public boolean getError() { return erreur; }
    public void errorFalse() { this.erreur = false; }
    
}