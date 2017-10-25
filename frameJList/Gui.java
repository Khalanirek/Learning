/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameJList;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Piotr Turliński
 */
public class Gui extends JFrame{
    private JList list ;
    private static String[] liczby = {"Jeden", "Dwa", "Trzy", "Cztery", "Pięć", "Sześć", "Siedem", "Osiem", "Dziewięć", "Dziesięć"};
    
    public Gui()
    {
        super("Liczby");
        list = new JList(liczby);
        setSize(400,400);
        setLayout(new BorderLayout());
        JPanel listPanel1 = new JPanel();
        JPanel listPanel2 = new JPanel();
        JPanel listPanel3 = new JPanel();
        JPanel listPanel4 = new JPanel();
        JPanel listPanel5 = new JPanel();
        
        add(listPanel1,BorderLayout.NORTH);
        add(listPanel2,BorderLayout.EAST);
        add(listPanel3,BorderLayout.WEST);
        add(listPanel4,BorderLayout.SOUTH);
        add(listPanel5,BorderLayout.CENTER);
        
        listPanel1.setBackground(Color.red);
        listPanel2.setBackground(Color.yellow);
        listPanel3.setBackground(Color.blue);
        listPanel4.setBackground(Color.black);
        listPanel5.setBackground(Color.white);
        listPanel5.add(new JScrollPane(list));
        list.setPreferredSize(new Dimension(500,500));
        //listPanel1.add(list);

    }
}
