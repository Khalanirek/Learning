/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author Piotrek
 */
public class DrawTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Ramka zawierająca okienko z rysunkami
 */

class DrawFrame extends JFrame
{
    public DrawFrame()
    {
        add(new DrawComponent());
        pack();
    }
}

/**
 * Komponent wyświetlający prostokąty i elipsy.
 */

class DrawComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGTH = 400;
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        //Rysowanie prostokąta
        
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double heigth = 150;
        
        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, heigth);
        g2.draw(rect);
        
        //Rysowanie elipsy
        
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);
        
        //Rysowanie przekątnej
        
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + heigth));
        
        //Rysowanie koła z takim samym środkiem
        
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;
        
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGTH);
    }
}