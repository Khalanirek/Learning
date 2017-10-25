/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceThread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class BounceThread {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class BounceFrame extends JFrame
{
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static  final int DELAY = 1;
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    
    /**
     * Tworzy ramkę z komponentem zawierającym piłkę
     * i przyciski Start oraz Zamknij
     */
    public BounceFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Zamknij", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
    
    /**
     * Dodaje przycisk do kontenera
     * @param c kontener
     * @param title tytuł przycisku
     * @param listener nasłuchiwacz akcji przycisku
     */
    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
    
    public void addBall()
    {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = () -> {
        
            try
            {
                for (int i = 1; i <= 20*STEPS; i++)
                {
                    ball.move(comp.getBounds());
                    comp.paintComponent(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            }
                catch (InterruptedException e)
                {
                    
                }
        };
        Thread t = new Thread(r);
        t.start();
    }
}