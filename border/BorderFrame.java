/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package border;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author Piotrek
 */
public class BorderFrame extends JFrame{
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;
    
    public BorderFrame()
    {
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        
        addRadioButton("LoweredBevel", BorderFactory.createLoweredBevelBorder());
        addRadioButton("RaisedBevel", BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched", BorderFactory.createEtchedBorder());
        addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
        
        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Rodzaje obramowań");
        buttonPanel.setBorder(titled);
        
        setLayout(new GridLayout(2, 1));
        add(buttonPanel);
        add(demoPanel);
        pack();
    }
    
    public void addRadioButton(String buttonName, Border b)
    {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(event -> demoPanel.setBorder(b));
        group.add(button);
        buttonPanel.add(button);
    }
}
