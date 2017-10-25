/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Piotrek
 */
public class SwingThreadTest 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SwingThreadFrame();
            frame.setTitle("SwingThreadTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SwingThreadFrame extends JFrame
{
    public SwingThreadFrame()
    {
        final JComboBox<Integer> combo = new JComboBox<>();
        combo.insertItemAt(Integer.MAX_VALUE, 0);
        combo.setPrototypeDisplayValue(combo.getItemAt(0));
        combo.setSelectedIndex(0);
        
        JPanel panel = new JPanel();
        
        JButton goodButton = new JButton("Dobry");
        goodButton.addActionListener(event -> new Thread(new GoodWorkerRunnable(combo)).start());
        panel.add(goodButton);
        
        JButton badButton = new JButton("Zły");
        badButton.addActionListener(event -> new Thread(new BadWorkerRunnable(combo)).start());
        panel.add(badButton);
        
        panel.add(combo);
        add(panel);
        pack();
    }
}

/**
 * Klasa modyfikująca listę rozwijalną przez dodanie do niej i usunięcie z niej losowych liczb. Może to
 * spowodować błędy, ponieważ metody listy rozwijalnej nie są synchronizowane, przez co wątek roboczy
 * i wątek dystrybucji zdarzeń uzyskują dostęp do tej listy
 * @author Piotrek
 */
class BadWorkerRunnable implements Runnable
{
    private JComboBox<Integer> combo;
    private Random generator;
    
    public BadWorkerRunnable(JComboBox<Integer> aCombo)
    {
        combo = aCombo;
        generator = new Random();
    }
    
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0)
                    combo.insertItemAt(i, 0);
                else if (combo.getItemCount() > 0)
                    combo.removeItemAt(i % combo.getItemCount());
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e)
        {
        }
    }
}

/**
 * Klasa modyfikująca listę rozwijaną przez dodanie do niej i usunięcie z niej losowych liczb.
 * Aby uniknąć uszkodzenia tej listy, operacje edycji są przesyłane do wątku dystrybucji zdarzeń.
 * @author Piotrek
 */
class GoodWorkerRunnable implements Runnable
{
    private JComboBox<Integer> combo;
    private Random generator;
    
    public GoodWorkerRunnable(JComboBox<Integer> aCombo)
    {
        combo = aCombo;
        generator = new Random();
    }
    
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                EventQueue.invokeLater(() ->
                {
                    int i = Math.abs(generator.nextInt());
                    if (i % 2 == 0)
                        combo.insertItemAt(i, 0);
                    else if (combo.getItemCount() > 0)
                        combo.removeItemAt(i % combo.getItemCount());
                });
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e)
        {
        }
    }
}
