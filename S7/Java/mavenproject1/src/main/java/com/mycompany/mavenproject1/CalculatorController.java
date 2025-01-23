package com.mycompany.mavenproject1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;

public class CalculatorController {

    private final CalculatorModel model; // Modèle de la calculatrice
    private final Calculatrice view; // Vue de la calculatrice
    private boolean isErrorState = false; // État d'erreur de la calculatrice

    // Moteur d'évaluation JavaScript
    private final ScriptEngine engine;

    public CalculatorController(CalculatorModel model, Calculatrice view) {
        this.model = model;
        this.view = view;
        this.engine = new ScriptEngineManager().getEngineByName("JavaScript");

        initController(); // Initialiser le contrôleur
    }

    private void initController() {
        // Boutons numériques
        JButton[] numberButtons = {
            view.getButton0(), view.getButton1(), view.getButton2(),
            view.getButton3(), view.getButton4(), view.getButton5(),
            view.getButton6(), view.getButton7(), view.getButton8(), view.getButton9()
        };

        // Ajouter des écouteurs d'action pour les boutons numériques
        for (int i = 0; i < numberButtons.length; i++) {
            final int num = i;
            numberButtons[i].addActionListener(e -> appendToDisplay(String.valueOf(num)));
        }

        // Ajouter des écouteurs d'action pour les boutons opérateurs
        view.getButtonAdd().addActionListener(e -> appendToDisplay("+"));
        view.getButtonSub().addActionListener(e -> appendToDisplay("-"));
        view.getButtonMult().addActionListener(e -> appendToDisplay("*"));
        view.getButtonDiv().addActionListener(e -> appendToDisplay("/"));
        view.getButtonModulo().addActionListener(e -> appendToDisplay("%"));

        // Ajouter des écouteurs d'action pour les parenthèses et décimales
        view.getButtonDecimal().addActionListener(e -> appendToDisplay("."));
        view.getButtonOpenParen().addActionListener(e -> appendToDisplay("("));
        view.getButtonCloseParen().addActionListener(e -> appendToDisplay(")"));

        // Ajouter des écouteurs d'action pour les boutons spécifiques
        view.getButtonClear().addActionListener(e -> clear());
        view.getButtonEnter().addActionListener(e -> calculate());
        view.getButtonBackspace().addActionListener(e -> backspace());

        // Ajouter des écouteurs d'action pour les fonctions scientifiques
        view.getButtonSin().addActionListener(e -> appendScientificFunction("sin", "Math.sin"));
        view.getButtonCos().addActionListener(e -> appendScientificFunction("cos", "Math.cos"));
        view.getButtonTan().addActionListener(e -> appendScientificFunction("tan", "Math.tan"));
        
        // Ajouter un écouteur d'action pour le bouton Factoriel
        view.getButtonFactorial().addActionListener(e -> appendFactorial());
    }

    private void appendToDisplay(String value) {
        if (isErrorState) {
            clear(); // Réinitialiser si une erreur est affichée
        }
        String currentText = view.getDisplayResult().getText();
        view.getDisplayResult().setText(currentText.equals("0") ? value : currentText + value);
    }

    private void appendFactorial() {
        if (isErrorState) {
            clear(); // Réinitialiser si une erreur est affichée
        }
        String currentText = view.getDisplayResult().getText();
        if (!currentText.equals("0")) {
            // Ajouter un "!" après le nombre
            view.getDisplayResult().setText(currentText + "!");
        }
    }

    private void appendScientificFunction(String displayFunction, String engineFunction) {
        if (isErrorState) {
            clear();
        }

        String currentText = view.getDisplayResult().getText();
        if (currentText.equals("0")) {
            view.getDisplayResult().setText("");
        }

        // Ajouter la fonction scientifique
        view.getDisplayResult().setText(view.getDisplayResult().getText() + displayFunction + "(");
    }

    private void clear() {
        view.getDisplayResult().setText("0"); // Réinitialiser l'affichage à "0"
        isErrorState = false; // Réinitialiser l'état d'erreur
    }

    private void backspace() {
        if (isErrorState) {
            clear(); // Réinitialiser si une erreur est affichée
            return;
        }

        String currentText = view.getDisplayResult().getText();
        if (currentText.length() > 1) {
            view.getDisplayResult().setText(currentText.substring(0, currentText.length() - 1));
        } else {
            view.getDisplayResult().setText("0");
        }
    }

    private void calculate() {
        String expression = view.getDisplayResult().getText();

        try {
            // Si l'expression contient un "!", calculer le factoriel
            // Tant que l'expression contient un "!", calculer le factoriel
            while (expression.contains("!")) {
                // Trouver l'index du "!"
                int index = expression.indexOf("!");
                // Trouver le début du nombre avant le "!"
                int start = index - 1;
                while (start >= 0 && Character.isDigit(expression.charAt(start))) {
                    start--;
                }
                start++; // Ajuster pour obtenir le début correct du nombre
                // Extraire le nombre de l'expression
                int num = Integer.parseInt(expression.substring(start, index));
                // Calculer le factoriel du nombre
                long factorialResult = factorial(num);
                // Remplacer le nombre et le "!" par le résultat du factoriel dans l'expression
                expression = expression.substring(0, start) + factorialResult + expression.substring(index + 1);
            }

            // Remplacer les fonctions lisibles par les équivalents JavaScript
            expression = expression.replace("sin", "Math.sin");
            expression = expression.replace("cos", "Math.cos");
            expression = expression.replace("tan", "Math.tan");

            // Évaluer l'expression en utilisant le moteur JavaScript
            Object result = engine.eval(expression);

            // Formater le résultat pour éviter les virgules inutiles ou arrondis
            String formattedResult = formatResult(Double.parseDouble(result.toString()));
            view.getDisplayResult().setText(formattedResult);

        } catch (ScriptException | NumberFormatException e) {
            handleError();
        }
    }

    private long factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            long result = 1;
            for (int i = 1; i <= num; i++) {
                result *= i;
            }
            return result;
        }
    }

    private String formatResult(double value) {
        // Supprimer les zéros inutiles et arrondir correctement
        String result = String.format("%.14g", value);
        result = result.replaceAll("\\.?0*$", ""); // Supprimer les zéros et le point s'il est inutile
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private void handleError() {
        view.getDisplayResult().setText("Error"); // Afficher "Error" en cas d'erreur
        isErrorState = true; // Mettre à jour l'état d'erreur
    }
}
