/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Piotrek
 */
public class SliderFrame extends JFrame{
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;
    /**
     * 
     * @throws MalformedURLException 
     */
    public SliderFrame() throws MalformedURLException
    {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        
        //Wspólny nasłuchiwacz wszystkich suwaków
        listener = event -> {
            //Aktualizacja pola tekstowego w odpowiedzi na zmianę wartości suwaka
            JSlider source = (JSlider) event.getSource();
            textField.setText("" + source.getValue());
        };
        
        //Zwykły suwak
        
        JSlider slider = new JSlider();
        addSlider(slider, "Zwykły");
        
        //Suwak z podziałką
        
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Podziałka");
        
        //Suwak z dosuwanie gałki do najbliższej kreski
        
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Dosuwany");
        
        //Suwak bez prowadnicy
        
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider, "Bez prowadnicy");
        
        //Suwak o odwróconym działaniu
        
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Odwrócony");
        
        //Suwak z etykietami liczbowymi
        
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Etykiety");
        
        //Suwak z etykietami literowymi
        
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        
        Dictionary<Integer, Component> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("A"));
        labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));
        
        slider.setLabelTable(labelTable);
        addSlider(slider, "Niestandardowe etykiety");
        
        //Suwak z etykietami ikonowymi
        
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);
        
        labelTable = new Hashtable<Integer, Component>();
        
        //Dodawanie obrazów kart
        
        labelTable.put(0, new JLabel(new ImageIcon(new URL("file:///C:/Users/Piotrek/Desktop/MTG/Bia%C5%82y.jpg"))));
        labelTable.put(20, new JLabel(new ImageIcon(new URL("file:///C:/Users/Piotrek/Desktop/MTG/Bia%C5%82y.jpg"))));
        labelTable.put(40, new JLabel(new ImageIcon(new URL("file:///C:/Users/Piotrek/Desktop/MTG/Bia%C5%82y.jpg"))));
        labelTable.put(60, new JLabel(new ImageIcon(new URL("file:///C:/Users/Piotrek/Desktop/MTG/Bia%C5%82y.jpg"))));
        labelTable.put(80, new JLabel(new ImageIcon(new URL("file:///C:/Users/Piotrek/Desktop/MTG/Bia%C5%82y.jpg"))));
        labelTable.put(100, new JLabel(new ImageIcon(new URL("file:///C:/Users/Piotrek/Desktop/MTG/Bia%C5%82y.jpg"))));
        
        slider.setLabelTable(labelTable);
        addSlider(slider, "Ikony");
        
        //Dodawanie pola tekstowego, które wyświetla wartość ustawioną na suwaku
        
        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }
    
    public void addSlider(JSlider s, String description)
    {
        s.addChangeListener(listener);
        JPanel panel = new JPanel();
        panel.add(s);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel, gbc);
    }
}
