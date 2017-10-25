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
public class Student extends Person {
    private String major;
    
    /**
     * 
     * @param name imie i nazwisko studenta
     * @param major specjalizacja studenta
     */
    public Student(String name, String major)
    {
        //Przekazanie n do konstruktora nadklasy
        super(name);
        this.major = major;
    }
    
    public String getDescription()
    {
        return "Student specjalizacji " + major;
    }
}
