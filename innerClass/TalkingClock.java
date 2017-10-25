/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
/**
 *
 * @author Piotrek
 */
public class TalkingClock {
    private int interval;
    private boolean beep;
    
    /**
     * Tworzy obiekt TalkingClock
     * @param interval odstęp czasu pomiędzy kolejnymi komunikatami (w milisekundach)
     * @param beep wartość true oznacza, że dźwięk ma być odtworzony
     */
    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }
    
    /**
     * Włączanie zegara
     */
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
    
    private class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Kiedy usłyszysz dźwięk, będzie godzina " + new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
