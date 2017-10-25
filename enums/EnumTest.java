/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class EnumTest {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj rozmiar: SMALL, MEDIUM, LARGE, EXTRA_LARGE");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("rozmiar=" + size);
        System.out.println("Skrót=" + size.getAbbreviation());
        if(size == Size.EXTRA_LARGE)
            System.out.println("Dobra robota -- nie pominąłeś znaku podkreślnienia _");
    }
}

enum Size
{
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    
    private Size(String abbreviation) {this.abbreviation = abbreviation;}
    public String getAbbreviation(){return abbreviation;}

private String abbreviation;
}