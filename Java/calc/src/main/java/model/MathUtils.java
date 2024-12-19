package model;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {
	
	/**
	 * La valeur actuellement rentrée.
	 */
	private double currentValue = 0;
	/**
	 * La liste des nombres à traiter, dans l'ordre 
	 */
	private List<Double> nextValues = new ArrayList<>();
	/**
	 * Les opérateurs à venir, parmi "+", "-", "*", "/" et "%".
	 */
	private List<String> operator = new ArrayList<>();
	
	
	/**
	 * Méthodes pour effectuer l'opération éponyme avec la valeur passée en paramètre. 
	 * @param value la valeur à ajouter
	 */
	private double add(double a, double b) { return a + b; }
	private double substract(double a, double b) { return a - b; }
	private double multiply(double a, double b) { return a * b; }
	private double divide(double a, double b) {
		try {
			if (b == 0) {
				throw new ArithmeticException("Cannot divide by zero");
			}
			return a / b;
		} catch (ArithmeticException e) {
			return Double.NaN;
		}
	}
	private double modulo(double a, double b) {
		try {
			if (b == 0) {
				throw new ArithmeticException("Cannot divide by zero");
			}
			return a % b;
		} catch (ArithmeticException e) {
			return Double.NaN;
		}
	}
	
	/**
	 * Réinitialiser les valeurs pour recommencer un calcul.
	 */
	public void clear() {
		this.currentValue = 0;
		this.nextValues.clear();
		this.operator.clear();
	};
	
	/**
	 * @return la valeur actuelle du calcul.
	 */
	public double getCurrentValue() {
		return this.currentValue;
	}
	
	/**
	 * Ajouter un nombre à la suite à effectuer
	 * @param value
	 */
	public void addValue(double value) {
		this.nextValues.add(value);
	}
	
	/**
	 * Ajouter un opérateur à la suite à effectuer
	 * @param operator
	 */
	public void addOperator(String operator) {
		this.operator.add(operator);
	}
	
	/**
	 * Calculer le résultat avec les champs de l'instance
	 */
	public void calculateResult() {
		/*if (nextValues.isEmpty() || operator.isEmpty()) {
            throw new IllegalArgumentException("The lists of values or operators cannot be empty.");
        }*/
		
		if (operator.size() == nextValues.size()) {
			nextValues.add(0, this.currentValue);
		}
		
		String op;
		double result = 0;
		
		// On traite les opérations prioritaires en premier
		for (int i = 0; i < operator.size(); i++) {
			op = operator.get(i);
			if (op.equals("*") || op.equals("/") || op.equals("%")) {
				switch (op) {
				case "*":
					result = multiply(nextValues.get(i), nextValues.get(i+1));
					break;
				case "/":
					result = divide(nextValues.get(i), nextValues.get(i+1));
					break;
				case "%":
					result = modulo(nextValues.get(i), nextValues.get(i+1));
					break;
				}
				nextValues.remove(i+1);
				operator.remove(i);
				nextValues.set(i, result);
				i--; // On reste sur le même indice à chaque opération
			}
		}
		while (operator.size() != 0) {
			if (operator.get(0) == "+") {
				result = add(nextValues.get(0), nextValues.get(1));
			} else {
				result = substract(nextValues.get(0), nextValues.get(1));
			}
			nextValues.remove(1);
			operator.remove(0);
			nextValues.set(0, result);
		}
		currentValue = nextValues.get(0);
	}
}
