/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridBagLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Piotr Turliński
 */
public class Gui extends JFrame{
    
    
    public Gui()
    {
        super("Gui");
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(gridbag);
        add(mainPanel);
        
        JLabel label1 = new JLabel("Label1");
        JLabel label2 = new JLabel("Label2");
        JLabel label3 = new JLabel("Label3");
        JLabel label4 = new JLabel("Label4");
        JLabel label5 = new JLabel("Label5");
        JLabel label6 = new JLabel("Label6");
        JLabel label7 = new JLabel("Label7");
        JLabel label8 = new JLabel("Label8");
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10,10,10,10);
        mainPanel.add(label1,gc);
        gc.gridx = 0;
        gc.gridy = 1;
        mainPanel.add(label2,gc);
        gc.gridx = 0;
        gc.gridy = 2;
        mainPanel.add(label3,gc);
        gc.gridx = 1;
        gc.gridy = 0;
        mainPanel.add(label4,gc);
        gc.gridx = 1;
        gc.gridy = 1;
        mainPanel.add(label5,gc);
        gc.gridx = 1;
        gc.gridy = 2;
        mainPanel.add(label6,gc);
        gc.gridx = 2;
        gc.gridy = 0;
        mainPanel.add(label7,gc);
        gc.gridx = 2;
        gc.gridy = 1;
        mainPanel.add(label8,gc);
    }
}
