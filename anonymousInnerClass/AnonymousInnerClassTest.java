/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author Piotrek
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);
        
        //Niech program działa, dopóki użykownik nie wciśnie przycisku OK.
        JOptionPane.showMessageDialog(null, "Zamknąć program");
        System.exit(0);
    }
}

/**
 * Zegar drukujący informacje o czasie w równych odstępach czasu.
 */
class TalkingClock
{
    public void start(int interval, boolean beep)
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.out.println("Kiedy usłyszysz dźwięk, będzie godzina " + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}