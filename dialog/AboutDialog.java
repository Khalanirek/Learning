/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class AboutDialog extends JDialog
{
    public AboutDialog(JFrame owner)
    {
        super(owner, "Test okna O programie", true);
        
        //Dodanie etykiety HTML
        
        add(
            new JLabel(
                "<html><h1>Core Java</i></h1><hr> By Cay Horstmann</html>"),
            BorderLayout.CENTER);
        
        //Przycisk OK zamyka okno
        
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));
        
        //Dodanie przycisku OK przy krawędzi południowej
        
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}
