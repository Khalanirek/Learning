/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;
import java.time.*;
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
        this.hireDay = LocalDate.of(year, month, day);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public double getSalary()
    {
        return this.salary;
    }
    
    public LocalDate getHireDay()
    {
        return this.hireDay;
    }
    
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
