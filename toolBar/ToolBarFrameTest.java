/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolBar;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Piotrek
 */
public class ToolBarFrameTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame = new ToolBarFrame();
            frame.setTitle("ToolBraFrameTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
