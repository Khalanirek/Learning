/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerClass;

import javax.swing.*;


/**
 *
 * @author Piotrek
 */
public class InnerClassTest {
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();
        
        //Niech program działa, dopóki użytkownik nie wciśnie przycisku OK.
        JOptionPane.showMessageDialog(null, "Zamknąć program");
        System.exit(0);
    }
}
