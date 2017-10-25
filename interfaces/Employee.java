/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Piotrek
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    
    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    /**
     * Porównuje pracowników według wysokości pensji.
     * @param other inny obiekt klasy Employee
     * @return wartość ujemna, jeśli pracownik ma niższą pensję niż inny (other) pracownik,
     * 0, jeśli pensje są równe, w przecwinym razie liczba dodatnia
     */
    public int compareTo(Employee other)
    {
        return Double.compare(salary, other.salary);
    }
}
