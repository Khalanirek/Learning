/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataExchange;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Piotrek
 */
public class DataExchangeFrame extends JFrame
{
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;
    
    public DataExchangeFrame()
    {
        //Tworzenie menu Plik
        
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu fileMenu = new JMenu("Plik");
        mbar.add(fileMenu);
        
        //Tworzenie elementów menu Połącz i Zamknij
        
        JMenuItem connectItem = new JMenuItem("Połącz");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);
        
        //Opcja Zamknij zamyka program
        
        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
        
        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        pack();
    }
    
    private class ConnectAction implements ActionListener
    {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                //Jeśli jest to pierwszt raz tworzy okno dialogowe
                
                if (dialog == null) dialog = new PasswordChooser();
                
                //Ustawienie wartości domyślnych
                 dialog.setUser(new User("Twoja nazwa", null));
                
                //Wyświetlenie okna dialogowego
                if (dialog.showDialog(DataExchangeFrame.this, "Połącz"))
                {
                    //Pobranie danych uzytkowanika w przypadku zatwierdzenia
                    User u = dialog.getUser();
                    textArea.append("nazwa użytkownika = " + u.getName() + ", hasło = "
                        + (new String(u.getPassword())) + "\n");
                }
            }
    }
}
