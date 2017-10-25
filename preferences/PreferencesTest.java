/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preferences;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Piotrek
 */
public class PreferencesTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            PreferencesFrame frame = new PreferencesFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Ramka pobierająca dane dotyczące położenia i rozmiaru preferencji użytkownika oraz aktualizująca
 * preferencje w momencie zamykania programu
 * @author Piotrek
 */
class PreferencesFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Preferences root = Preferences.userRoot();
    private Preferences node = root.node("/com/horstmann/corejava");
    
    public PreferencesFrame()
    {
        //Sprawdzenie położenia, rozmiaru i tytułu w preferencjach
        
        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("height", DEFAULT_HEIGHT);
        setBounds(left, top, width, height);
        
        //Jeśli nie ma tytułu, użytkownik zostanie poproszony o jego podanie
        
        String title = node.get("title", "");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Podaj tytuł ramki:");
        if (title == null) title ="";
        setTitle(title);
        
        //Utworzenie okna wyboru plików wyświetlającego pliki XML
        
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileFilter(new FileNameExtensionFilter("Pliki XML", "xml"));
        
        //Utworzenie menu
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);
        
        JMenuItem exportItem = new JMenuItem("Eksportuj preferencje");
        menu.add(exportItem);
        exportItem.addActionListener(event -> {
            if (chooser.showSaveDialog(PreferencesFrame.this) ==
                    JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    savePreferences();
                    OutputStream out = new FileOutputStream(chooser.getSelectedFile());
                    node.exportSubtree(out);
                    out.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        JMenuItem importItem = new JMenuItem("Importuj preferencje");
        menu.add(importItem);
        importItem.addActionListener(event -> 
        {
            if (chooser.showOpenDialog(PreferencesFrame.this) ==
                    JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    InputStream in = new FileInputStream(chooser.getSelectedFile());
                    Preferences.importPreferences(in);
                    in.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void savePreferences()
    {
        node.put("left", "" + getX());
        node.put("top", "" + getY());
        node.put("width", "" + getWidth());
        node.put("height", "" + getHeight());
        node.put("title", getTitle());
    }
}