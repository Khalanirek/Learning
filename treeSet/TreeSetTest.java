/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeSet;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class TreeSetTest {
    public static void main(String[] args)
    {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toster", 1234));
        parts.add(new Item("Wihajster", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);
   
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
