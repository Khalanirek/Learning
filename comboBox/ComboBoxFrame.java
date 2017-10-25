/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comboBox;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class ComboBoxFrame extends JFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;
    
    public ComboBoxFrame()
    {
        //Dodanie tekstu etykiety
        
        label = new JLabel("Koń i pies grali w kości z piękną ćmą u źródła");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);
        
        //Tworzenie listy rozwijalnej i dodawanie nazw czcionek
        
        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SensSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");
        
        //Nasłuchiwacz listy rozwijalnej zmienia krój pisma etykiety na czcionkę wybraną przez użytkownika
        
        faceCombo.addActionListener(event -> 
            label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
            Font.PLAIN, DEFAULT_SIZE)));
        
        //Dodanie listy rozwijalnej do panelu znajdującego się przy południowej krawędzi ramki
        
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
        
    }
}
