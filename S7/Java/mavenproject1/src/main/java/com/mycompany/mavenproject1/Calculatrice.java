/**
 * La classe Calculatrice représente une interface graphique pour une calculatrice.
 * Elle utilise Swing pour créer l'interface utilisateur et gère les boutons et l'affichage des résultats.
 * 
 * <p>Cette classe inclut des boutons pour les opérations de base (addition, soustraction, multiplication, division),
 * ainsi que des boutons pour les opérations scientifiques (sinus, cosinus, tangente, factorielle).
 * 
 * <p>Elle utilise un modèle MVC (Modèle-Vue-Contrôleur) pour séparer la logique de calcul (modèle) de l'interface utilisateur (vue).
 * 
 * <p>Les composants principaux incluent :
 * <ul>
 *   <li>Un champ de texte pour afficher les résultats (displayResult)</li>
 *   <li>Un panneau de boutons pour les opérations de base (jPanel1)</li>
 *   <li>Un panneau de boutons pour les opérations scientifiques (scientificPanel)</li>
 * </ul>
 * 
 * <p>La méthode initComponents() initialise tous les composants de l'interface utilisateur et configure leur apparence.
 * 
 * <p>La méthode toggleScientificMode() permet de basculer entre le mode de calcul de base et le mode scientifique.
 * 
 * <p>Les méthodes getButtonX() permettent d'accéder aux différents boutons de l'interface utilisateur.
 * 
 * <p>La méthode main() lance l'application en créant une instance de Calculatrice et en la rendant visible.
 * 
 * @see javax.swing.JFrame
 * @see javax.swing.JButton
 * @see javax.swing.JTextField
 * @see javax.swing.JPanel
 */
