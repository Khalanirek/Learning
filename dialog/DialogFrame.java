/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Piotrek
 */
public class DialogFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;
    
    public DialogFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //Tworzenie menu Plok
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);
        
        //Tworzenie elementów O programie i Zamknij
        //Element Oprogramie wyświetla okno dialogowe O programie
        
        JMenuItem aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener( event ->
        {
            if (dialog == null) //pierwszy raz
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true);
        });
        
        fileMenu.add(aboutItem);
        
        //Element Zamknij powoduje zamknięcie programu
        
        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }
}
