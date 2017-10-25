/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileChooser;

import javax.swing.JFrame;

/**
 *
 * @author Piotrek
 */
public class ImageViewerFrameTest {
    public static void main(String[] args)
    {
        JFrame frame = new ImageViewerFrame();
        frame.setTitle("ImageViewerFrameTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
