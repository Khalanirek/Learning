/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class CheckBoxFrame extends JFrame 
{
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 25;
    
    public CheckBoxFrame()
    {
        //dodanie przykładowej etykiety
        label = new JLabel("Koń i zółw grali w kości z piękną ćmą u źródła.");
        label.setFont(new Font("Serfi", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);
        
        //nasłuchiwacz ustawiający atrybuty czcionki
        //etykiety zgodnie z ustawieniami pól wyboru
        
        ActionListener listener = event -> {
            int mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };
        
        //dodanie pól wyboru
        
        JPanel buttonPanel = new JPanel();
        
        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);
        
        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);
        
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
