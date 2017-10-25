/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayList;

import java.util.*;

/**
 *
 * @author Piotrek
 */
public class ArrayListTest {
    public static void main(String[] args)
    {
        //Wstawienie do listy staff trzech obiektów klasy Employee
        ArrayList<Employee> staff = new ArrayList<>();
        
        staff.add(new Employee("Karol Krakowski", 75000, 1987, 12, 15));
        staff.add(new Employee("Henryk Kwiatek", 50000, 1989, 10, 1));
        staff.add(new Employee("Waldemar Kowalski", 40000, 1990, 3, 15));
        
        //Zwiekszenie pensji wszystkich pracownikow o 5%
        for(Employee e : staff)
            e.raiseSalary(5);
        
        //Drukowanie informacji o wszystkich obiektach Employee
        for(Employee e : staff)
            System.out.println("name=" + e.getName() + ".salary=" + e.getSalary() + "hireDay=" + e.getHireDay());
    }
}
