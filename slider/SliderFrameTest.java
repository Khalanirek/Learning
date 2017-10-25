/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slider;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Piotrek
 */
public class SliderFrameTest {
    /**
     * 
     * @param args
     * @throws MalformedURLException 
     */
    public static void main(String[] args) throws MalformedURLException
    {
        EventQueue.invokeLater(()->
        {
            try {
                JFrame frame = new SliderFrame();
                frame.setTitle("SliderFrameTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            } catch (MalformedURLException ex) {
                Logger.getLogger(SliderFrameTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
