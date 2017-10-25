/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plaf;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Ramka z panelem zawierającym przyciski zmieniające styl
 * @author Piotrek
 */
public class PlafFrame extends JFrame{
    private JPanel buttonPanel;
    
    public PlafFrame()
    {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());
      
        add(buttonPanel);
        pack();
    }
    
    /**
     * Tworzy przycisk zmieniający styl.
     */
    private void makeButton(String name, String className)
    {
        //Dodanie przycisku do panelu.
        JButton button = new JButton(name);
        buttonPanel.add(button);
        
        //Ustawienie akcji przycisku.
        button.addActionListener(String ->
        {
            try
            {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}
