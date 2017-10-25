/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracClasses;

/**
 *
 * @author Piotrek
 */
public class PersonTest {
    public static void main(String[] args)
    {
    Person[] people = new Person[2];
    
    //Wstawienie do tablicy people obiektów Student i Employee
    people[0] = new Employee("Henryk Kwiatek", 50000, 1989, 10, 1);
    people[1] = new Student("Maria Mrozowska", "informatyka");
    
    //Drukowanie imion i nazwisk oraz opisów wszystkich obiektów Person
    for(Person p : people)
        System.out.println(p.getName() + ". " + p.getDescription());
    }
}
