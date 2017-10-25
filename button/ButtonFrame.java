/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Piotrek
 */
/**
 * Ramka z panelem zawierającym przyciski
 * @author Piotrek
 */
public class ButtonFrame extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public ButtonFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //Tworzenie przycisków
        JButton yellowButton = new JButton("Żółty");
        JButton blueButton = new JButton("Niebieski");
        JButton redButton = new JButton("Czerwony");
        
        buttonPanel = new JPanel();
        
        //Dodanie przycisków do panelu
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        
        //Dodanie panelu do ramki
       add(buttonPanel);
        
        //Utworzenie akcji przycisków
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.blue);
        ColorAction redAction = new ColorAction(Color.red);
        
        //Powiązanie akcji z przyciskami
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }
    
    /**
     * Nasłuchiwacz akcji ustawiający kolor tła panelu
     */
    private class ColorAction implements ActionListener
    {
        private Color backgroundColor;
        
        public ColorAction(Color c)
        {
            backgroundColor = c;
        }
        
        public void actionPerformed(ActionEvent event)
        {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}
