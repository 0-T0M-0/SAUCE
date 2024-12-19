package view;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class TextField extends JTextField {

	protected TextField() {
		setPreferredSize(new Dimension(100, 100));
        setHorizontalAlignment(JTextField.RIGHT);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '=' || c == '(' || c == ')' || c == KeyEvent.VK_ENTER)) {
                    e.consume();
                }
            }
        });
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
            	requestFocus();
            }
        });
	}
	
	public void addText(String text) {
    	setText(getText() + text);
    }
}

/*
Dans votre cas, vous souhaitez que les actions effectuées en cliquant sur un bouton soient également exécutées lorsque l'utilisateur tape une touche au clavier. Pour cela, vous pouvez lier les actions de vos boutons et celles du clavier de manière cohérente. Voici comment vous pouvez faire cela.

### Solution : Créer une méthode d'action commune

La clé ici est d'avoir une méthode dans votre contrôleur ou dans la classe de la vue qui effectue les actions de manière uniforme, que ce soit via un bouton ou au clavier. Vous pouvez centraliser la logique des actions dans une méthode spécifique et l'appeler à la fois à partir du gestionnaire de clics de boutons et du gestionnaire d'événements de clavier.

Voici comment vous pouvez refactorer et améliorer vos classes pour partager les mêmes actions.

### 1. Refactoriser la classe `Button` :
Dans la classe `Button`, vous avez déjà une logique pour gérer les événements de clic. Vous pouvez lier cette logique avec une méthode qui pourrait être appelée par les deux événements (clic sur bouton et frappe au clavier).

Modifions la classe `Button` pour déléguer l'action à une méthode commune qui sera aussi utilisée par le `TextField`.

```java
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.CalculatorController;

public class Button extends JButton {

    private int action;
    private TextField textField;
    private CalculatorController controller;

    public Button(int action, String label, TextField textField, CalculatorController controller) {
        this.action = action;
        this.textField = textField;
        this.controller = controller;

        setText(label);
        setBounds(50, 50, 50, 50);

        // ActionListener pour les boutons
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction();
            }
        });
    }

    // Méthode qui effectue l'action commune pour les boutons et le clavier
    private void performAction() {
        System.out.println("Button pressed: " + getText());
        if (controller.getError()) {
            textField.setText("");
            controller.errorFalse();
        }
        executeAction(getText());
    }

    // Méthode qui est aussi appelée pour les événements clavier
    public void executeAction(String actionText) {
        switch (action) {
            case 0: // chiffre
            case 1: // opérateur
            case 5: // (
            case 6: // )
                textField.addText(actionText);
                break;
            case 2: // =
                controller.calculateResult();
                break;
            case 3: // C
                controller.clearCalculator();
                break;
            case 4: // scientifique
                // Afficher le panneau scientifique
                break;
        }
    }

    public int getActionValue() { 
        return this.action; 
    }
}
```

### 2. Modifier la classe `TextField` pour gérer le clavier :
Dans la classe `TextField`, vous pouvez appeler cette méthode `executeAction` lorsque l'utilisateur tape une touche sur le clavier, afin que le comportement des touches soit le même que celui des boutons.

Modifions votre classe `TextField` en conséquence :

```java
package view;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class TextField extends JTextField {

    private CalculatorController controller;

    public TextField(CalculatorController controller) {
        this.controller = controller;
        
        setPreferredSize(new Dimension(100, 100));
        setHorizontalAlignment(JTextField.RIGHT);

        // Écouteur de touches pour gérer les entrées clavier
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || 
                      c == '+' || c == '-' || c == '*' || c == '/' || 
                      c == '%' || c == '=' || c == '(' || c == ')' || 
                      c == KeyEvent.VK_ENTER)) {
                    e.consume(); // Ignore les touches invalides
                } else {
                    handleKeyInput(c);
                }
            }
        });

        // Garde le focus à chaque fois qu'on quitte ce champ
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                requestFocus(); // Maintenir le focus sur le TextField
            }
        });
    }

    // Méthode pour gérer les entrées clavier, qui appelle la méthode de logique commune
    private void handleKeyInput(char keyChar) {
        String input = String.valueOf(keyChar);
        
        // Gestion spécifique pour certaines touches (ex: entrée = =)
        if (keyChar == KeyEvent.VK_ENTER) {
            input = "=";  // '=' pour la touche Entrée
        }
        
        // Appeler la méthode qui gère les actions communes
        Button button = new Button(getActionForInput(input), input, this, controller);
        button.executeAction(input);
    }

    // Mappage entre les touches du clavier et les actions
    private int getActionForInput(String input) {
        switch (input) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 1;
            case "/": return 1;
            case "=": return 2;
            case "C": return 3;
            case "(": return 5;
            case ")": return 6;
            default:
                if (Character.isDigit(input.charAt(0))) {
                    return 0; // Si c'est un chiffre
                }
                return -1; // Action non valide
        }
    }

    // Ajoute du texte dans le TextField
    public void addText(String text) {
        setText(getText() + text);
    }
}
```

### Explication des changements :
1. **Centralisation des actions :** Dans la classe `Button`, j'ai créé une méthode `executeAction` qui effectue les mêmes actions que celles que vous faisiez dans `performAction`. Cette méthode est appelée aussi bien par le gestionnaire de clics des boutons que par le gestionnaire des événements clavier.
   
2. **Gestion du clavier :** La classe `TextField` gère maintenant l'entrée au clavier. Lorsqu'une touche est pressée, elle vérifie si c'est une touche valide (chiffre, opérateur, etc.) et appelle la méthode `executeAction` de la classe `Button`.

3. **Réutilisation de la logique :** Cela permet de réutiliser la même logique d'action, que ce soit par un bouton ou par une touche du clavier, sans dupliquer de code.

### Résultat :
Lorsque vous appuyez sur un bouton ou une touche du clavier, la même action sera effectuée. Cela vous permet d'avoir une gestion unifiée des interactions pour votre calculatrice.
*/
