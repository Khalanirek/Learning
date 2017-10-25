/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sizedFrame;

import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;
/**
 *
 * @author Piotrek
 */
public class SizedFrameTest 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SizedFrame extends JFrame
{
    public SizedFrame()
    {
        //Sprawdzenie wymiarów ekranu
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        //Ustawienie szerokości i wysokości ramki oraz polecenie systemowi, aby ustalił jej położenie
        
        setSize(screenWidth/ 2, screenHeight / 2);
        setLocationByPlatform(true);
        
        //Ustawienie ikony.
        
        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}