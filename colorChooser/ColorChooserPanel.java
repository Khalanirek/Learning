/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorChooser;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class ColorChooserPanel extends JPanel
{
    public ColorChooserPanel()
    {
        JButton modalButton = new JButton("Modalne");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);
        
        JButton modelessButton = new JButton("Niemodalne");
        modelessButton.addActionListener(new ModelessListener());
        add(modelessButton);
        
        JButton immediateButton = new JButton("Bezpośrednie");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }
    
    private class ModalListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this,
                    "Ustaw kolor tła", defaultColor);
            if (selected != null) setBackground(selected);
        }
    }
    
    private class ModelessListener implements ActionListener
    {
        private JDialog dialog;
        private JColorChooser chooser;
        
        public ModelessListener()
        {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color", 
                    false /*niemodalne*/, chooser,
                    event -> setBackground(chooser.getColor()),
                    null /*brak nasłuchiwacza dla przycisku Anuluj*/);
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
    
    private class ImmediateListener implements ActionListener
    {
        private JDialog dialog;
        private JColorChooser chooser;
        
        public ImmediateListener()
        {
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(
                event -> setBackground(chooser.getColor()));
            
            dialog = new JDialog((Frame) null, false /*niemodalne*/);
            dialog.add(chooser);
            dialog.pack();
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }
    }
}
