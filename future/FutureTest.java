/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *
 * @author Piotrek
 */
public class FutureTest 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj katalog bazowy (np. /opt/jdk1.8.0/src): ");
        String directory = in.nextLine();
        System.out.print("Podaj słowo kluczowe (np. volatile): ");
        String keyword = in.nextLine();
        
        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread t = new Thread(task);
        t.start();
        try
        {
            System.out.println("Liczba znalezionych plików " + task.get() + ".");
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
        }
    }
}

/**
 * Zadanie liczące pliki znajdujące się w katalogu i jego podkatalogah, zawierające dane słowo kluczowe
 * @author Piotrek
 */
class MatchCounter implements Callable<Integer>
{
    private File directory;
    private String keyword;
    
    public MatchCounter(File directory, String keyword)
    {
        this.directory = directory;
        this.keyword = keyword;
    }
    
    @Override
    public Integer call()
    {
        int count = 0;
        try
        {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            
            for (File file : files)
            {
                if( file.isDirectory())
                {
                    MatchCounter counter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }
                else
                {
                    if (search(file)) count++;
                }
            }
            for (Future<Integer> result : results)
            {
                try
                {
                    count += result.get();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException e)
        {
        }
        return count;
    }
    
    /**
     * Przeszukuje plik w celu znalezienia danego słowa kluczowego
     * @param file plik do przeszukania
     * @return true, jeśli plik zawiera dane słowo kluczowe
     */
    public boolean search(File file)
    {
        try
        {
            try (Scanner in = new Scanner(file))
            {
                boolean found = false;
                while (!found && in.hasNextLine())
                {
                    String line = in.nextLine();
                    if (line.contains(keyword)) found = true;
                }
                return found;
            }
        }
        catch (IOException e)
                {
                    return false;
                }
    }
}
