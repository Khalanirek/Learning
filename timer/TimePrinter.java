/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.awt.event.*;
import java.util.*;
import java.awt.*;
/**
 *
 * @author Piotrek
 */
public class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Kiedy usłyszysz dźwięk, będzie godzina " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
