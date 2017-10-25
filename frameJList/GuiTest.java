/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameJList;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Piotr Turliński
 */
public class GuiTest 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame = new Gui();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
