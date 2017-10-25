/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konstruktor;

/**
 *
 * @author Piotrek
 */
public class ConstructorTest
{
    public static void main(String[] args)
    {
        //Wstawienie do tablic staff trzech obiektów klasy Employee
        Employee[] staff = new Employee[3];
    
        staff[0] = new Employee("Hubert", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();
        
        //Wydruk informacji o wszystkich obiektach klasy Employee
        for(Employee e : staff)
            System.out.println("name = " + e.getName() + ", id = " + e.getId() + ", salary = " + e.getSalary());
    }
}
