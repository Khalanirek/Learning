/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorChooser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class ColorChooserPanelTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()-> 
        {
            JFrame frame = new JFrame();
            frame.setTitle("ColorChooserPanelTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            JPanel panel = new ColorChooserPanel();
            frame.setSize(400, 400);
            frame.add(panel);
        });
    }
}
