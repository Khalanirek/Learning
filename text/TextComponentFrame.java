/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

/**
 *
 * @author Piotrek
 */
public class TextComponentFrame extends JFrame{
    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;
    
    public TextComponentFrame()
    {
        final JTextField textField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("Nazwa użytkownika: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Hasło: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        
        
        add(northPanel, BorderLayout.NORTH);
        
        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        add(scrollPane, BorderLayout.CENTER);
        //Dodanie przycisku wstawiającego tekst do obszaru tekstowego
        
        JPanel southPanel = new JPanel();
        JButton insertButton = new JButton("Wstaw");
        southPanel.add(insertButton);
        insertButton.addActionListener(event -> textArea.append("Nazwa użytkownika: "
                + textField.getText() + " Hasło: " + new String(passwordField.getPassword()) + "\n"));
        add(southPanel, BorderLayout.SOUTH);
        pack();
    }
}
