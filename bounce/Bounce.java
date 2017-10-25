/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounce;

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
public class Bounce 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static  final int DELAY = 1;
    
    public BounceFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Piłka");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Zamknij", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
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
        try
        {
            Ball ball = new Ball();
            comp.add(ball);
            
            for (int i = 1; i <= STEPS; i++)
            {
                ball.move(comp.getBounds());
                comp.paintComponent(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }
            catch (InterruptedException e)
            {
                    
            }
    }
}
