/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class OptionDialogFrame extends JFrame
{
    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;
    private String messageString = "Komunikat";
    private Icon messageIcon = new ImageIcon("blue-ball.gif");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();
    
    public OptionDialogFrame()
    {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2,3));
        
        //W tym miejscu są tworzone przełączniki
        typePanel = new ButtonPanel("Typ", "Komunikat", "Potwierdzenie", "Opcja", "Dane wejściowe");
        messageTypePanel = new ButtonPanel("Typ komunikatu", "ERROR_MESSAGE",
            "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLANIN_MESSAGE");
        messagePanel = new ButtonPanel("Komunikat", "Łańcuch", "Ikona", "Komponent", "Inny", "Object[]");
        optionTypePanel = new ButtonPanel("Potwierdzenie", "DEFAULT_OPTION", "YES_NO_OPTION",
            "YES_NO_CANEL_OPTION", "OK_CANEL_OPTION");
        optionsPanel = new ButtonPanel("Opcja", "String[]", "Icon[]", "Object[]");
        inputPanel = new ButtonPanel("Dane wejściowe", "Pole tekstowe", "Pole kombi");
        
        //Tutaj dodawane są przełączniki do panelu
        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);
        
        //Dodanie panelu z przyciskiem Pokaż
        
        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Pokaż");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);
        
        //Dodanie do frame panelu z przełącznikami w center, oraz dodanie przycisku pokaż South
        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
    }
    
    /**
     * Pobiera aktualnie wybrany komunikat
     * @return 
     */
    public Object getMessage()
    {
        String s = messagePanel.getSelection();
        if (s.equals("Łańcuch")) return messageString;
        else if (s.equals("Ikona")) return messageIcon;
        else if (s.equals("Komponent")) return messageComponent;
        else if (s.equals("Object[]")) return new Object[] { messageString, messageIcon, messageComponent, messageObject};
        else if (s.equals("Inny")) return messageObject;
        else return null;
    }
    
    /**
     * Pobiera aktualnie wybrane opcje
     * @return 
     */
    public Object[] getOptions()
    {
        String s = optionsPanel.getSelection();
        if (s.equals("String[]")) return new String[] {"Żółty", "Niebieski",
            "Czerwony"};
        else if (s.equals("Icon[]")) return new Icon[] {new ImageIcon ("ellow-ball.gif"),
            new ImageIcon("blue-ball.gif"), new ImageIcon("red-ball.gif") };
        else if (s.equals("Object[]")) return new Object[] {messageString, messageIcon, messageComponent, messageObject};
        else return null;       
    }

    /**
     * Pobiera wybrany komunikat lub typ opcji;
     * @param panel
     * @return 
     */
    public int getType(ButtonPanel panel)
    {
        String s = panel.getSelection();
        try
        {
            return JOptionPane.class.getField(s).getInt(null);
        }
        catch (Exception e)
        {
            return -1;
        }
    }
    
    private class ShowAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (typePanel.getSelection().equals("Potwierdzenie"))
                JOptionPane.showConfirmDialog(
                OptionDialogFrame.this, getMessage(), "Tytuł",
                        getType(optionTypePanel),
                        getType(messageTypePanel));
            else if (typePanel.getSelection().equals("Dane wejściowe"))
            {
                if (inputPanel.getSelection().equals("Pole tekstowe"))
                    JOptionPane.showInputDialog(
                    OptionDialogFrame.this, getMessage(), "Tytuł",
                            getType(messageTypePanel));
                else JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Tytuł", 
                        getType(messageTypePanel), null, new String[] {"Zółty",
                            "Niebieski", "Czerwony"}, "Niebieski");
            }
            else if ( typePanel.getSelection().equals("Komunikat"))
                JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(), "Tytuł",
                        getType(messageTypePanel));
            else if ( typePanel.getSelection().equals("Opcja"))
                JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "Tytuł", getType(optionTypePanel),
                        getType(messageTypePanel), null, getOptions(), getOptions()[0]);
        }
    }
}

class SampleComponent extends JComponent
{
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
        g2.setPaint(Color.YELLOW);
        g2.fill(rect);
        g2.setPaint(Color.BLUE);
        g2.draw(rect);
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(10, 10);
    }
}
