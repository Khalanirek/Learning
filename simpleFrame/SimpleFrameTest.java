/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleFrame;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Piotrek
 */
public class SimpleFrameTest 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
           SimpleFrame frame = new SimpleFrame();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    
    public SimpleFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}