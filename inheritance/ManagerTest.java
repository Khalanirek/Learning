/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Piotrek
 */
public class ManagerTest {
  
    public static void main(String[] args)
    {
        //Tworzenie obiektu klasy Manager
        Manager boss = new Manager("Karol Parol", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        Employee[] staff = new Employee[3];
        
        //Wstawienie obiektów klas Manager i Employee do tablicy staff
        
        staff[0] = boss;
        staff[1] = new Employee("Henryk Kwiatek", 50000, 1989, 10, 1);
        staff[2] = new Employee("Artur Kwiatkowski", 40000, 1990, 3, 15);
        
        //Wyświetlanie informacji o wszystkich obiektach klasy Employee
        for(Employee e : staff)
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
    }
}
