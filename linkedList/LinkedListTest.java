/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class LinkedListTest {
    public static void main(String[] args)
    {
        List<String> a = new LinkedList<>();
        a.add("Ania");
        a.add("Karol");
        a.add("Eryk");
        
        List<String> b = new LinkedList<>();
        b.add("Bartek");
        b.add("Daniel");
        b.add("Franek");
        b.add("Gosia");
        
        //Scalanie list a i b
        
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while(bIter.hasNext())
        {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        
        System.out.println(a);
        
        //Usunięcie co drugiego słowa z listy b
        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();   //Opuszczenie jednego elementu
            if (bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        
        System.out.println(b);
        
        //Usunięcie wszystkich słów znajdujących się w liście b z listy a
        
        a.removeAll(b);
        
        System.out.println(a);

    }
}
