/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracClasses;

import java.time.*;
/**
 *
 * @author Piotrek
 */
public class Employee extends Person {
    private double salary;
    private LocalDate hireDay;
    
    public Employee(String name, double salary, int year, int month, int day)
    {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public LocalDate getHireDay()
    {
        return hireDay;
    }
    
    public String getDescription()
    {
        return String.format("Pracownik zarabiający %.2f zł", salary);
    }
    
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary =+ raise;
    }
}
