/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionDialog;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Piotrek
 */
class ButtonPanel extends JPanel
{
    private ButtonGroup group;
    
    /**
     * Tworzy panel przycisków
     * @param title Tytuł wyświetlany w obramowaniu
     * @param options Tablica etykiet przełączników
     */
    public ButtonPanel(String title, String... options)
    {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();
        
        //Utworzenie po jednym przełączniku dla każdej opcji
        for (String option : options)
        {
            JRadioButton b = new JRadioButton(option);
            b.setActionCommand(option);
            add(b);
            group.add(b);
            b.setSelected(option == options[0]);
        }
    }
    
    /**
     * Pobiera aktualnie wybraną opcję
     * @return Zwraca etykietę aktualnie wybranego przełącznika
     */
    public String getSelection()
    {
        return group.getSelection().getActionCommand();
    }
}
