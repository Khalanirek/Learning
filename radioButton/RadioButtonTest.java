/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radioButton;

import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 *
 * @author Piotrek
 */
public class RadioButtonTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new RadioButtonFrame();
            frame.setTitle("RadioButtonFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
