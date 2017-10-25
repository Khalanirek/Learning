/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class MapTest {
    public static void main(String[] args)
    {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Anna Kowalska"));
        staff.put("567-25-5464", new Employee("Henryk Kwiatek"));
        staff.put("157-62-7935", new Employee("Marcin Nowak"));
        staff.put("456-25-5464", new Employee("Franciszek Frankowski"));
        
        //Wydruk wszystkich pozycji
        System.out.println(staff);
        
        //Usunięcie wartości
        staff.remove("567-25-5464");
        System.out.println(staff);
        //Podmienienie pozycji
        staff.put("456-25-5464", new Employee("Weronika Kowalska"));
        System.out.println(staff);
        //Wyszukiwanie wartości
        System.out.println(staff.get("157-62-7935"));
        
        //Iteracja przez wszystkie pozycje
        staff.forEach((k,v) -> System.out.println("Klucz=" + k + ", wartość=" + v));
    }
}

class Employee
{
    private String name;
    public Employee(String name)
    {
        this.name = name;
    }
    
}