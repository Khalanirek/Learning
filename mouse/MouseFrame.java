/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse;

import javax.swing.*;

/**
 *
 * @author Piotrek
 */
public class MouseFrame extends JFrame{
    public MouseFrame()
    {
        add(new MouseComponent());
        pack();
    }
}
