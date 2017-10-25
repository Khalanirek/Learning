/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class SetTest {
    public static void main(String[] args)
    {
        Set<String> words = new HashSet<>();    //Klasa HashSet implementuje interfejs Set
        long totalTime = 0;
        
        try (Scanner in = new Scanner(System.in))
        {
            while(in.hasNext())
            {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        /*
        Iterator<String> iter = words.iterator();
        for(int i = 1; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + "niepowtarzających się słów " + totalTime + " milisekund.");
*/
    }
}
