/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Piotrek
 */
public class PropertiesTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            PropertiesFrame frame = new PropertiesFrame();
            frame.setVisible(true);
        });
    }
}

class PropertiesFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    private File propertiesFile;
    private Properties settings;
    
    public PropertiesFrame()
    {
        //Pobranie informacji o położeniu, rozmiarze i tytule z pliku własności
        
        String userDir = System.getProperty("user.home");
        File propertiesDir = new File(userDir, ".corejava");
        if (!propertiesDir.exists()) propertiesDir.mkdir();
        propertiesFile = new File(propertiesDir, "program.properties");
        
        Properties defaultSettings = new Properties();
        defaultSettings.put("left", "0");
        defaultSettings.put("top", "0");
        defaultSettings.put("width", "" + DEFAULT_WIDTH);
        defaultSettings.put("height", "" + DEFAULT_HEIGHT);
        defaultSettings.put("title", "");
        
        settings = new Properties(defaultSettings);
        
        if (propertiesFile.exists())
            try (InputStream in = new FileInputStream(propertiesFile))
            {
                settings.load(in);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        
        int left = Integer.parseInt(settings.getProperty("left"));
        int top = Integer.parseInt(settings.getProperty("top"));
        int width = Integer.parseInt(settings.getProperty("width"));
        int height = Integer.parseInt(settings.getProperty("height"));
        setBounds(left, top, width, height);
        
        //Jeśli nie ma tytułu, użytkownik zostanie poproszony o jego podanie
        
        String title = settings.getProperty("title");
        
        if (title.equals("")) title = JOptionPane.showInputDialog("Wpisz tytuł ramki:");
        if (title == null) title = "";
        setTitle(title);
        
        addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent event){
                    settings.put("left", "" + getX());
                    settings.put("top", "" + getY());
                    settings.put("width", "" + getWidth());
                    settings.put("height", "" + getHeight());
                    settings.put("title", getTitle());
                    
                    try (OutputStream out = new FileOutputStream(propertiesFile))
                    {
                        settings.store(out, "Program Properties");
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                    }
                });
    }
}
