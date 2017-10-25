/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import java.awt.EventQueue;
import button.ButtonFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Piotrek
 */
public class MouseTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
