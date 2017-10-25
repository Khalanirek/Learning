/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konstruktor;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class Employee {
    private static int nextID;
    
    private int id;
    private String name = "";
    private double salary;
    
    //Statyczny blok inicjujący
    static
    {
        Random generator = new Random();
        //Ustawienie zmiennej nextID na losową liczbę całkowitą z przedziału 0-9999
        nextID = generator.nextInt(10000);
    }
    //Blok inicjujący obiektów
    {
        id = nextID;
        nextID++;
    }        
    //Trzy konstruktory przeciążone - overloading
    public Employee(String n, double s)
    {
        name = n;
        salary = s;
    }
    
    public Employee(double s)
    {
        //Wywołanie konstruktora(String, double)
        this("Employee #" + nextID, s);
    }
    
    //Konstruktor domyślny
    public Employee()
    {
        //Zmienna name zainicjalizowana wartością "" - patrz niżej
        //Zmienna salary nie jest jawnie ustawiona - inicjalizacja wartością 0
        //Zmienna id jest inicjalizowana w bloku inicjującym
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public double getSalary()
    {
        return this.salary;
    }
    
    public int getId()
    {
        return this.id;
    }
}
