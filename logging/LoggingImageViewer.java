/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;
    
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
/**
 *
 * @author Piotrek
 */
public class LoggingImageViewer {
    public static void main(String[] args)
    {
        if(System.getProperty("java.util.logging.config.class") == null && System.getProperty("java.util.logging.config.file") == null)
        {
            try
            {
                Logger.getLogger("com.horstman.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewr.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.horstman.corejava").addHandler(handler);
            }
            catch(IOException e)
            {
                Logger.getLogger("com.horstman.corejava").log(Level.SEVERE, "Nie można utworzyć obiektu obsługi pliku dziennika", e);
            }
        }
        
        EventQueue.invokeLater(() ->
        {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.horstman.corejava").addHandler(windowHandler);
            
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("loggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Logger.getLogger("com.horstmann.corejava").fine("Wyświetlanie ramki");
            frame.setVisible(true);
        });
    }
}

/**
 * ramka zawierająca obraz
 */

class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    
    private JLabel label;
    private static Logger logger = Logger.getLogger("com.horstmann.corejava");
    
    public ImageViewerFrame()
    {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //Pasek menu
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);
        
        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());
        
        JMenuItem exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        
        exitItem.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        logger.fine("Zamykanie");
                        System.exit(0);
                    }
                });
        
        //Etykieta
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }
    
    private class FileOpenListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);
            
            //Okno wyboru plików
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            
            //Akceptiowanie wszystkich plików z rozszerzeniem .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
                    {
                        public boolean accept(File f)
                        {
                            return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                        }
    
                        public String getDescription()
                        {
                            return "Obrazy GIF";
                        }
                    });
            
            //Wyświetlanie okna dialogowego wyboru plików
            int r = chooser.showOpenDialog(ImageViewerFrame.this);
            
            //Jeśli plik obrazu został zaakceptowany, jest on ustawiany jako ikona etykiety
            if(r == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Wczytywanie pliku {0}", name);
                label.setIcon(new ImageIcon(name));
            }
            else logger.fine("Anulowano okno otwierania pliku.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actinPerformed");
        }
    }
}

/**
 * Klasa obsługi wyświetlania rekordów dziennika w oknie
 */

class WindowHandler extends StreamHandler
{
    private JFrame frame;
    
    public WindowHandler()
    {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream()
            {
                    public void write(int b)
                    {
                    }//nie jest wywoływana
                    
                    public void write(byte[] b, int off, int len)
                    {
                        output.append(new String(b, off, len));
                    }
            });
    }
    
    public void publish(LogRecord record)
    {
        if(!frame.isVisible()) return;
        super.publish((record));
        flush();
    }
}