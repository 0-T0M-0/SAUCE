package com.mycompany.mavenproject1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorModel {

    // ScriptEngine instance for evaluating JavaScript expressions
    private final ScriptEngine engine;

    // Constructor initializes the ScriptEngine
    public CalculatorModel() {
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
    }

    /**
     * Evaluates a mathematical expression and returns the result.
     * @param expression The mathematical expression to evaluate
     * @return The result of the evaluation
     * @throws ScriptException If there is an error in evaluating the expression
     */
    public double evaluate(String expression) throws ScriptException {
        // Replace "!" with factorial logic
        expression = handleFactorial(expression);
        // Evaluate the expression using the ScriptEngine
        Object result = engine.eval(expression);
        // Return the result as a double
        return result instanceof Integer ? (Integer) result : (Double) result;
    }

    /**
     * Handles the factorial operation in the expression.
     * @param expression The expression containing the factorial operation
     * @return The expression with factorials replaced by their results
     */
    private String handleFactorial(String expression) {
        while (expression.contains("!")) {
            int index = expression.indexOf("!");
            int start = index - 1;

            // Find the start of the number
            while (start >= 0 && Character.isDigit(expression.charAt(start))) {
                start--;
            }
            start++;

            // Extract the number and calculate the factorial
            String numberStr = expression.substring(start, index);
            int number = Integer.parseInt(numberStr);
            int factorial = factorial(number);

            // Replace "number!" with the factorial result
            expression = expression.substring(0, start) + factorial + expression.substring(index + 1);
        }
        return expression;
    }

    /**
     * Calculates the factorial of a number.
     * @param n The number to calculate the factorial of
     * @return The factorial of the number
     */
    private int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
