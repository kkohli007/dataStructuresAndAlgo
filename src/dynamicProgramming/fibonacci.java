package src.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class fibonacci {

    public static Map<Integer, Integer> fibonacciMap = new HashMap<>();

    public static int calculations = 0;

    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21,34,55...
        int index = 10;

        int Fibonacci = findFibonacciRecursive(index);
        System.out.println("Fibonacci recursive:" + Fibonacci + " Calculations:" + calculations);
        calculations = 0;

        Fibonacci = findFibonacciDoubleRecursive(index);
        System.out.println("Fibonacci double recursive:" + Fibonacci + " Calculations:" + calculations);
        calculations = 0;

        fibonacciMap.put(0, 0);
        fibonacciMap.put(1, 1);

        Fibonacci = findFibonacciDP(index);
        System.out.println("Fibonacci dynamic programming:" + Fibonacci + " Calculations:" + calculations);
    }

    // O(2ˆn)
    private static int findFibonacciDoubleRecursive(int index)
    {
        calculations++;
        if(index == 0)
            return 0;
        else if(index == 1 || index == 2)
            return 1;
        else
            return findFibonacciDoubleRecursive(index-1) + findFibonacciDoubleRecursive(index-2);
    }

    // less calls but not best compared to iterative, but not best
    private static int findFibonacciDP(int index)
    {
        calculations++;
        if(fibonacciMap.containsKey(index))
            return fibonacciMap.get(index);
        else
        {
            int fib = findFibonacciDP(index-1) + findFibonacciDP(index-2);
            fibonacciMap.put(index, fib);
            return fib;
        }
    }

    // O (n)
    private static int findFibonacciRecursive(int index)
    {
        calculations++;
        if(index == 0)
            return 0;
        else if(index <= 2)
            return 1;
        else
            return findFibonacciRecursive(1, 1, --index);
    }

    private static int findFibonacciRecursive(int num1, int num2, int index)
    {
        calculations++;
        if(index <= 2)
            return num1+num2;

        return findFibonacciRecursive(num2, num1+num2, --index);
    }

    /*
    O(logn) using this formula
    If n is even then k = n/2:
        F(n) = [2*F(k-1) + F(k)]*F(k)

        If n is odd then k = (n + 1)/2
        F(n) = F(k)*F(k) + F(k-1)*F(k-1)


     O(1) using Binet’s Formula for the Nth Fibonacci
     It involves the usage of our golden section number Phi.
    Phi = ( sqrt(5) + 1 ) / 2
    Using approximation equation is good enough here,
    since we know N >= 0 && N <= 30, we can safely use the following rounded function
    Fib(N) = round( ( Phi^N ) / sqrt(5) )
     */

}
