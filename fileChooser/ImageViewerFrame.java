/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileChooser;

import java.io.File;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Piotrek
 */
public class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;
    
    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //Pasek menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);
        
        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            chooser.setCurrentDirectory(new File("."));
        
            //Okno wyboru plików
            int result = chooser.showOpenDialog(ImageViewerFrame.this);
            //Jeśli plik obrazu zostanie zaakceptowany, ustaw go jako ikonę etykiety
            if (result == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
                System.out.println(name);
                pack();
            }
        });
        
        JMenuItem exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
        
        //Etykieta do wyświetlania obrazów
        label = new JLabel();
        add(label);
        
        //Utworzenie akcesorium wyboru plików
        chooser = new JFileChooser();
        
        //Akceptuje wszystkie pliki obrazów z rozszerzeniem .jpg, .jpeg, .gif
        
        FileFilter filter = new FileNameExtensionFilter(
            "Image files", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);
        chooser.setAccessory(new ImagePreviewer(chooser));
        //Rozpoczyna poszukiwania od katalogu aplikacji, w widows niezbedne jest uzywanie \\ zamiast \
        chooser.setFileView(new FileIconView(filter, new ImageIcon("Images\\Biały.jpg")));

    }
}
