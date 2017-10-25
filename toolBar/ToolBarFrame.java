/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Piotrek
 */
public class ToolBarFrame extends JFrame 
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;
    
    public ToolBarFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //panel do zmieniania kolorów
        
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        
        //akcje
        
        Action blueAction = new ColorAction("Niebieski", new ImageIcon("blue-ball.gif"), Color.BLUE);
        Action yellowAction = new ColorAction("Zółty", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action redAction = new ColorAction("Czerwony", new ImageIcon("red-ball.gif"), Color.RED);
        
        Action exitAction = new AbstractAction("Zamknij", new ImageIcon("exit.gif"))
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Zamknij");
        
        //dodanie elementów do paska narzędzi
        
        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.addSeparator();
        bar.add(exitAction);
        add(bar, BorderLayout.NORTH);
        
        //dodanie elementów do menu
        
        JMenu menu = new JMenu("Kolor");
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    
    class ColorAction extends AbstractAction
    {
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + " background");
            putValue("Color", c);
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }
    }
}
