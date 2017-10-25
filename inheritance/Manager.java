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
public class Manager extends Employee{
    
    private double bonus;
    
    /**
     * 
     * @param n imię i nazwisko pracownika
     * @param s pensja
     * @param year rok przyjęcia do pracy
     * @param month miesiac przyjecia do pracy
     * @param day dzien przyjecia do pracy
     */
    public Manager(String n, double s, int year, int month, int day)
    {
        //Wywołanie konstruktora nadklasy
        super(n, s, year, month, day);
        this.bonus = 0;
    }
    
    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    
    public void setBonus(double b)
    {
        this.bonus = b;
    }
}
