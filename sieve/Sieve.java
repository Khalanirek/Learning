/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieve;

import java.util.*;
/**
 *
 * @author Piotrek
 */
public class Sieve {
    public static void main(String[] args)
    {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i;
        for(i = 2; i <= n; i++)
            b.set(i);
        i = 2;
        while(i * i <= n)
        {
            if (b.get(i))
            {
                count++;
                int k = 2 * i;
                while (k <= n)
                {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n)
        {
            if(b.get(i)) count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " liczb pierwszych");
        System.out.println((end - start) + "milisekund");
    }
}
