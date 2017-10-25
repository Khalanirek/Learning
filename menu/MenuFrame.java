/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Piotrek
 */
public class MenuFrame extends JFrame 
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;        
    private JCheckBoxMenuItem readonlyItem;
    private JPopupMenu popup;
    
    class TestAction extends AbstractAction
    {
        public TestAction(String name)
        {
            super(name);
        }
        
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Wybrano " + getValue(Action.NAME));
        }
    }
    
    public MenuFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        JMenu fileMenu = new JMenu("Plik");
        fileMenu.add(new TestAction("Nowy"));
        
        //Akceleratory
        
        JMenuItem openItem = fileMenu.add(new TestAction("Otwórz"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        
        fileMenu.addSeparator();
        
        saveAction = new TestAction("Zapisz");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        
        saveAsAction = new TestAction("Zapisz jako");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();
        
        fileMenu.add(new AbstractAction("Zakończ")
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        System.exit(0);
                    }
                });
        
        //Menu z polem wyboru i przełącznikami
        
        readonlyItem = new JCheckBoxMenuItem("Tylko do odczytu");
        readonlyItem.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
               boolean saveOk = !readonlyItem.isSelected();
               saveAction.setEnabled(saveOk);
               saveAsAction.setEnabled(saveOk);
           }
        });
        
        ButtonGroup group = new ButtonGroup();
        
        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Wstawianie");
        insertItem.setSelected(true);
        JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Nadpisywanie");
        
        group.add(insertItem);
        group.add(overtypeItem);
        
        //Ikony
        
        Action cutAction = new TestAction("Wytnij");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
        Action copyAction = new TestAction("Kopiuj");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
        Action pasteAction = new TestAction("Wklej");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
        
        JMenu editMenu = new JMenu("Edycja");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        
        //Zagnieżdżone menu
        
        JMenu optionMenu = new JMenu("Opcje");
        
        optionMenu.add(readonlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overtypeItem);
        
        editMenu.addSeparator();
        editMenu.add(optionMenu);
        
        //Mnemoniki
        
        JMenu helpMenu = new JMenu("Pomoc");
        helpMenu.setMnemonic('P');
        
        JMenuItem indexItem = new JMenuItem("Indeks");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);
        
        //Mnemoniki można także dodawać do akcji
        Action aboutAction = new TestAction("O programie");
        aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('O'));
        helpMenu.add(aboutAction);
        
        //Dodanie wszystkich menu najwyższego rzędu do paska menu
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        
        //Menu kontekstowe
        
        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);
        
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
    }
}
