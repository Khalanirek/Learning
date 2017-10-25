/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import button.ButtonFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Piotrek
 */
public class CalculatorTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new JFrame();
            frame.setSize(500, 500);
            frame.setTitle("CalculatorTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new CalculatorPanel();
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
