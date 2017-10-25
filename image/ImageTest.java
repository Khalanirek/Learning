/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Piotrek
 */
public class ImageTest 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Ramka zawierająca komponent obrazu
 */
class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        add(new ImageComponent());
        pack();
    }
}

/**
 * Komponent wyświetlający powielony obraz
 */
class ImageComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Image image;

    public ImageComponent()
{
    image = new ImageIcon("blue-ball.gif").getImage();
}

    public void paintComponent(Graphics g)
    {
        if (image == null) return;
        
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        
        //Rysowanie obrazu w lewym górnym rogu.
        g.drawImage(image, 0, 0, null);
        
        //Powielenie obrazu w obrębie komponentu.
        for (int i = 0; i * imageWidth <= getWidth(); i++)
            for (int j = 0; j * imageHeight <= getHeight(); i++)
                if (i + j > 0) g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth,  j * imageHeight);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}