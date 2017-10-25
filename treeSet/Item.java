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
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;
    
    /**
     * Tworzy element
     * 
     * @param aDescription
     *          opis elementu
     * @param aPartNumber 
     *          numer części elementu
     */
    public Item(String aDescription, int aPartNumber)
    {
        this.description = aDescription;
        this.partNumber = aPartNumber;
    }
    
    /**
     * Pobiera opis elementu
     * 
     * @return opis 
     */
    public String getDescription()
    {
        return description;
    }
    
    public String toString()
    {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }
    
    public boolean equals(Object otherObject)
    {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass())return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }
    
    public int hashCode()
    {
        return Objects.hash(description, partNumber);
    }
    
    public int compareTo(Item other)
    {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
