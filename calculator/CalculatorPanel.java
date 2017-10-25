/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Piotrek
 */
public class CalculatorPanel extends JPanel {
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    
    public CalculatorPanel()
    {
        //Ustawia zarządcę rozkładu dla tego kontenera, znajduje się w JPanel
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        
        //Dodanie wyświetlacza
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        
        //Wstawienie przycisków na siatkę 4x4
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);
        
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);
        
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);
        
        add(panel, BorderLayout.CENTER);
    }
    
    /**
     * Dodaje przycisk do panelu centralnego
     * @param label etykieta przycisku
     * @param listener nasłuchiwacz przycisków
     */
    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    /**
     * Ta akcja wstawia łańcuch akcji przycisku na końcu tekstu do wyświetlenia.
     */
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //metoda zwraca łańcuch opisujący event, w tym przypadku jest to Label przycisku
            String input = event.getActionCommand();
            if (start)
            {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }
    /**
     * Ta akcja wykonuje polecenia określone przez akcję przycisku.
     */
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if (start)
            {
                if (command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
        
        public void calculate(double x)
        {
            if (lastCommand.equals("+")) result += x;
            else if (lastCommand.equals("-")) result -= x;
            else if (lastCommand.equals("*")) result *= x;
            else if (lastCommand.equals("/")) result /= x;
            else if (lastCommand.equals("=")) result = x;
            display.setText("" + result);
        }
    }
}