package com.mycompany.mavenproject1;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Calculatrice extends javax.swing.JFrame {

    /**
     * Constructeur de la classe Calculatrice.
     * Initialise les composants de l'interface utilisateur et configure le modèle et le contrôleur.
     */
    public Calculatrice() {
        initComponents();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(model, this);
    }

    /**
     * Méthode principale pour lancer l'application.
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Calculatrice().setVisible(true);
        });
    }

    // Méthodes pour accéder aux différents boutons de l'interface utilisateur
    public javax.swing.JButton getButton0() { return button0; }
    public javax.swing.JButton getButton1() { return button1; }
    public javax.swing.JButton getButton2() { return button2; }
    public javax.swing.JButton getButton3() { return button3; }
    public javax.swing.JButton getButton4() { return button4; }
    public javax.swing.JButton getButton5() { return button5; }
    public javax.swing.JButton getButton6() { return button6; }
    public javax.swing.JButton getButton7() { return button7; }
    public javax.swing.JButton getButton8() { return button8; }
    public javax.swing.JButton getButton9() { return button9; }
    public javax.swing.JButton getButtonAdd() { return buttonAdd; }
    public javax.swing.JButton getButtonSub() { return buttonSub; }
    public javax.swing.JButton getButtonMult() { return buttonMult; }
    public javax.swing.JButton getButtonDiv() { return buttonDiv; }
    public javax.swing.JButton getButtonModulo() { return buttonModulo; }
    public javax.swing.JButton getButtonEnter() { return buttonEnter; }
    public javax.swing.JButton getButtonBackspace() { return buttonBackspace; }
    public javax.swing.JButton getButtonClear() { return buttonClear; }
    public javax.swing.JButton getButtonDecimal() { return buttonDecimal; }
    public javax.swing.JTextField getDisplayResult() { return displayResult; }

    public javax.swing.JButton getButtonOpenParen() { return buttonOpenParen; }
    public javax.swing.JButton getButtonCloseParen() { return buttonCloseParen; }

    public javax.swing.JButton getButtonSin() { return buttonSin; }
    public javax.swing.JButton getButtonCos() { return buttonCos; }
    public javax.swing.JButton getButtonTan() { return buttonTan; }
    public javax.swing.JButton getButtonFactorial() { return buttonFactorial; }

    /**
     * Initialise les composants de l'interface utilisateur et configure leur apparence.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        displayResult = new javax.swing.JTextField();
        buttons = new javax.swing.JButton[5][4]; // 5 lignes, 4 colonnes

        String[][] buttonLabels = {
                { "AC", "Supp", "%", "÷" },
                { "7", "8", "9", "×" },
                { "4", "5", "6", "-" },
                { "1", "2", "3", "+" },
                { "Sci", "0", ",", "=" }
        };

        // Colors and layout configurations
        java.awt.Color backgroundColor = java.awt.Color.BLACK;
        java.awt.Color textColor = java.awt.Color.WHITE;
        java.awt.Color numberButtonColor = new java.awt.Color(64, 64, 64);
        java.awt.Color operatorButtonColor = new java.awt.Color(255, 153, 0);
        java.awt.Color scientificButtonColor = new java.awt.Color(48, 48, 48); // Darker gray for scientific buttons

        setLayout(new java.awt.BorderLayout());
        setBackground(backgroundColor);

        displayResult.setEditable(false);
        displayResult.setBackground(backgroundColor);
        displayResult.setForeground(textColor);
        displayResult.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 36));
        displayResult.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        displayResult.setText("0");
        displayResult.setBorder(null);
        add(displayResult, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(5, 4, 5, 5));
        jPanel1.setBackground(backgroundColor);

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new javax.swing.JButton(buttonLabels[row][col]);
                buttons[row][col].setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

                if (row == 0 || col == 3) {
                    buttons[row][col].setBackground(operatorButtonColor);
                    buttons[row][col].setForeground(textColor);
                } else {
                    buttons[row][col].setBackground(numberButtonColor);
                    buttons[row][col].setForeground(textColor);
                }

                buttons[row][col].setBorderPainted(false);
                buttons[row][col].setFocusPainted(false);
                jPanel1.add(buttons[row][col]);
            }
        }

        button0 = buttons[4][1];
        button1 = buttons[3][0];
        button2 = buttons[3][1];
        button3 = buttons[3][2];
        button4 = buttons[2][0];
        button5 = buttons[2][1];
        button6 = buttons[2][2];
        button7 = buttons[1][0];
        button8 = buttons[1][1];
        button9 = buttons[1][2];
        buttonAdd = buttons[3][3];
        buttonSub = buttons[2][3];
        buttonMult = buttons[1][3];
        buttonDiv = buttons[0][3];
        buttonModulo = buttons[0][2];
        buttonEnter = buttons[4][3];
        buttonClear = buttons[0][0];
        buttonBackspace = buttons[0][1];
        buttonDecimal = buttons[4][2];

        // Panneau scientifique
        scientificPanel = new JPanel();
        scientificPanel.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

        JButton sinButton = createScientificButton("sin");
        JButton cosButton = createScientificButton("cos");
        buttonSin = sinButton;
        buttonCos = cosButton;
        buttonTan = createScientificButton("tan");
        buttonFactorial = createScientificButton("!");

        scientificPanel.add(buttonSin);
        scientificPanel.add(buttonCos);
        scientificPanel.add(buttonTan);
        scientificPanel.add(buttonFactorial);

        scientificPanel.add(buttonSin);
        buttonOpenParen = createScientificButton("(");
        buttonCloseParen = createScientificButton(")");
        scientificPanel.add(buttonOpenParen);
        scientificPanel.add(buttonCloseParen);
        scientificPanel.add(buttonFactorial);

        scientificPanel.setBackground(backgroundColor);
        scientificPanel.setVisible(false); // Initialement caché

        // Panneau principal de la calculatrice
        add(jPanel1, java.awt.BorderLayout.CENTER);
        add(scientificPanel, java.awt.BorderLayout.EAST); // Panneau scientifique sur la droite

        // Bouton Sci pour activer le mode scientifique
        buttonSciMode = buttons[4][0];  // Le bouton "Sci" est toujours en position 4,0
        buttonSciMode.addActionListener(e -> toggleScientificMode());

        pack();
    }

    /**
     * Crée un bouton pour les opérations scientifiques avec une apparence spécifique.
     * @param label le texte du bouton
     * @return le bouton configuré
     */
    private JButton createScientificButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        button.setBackground(new java.awt.Color(48, 48, 48)); // Couleur de fond gris foncé
        button.setForeground(java.awt.Color.WHITE); // Couleur du texte
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    /**
     * Bascule la visibilité du panneau scientifique et ajuste la taille de la fenêtre.
     */
    private void toggleScientificMode() {
        // Basculer la visibilité du panneau scientifique
        boolean isVisible = scientificPanel.isVisible();
        scientificPanel.setVisible(!isVisible);

        // Ajuster la taille de la fenêtre pour inclure ou exclure le panneau scientifique
        if (isVisible) {
            setSize(300, 400); // Taille sans le panneau scientifique
        } else {
            setSize(500, 400); // Taille avec le panneau scientifique
        }
    }

    // Déclaration des composants de l'interface utilisateur
    private javax.swing.JButton[][] buttons;
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton buttonOpenParen;
    private javax.swing.JButton buttonCloseParen;
    private javax.swing.JButton buttonSin;
    private javax.swing.JButton buttonCos;
    private javax.swing.JButton buttonTan;
    private javax.swing.JButton buttonFactorial;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDecimal;
    private javax.swing.JButton buttonDiv;
    private javax.swing.JButton buttonEnter;
    private javax.swing.JButton buttonModulo;
    private javax.swing.JButton buttonMult;
    private javax.swing.JButton buttonSub;
    private javax.swing.JButton buttonBackspace;
    private javax.swing.JTextField displayResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel scientificPanel;
    private javax.swing.JButton buttonSciMode;
}
