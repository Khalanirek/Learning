/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionDialog;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Piotrek
 */
public class OptionDialogFrameTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame = new OptionDialogFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("OptionDialogFrameTest");
            frame.setVisible(true);
        });
    }
}
