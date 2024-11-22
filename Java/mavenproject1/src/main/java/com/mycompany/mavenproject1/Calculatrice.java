/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Set;

/**
 *
 * @author t-0
 */
public class Calculatrice extends javax.swing.JFrame {

    /**
     * Creates new form Calculatrice
     */
    private double result = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;
    private boolean enter = false;
    
    public Calculatrice() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        buttonSub = new javax.swing.JButton();
        buttonMult = new javax.swing.JButton();
        buttonDiv = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonEnter = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonModulo = new javax.swing.JButton();
        displayResult = new javax.swing.JTextField();
        button0 = new javax.swing.JButton();
        buttonSCIENCE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(jPanel1.getPreferredSize());

        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        button7.setText("7");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.setText("8");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setText("9");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button4.setText("4");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setText("5");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setText("6");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button1.setText("1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setText("3");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        buttonSub.setText("-");
        buttonSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubActionPerformed(evt);
            }
        });

        buttonMult.setText("x");
        buttonMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMultActionPerformed(evt);
            }
        });

        buttonDiv.setText("/");
        buttonDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDivActionPerformed(evt);
            }
        });

        buttonAdd.setText("+");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonEnter.setText("enter");
        buttonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterActionPerformed(evt);
            }
        });

        buttonClear.setText("AC");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonModulo.setText("mod");
        buttonModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModuloActionPerformed(evt);
            }
        });

        displayResult.setEditable(false);
        displayResult.setText("0");
        displayResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayResultActionPerformed(evt);
            }
        });

        button0.setText("0");
        button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0ActionPerformed(evt);
            }
        });

        buttonSCIENCE.setText("SCIENCE");
        buttonSCIENCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSCIENCEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayResult)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(buttonAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSub))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonDiv)
                                    .addComponent(buttonMult))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSCIENCE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonModulo)
                            .addComponent(buttonClear)
                            .addComponent(buttonAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button7)
                            .addComponent(button8)
                            .addComponent(button9)
                            .addComponent(buttonSub))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button4)
                            .addComponent(button5)
                            .addComponent(button6)
                            .addComponent(buttonMult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2)
                            .addComponent(button3)
                            .addComponent(buttonDiv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonEnter)
                            .addComponent(button0)))
                    .addComponent(buttonSCIENCE, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button0ActionPerformed
        if (enter){
            displayResult.setText("0");
        }
        else{
            appendNumber("0");  
        }

        enter=false;
    }//GEN-LAST:event_button0ActionPerformed

    private void buttonModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModuloActionPerformed
        setOperator("%");
    }//GEN-LAST:event_buttonModuloActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        displayResult.setText("0");        
        result=0;
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnterActionPerformed
        double number = Double.parseDouble(displayResult.getText());
        switch (operator) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "x":
                result = result*number;
                break;
            case "/":
                if (number != 0) {
                    result /= number;
                } else {
                    displayResult.setText("Error");
                    return;
                }
                break;
            case "%":
                result = result % number;
                break;
        }
        displayResult.setText(String.valueOf(result));
        operator = "";
        enter=true;
    }//GEN-LAST:event_buttonEnterActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        setOperator("+");
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDivActionPerformed
        setOperator("/");
    }//GEN-LAST:event_buttonDivActionPerformed

    private void buttonMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMultActionPerformed
        setOperator("x");
    }//GEN-LAST:event_buttonMultActionPerformed

    private void buttonSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubActionPerformed
        setOperator("-");
        
    }//GEN-LAST:event_buttonSubActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        if (enter){
            displayResult.setText("3");
        }
        else{
            appendNumber("3");
        }
        
        enter=false;
    }//GEN-LAST:event_button3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
            if (enter){
                   displayResult.setText("2");
        }
            else{
                appendNumber("2");
            }
        
        enter=false;

    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (enter){
                   displayResult.setText("1");
        }
        else{
            appendNumber("1");            
        }

        enter=false;
    }//GEN-LAST:event_button1ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        if (enter){
                   displayResult.setText("6");
        }
        else{
            appendNumber("6");            
        }

        enter=false;
    }//GEN-LAST:event_button6ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        if (enter){
                   displayResult.setText("5");
        }
        else{
            appendNumber("5");
        }
        enter=false;
    }//GEN-LAST:event_button5ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        if (enter){
                   displayResult.setText("4");
        }
        else{
            appendNumber("4");
        }
        enter=false;
    }//GEN-LAST:event_button4ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        if (enter){
                   displayResult.setText("9");
        }
        else{
            appendNumber("9");
        }
        enter=false;
    }//GEN-LAST:event_button9ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        if (enter){
                   displayResult.setText("8");
        }
        else{
            appendNumber("8");
        }
        enter=false;
    }//GEN-LAST:event_button8ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        if (enter){
                   displayResult.setText("7");
        }
        else{
            appendNumber("7");        
        }

        enter=false;
    }//GEN-LAST:event_button7ActionPerformed

    private void displayResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayResultActionPerformed
   
    }//GEN-LAST:event_displayResultActionPerformed

    private void buttonSCIENCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSCIENCEActionPerformed
        jPanel.setVisible();
    }//GEN-LAST:event_buttonSCIENCEActionPerformed

    
    
    private void appendNumber(String number) {
        if (isOperatorClicked) {
            displayResult.setText(number);
            isOperatorClicked = false;
        } else {
            displayResult.setText(displayResult.getText().equals("0") ? number : displayResult.getText() + number);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculatrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculatrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculatrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculatrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculatrice().setVisible(true);
            }
        });
    }
    
    private void setOperator(String operator) {
        result = Double.parseDouble(displayResult.getText());
        this.operator = operator;
        isOperatorClicked = true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDiv;
    private javax.swing.JButton buttonEnter;
    private javax.swing.JButton buttonModulo;
    private javax.swing.JButton buttonMult;
    private javax.swing.JButton buttonSCIENCE;
    private javax.swing.JButton buttonSub;
    private javax.swing.JTextField displayResult;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}