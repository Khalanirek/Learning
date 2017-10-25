/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
//Powyższy import ma na celu zapobiec konfliktowi z klasą java.util.Timer;

/**
 *
 * @author Piotrek
 */

public class TimerTest {
    public static void main(String[] args){
        ActionListener listener = new TimePrinter();
        
        //Konstrukcja zegara wywołującego obiekt nasłuchujący
        //co dziesięć sekund.
        Timer t = new Timer(10000, listener);
        t.start();
        
        JOptionPane.showMessageDialog(null, "Zamknąć program?");
        System.exit(0);
    }
}
