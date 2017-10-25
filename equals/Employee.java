/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equals;

import java.time.*;
import java.util.Objects;
/**
 *
 * @author Piotrek
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;
    
    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public LocalDate getHireDay()
    {
        return hireDay;
    }
    
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    
    public boolean equals(Object otherObject)
    {
        //Spprawdzenie, czy obiekty są identyczne
        if(this == otherObject) return true;
        
        //Musi zwrocic false, jesli jawny parametr jest null
        if(otherObject == null) return false;
        
        //Jesli klasy nie zgadzją się, nie mogą być jednakowe
        if(this.getClass() != otherObject.getClass()) return false;
        
        //Teraz wiadomo, że otherObject jest typu Employee i nie jest null
        Employee other = (Employee) otherObject;
        
        //Sprawdzenie, czy pola mają identyczne wartości
        return Objects.equals(this.name, other.name);// && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }
    
    public int hashCode()
    {
        return Objects.hash(name, salary, hireDay);
    }
    
    public String toString()
    {
        return getClass().getName() + "[name=" + name + ".salary=" + salary + ".hireDay=" + hireDay +"]";
    }
}
