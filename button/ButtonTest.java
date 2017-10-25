/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package button;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Piotrek
 */
public class ButtonTest {
       public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
