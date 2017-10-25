/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Piotrek
 */
public class ResourceTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ResourceTestFrame();
            frame.setTitle("ResourceTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Ramka ładująca zasoby graficzne i tekstowe
 */
class ResourceTestFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    
    public ResourceTestFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //Trzeba wpisac pelna sciezke, nie tylko Biały.jpg, musi byc file:///
        //URL aboutURL = getClass().getResource("file:///D:/JAVA/Programy/PierwszaAplikacja/Images/Bia%C5%82y.jpg");
        Image img = new ImageIcon("Biały.jpg").getImage();
        setIconImage(img);
        
        JTextArea textArea = new JTextArea();
        InputStream stream = getClass().getResourceAsStream("about.txt");
   
        try (Scanner in = new Scanner(stream, "UTF-8"))
        {
            while (in.hasNext())
                textArea.append(in.nextLine() + "\n");
        }
        add(textArea);

    }
}