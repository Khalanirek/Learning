/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radioButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Piotrek
 */
public class RadioButtonFrame extends JFrame
{
    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    
    private static final int DEFAULT_SIZE = 36;
    
    public RadioButtonFrame()
    {
        //Dodanie przykładowej etykiety tekstowej
        
        label = new JLabel("Koń i zółw grali w kości z piękną ćmą u źródła.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);
        
        //Dodanie przełaczników
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        
        addRadioButton("Mała", 8);
        addRadioButton("Średnia", 12);
        addRadioButton("Duża", 18);
        addRadioButton("Bardzo duża", 36);
        
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }
    
    /**
     * Tworzy przełącznik ustawiający rozmiar czcionki przykładowego tekstu.
     * @param name łańcuch identyfikujący przełacznik
     * @param size rozmiar czcionki ustawiany przez ten przełącznik
     */
    public void addRadioButton(String name, final int size)
    {
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);
        
        //Ten nasłuchiwacz ustawia rozmiar czcionki etykiety
        
        ActionListener listener = event -> label.setFont(new Font("Serif", Font.PLAIN, size));
        button.addActionListener(listener);
    }
}
