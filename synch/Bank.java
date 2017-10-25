/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Piotrek
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;
    
    /**
     * Tworzy bank
     * @param n liczba kont
     * @param initialBalance saldopoczątkowe na każdym koncie 
     */
    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill((accounts), initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }
    
    /**
     * Przelewa pieniądze pomiędzy kontami
     * @param from konto, z którego ma nastąpić przelew
     * @param to konto, na które ma nastąpić przelew
     * @param amount kwota do przelania
     * @throws InterruptedException 
     */
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();
        try
        {
            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f z %d na %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Saldo ogólne: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }
        finally
        {
            sufficientFunds.signalAll();
            bankLock.unlock();
        }
    }
    
    /**
     * Zwraca sumę sald wszystkich kont
     * @return saldo ogólne
     */
    public double getTotalBalance()
    {
        bankLock.lock();
        try
        {
            double sum = 0;
            
            for (double a : accounts)
                sum += a;
            
            return sum;
        }
        finally
        {
            bankLock.unlock();
        }
    }
    
    /**
     * Zwraca liczbę kont w banku
     * @return liczba kont
     */
    public int size()
    {
        return accounts.length;
    }
}
