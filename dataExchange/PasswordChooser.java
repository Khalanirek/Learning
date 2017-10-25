/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataExchange;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Piotrek
 */
public class PasswordChooser extends JPanel
{
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;
    
    public PasswordChooser()
    {
        setLayout(new BorderLayout());
        
        //Utworzenie panelu z polami nazwy użytkownika i hasła
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("Nazwa użytkownika:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Hasło:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);
        
        //Utworzenie przycisków OK i Anuluj, które zamykają okno dialogowe
        
        okButton = new JButton("OK");
        okButton.addActionListener(event -> {
            ok = true;
            dialog.setVisible(false);
        });
        
        JButton canelButton = new JButton("Anuluj");
        canelButton.addActionListener(event -> dialog.setVisible(false));
        
        //Dodawanie przycisków w pobliżu południowej krawędzi
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(canelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Ustawia wartości domyślne okna dialogowego
     * @param u domyślne informacje użytkownika
     */
    
    public void setUser(User u)
    {
        username.setText(u.getName());
    }
    
    /**
     * Pobiera dane podane w oknie dialogowym
     * @return a oobiekt typu User, którego stan reprezentuje dane wprowadzone w oknie dialogowym
     */
    public User getUser()
    {
        char[] pass = password.getPassword();
        password.setText("");
        return new User(username.getText(), pass);
    }
    
    public boolean showDialog(Component parent, String title)
    {
        ok = false;
        //Lokalizacja ramki nadrzędnej
        
        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
        
        //Jeśli jest to pierwszy raz lub zmienił się użytkownik, utworzenie nowego okna dialogowego
        
        if (dialog == null || dialog.getOwner() != owner)
        {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }
        
        //Ustawienie tytułu i wyświetlenie okna dialogowego
        
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}

class User
{
    private String name;
    private String password;
    
    public User(String name, char[] h)
    {
            this.name = name;
            if (h == null)
                this.password = "";
            else
                this.password = new String(h);
    }
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
}