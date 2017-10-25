/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clone;

import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Piotrek
 */
public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;
    
    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }
    
    public Employee clone() throws CloneNotSupportedException
    {
        //Wywołanie metody Object.clone()
        Employee cloned = (Employee)super.clone();
        
        //Klonowanie pól zmienialnych
        cloned.hireDay = (Date) hireDay.clone();
        
        return cloned;
    }
    
    /**
     * Ustawi datę zatrudnienia na podany dzień
     * @param year rok zatrudnienia
     * @param month miesiąc zatrudnienia
     * @param day dzień zatrudnienia
     */
    public void setHireDay(int year, int month, int day)
    {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        //Przykład zmiany pola obiektowego
        hireDay.setTime(newHireDay.getTime());
    }
    
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    
    public String toString()
    {
        return "Employee[name=" + name + ",salary=" + salary + "hireDay=" + hireDay + "]";
    }
}
