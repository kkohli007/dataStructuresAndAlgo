package src.geeksForGeeksProblems.easy;

import java.math.BigInteger;
import java.util.Stack;

public class NumberProblems {
    public static void main(String[] args) {

        // check if N is power of 2
        System.out.println("98 Is Power of 2:" + isPowerofTwo(32));
        System.out.println("98 Is Power of 2:" + isPowerofTwoOptimized(24));
        System.out.println("98 Is Power of 2:" + isPowerofTwoOptimized2(0));

        System.out.println("Is this number prime:" + isPrime(49));

        System.out.println("Convert five:" + convertfive(1004));

        System.out.println("Count bits flip:" + countBitsFlip(10,20));
        System.out.println("Count bits flip:" + countBitsFlipOptimized(10,20));
        System.out.println("Count bits flip:" + FlippedCount(10,10));
    }

    // Function that count set bits
    public static int countSetBits(int n)
    {
        int count = 0;
        while (n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }

    // Function that return count of
    // flipped number
    public static int FlippedCount(int a, int b)
    {
        // Return count of set bits in
        // a XOR b
        return countSetBits(a ^ b);
    }

    //O(logN), but space 1
    public static int countBitsFlipOptimized(int a, int b){
        // Your code here
        int counter = 0;
        while(a!=0 || b!=0)
        {
            if(a==0)
            {
                if(b%2!=0)
                    counter++;
                b=b/2;
            }
            else if(b==0)
            {
                if(a%2!=0)
                    counter++;
                a=a/2;
            }
            else
            {
                if(a%2!=b%2)
                    counter++;
                a=a/2;
                b=b/2;
            }
        }
        return counter;
    }

    //O(logN), but space also O(logn)
    public static int countBitsFlip(int a, int b){
        // Your code here
        Stack<Integer> aStack = new Stack();
        Stack<Integer> bStack = new Stack();

        while(a!=0)
        {
            aStack.push(a%2);
            a=a/2;
        }
        while(b!=0)
        {
            bStack.push(b%2);
            b=b/2;
        }

        while(aStack.size()<bStack.size())
            aStack.push(0);

        while(bStack.size()<aStack.size())
            bStack.push(0);

        int counter=0;
        while (!aStack.isEmpty() && !bStack.isEmpty())
        {
            if(aStack.pop()!=bStack.pop())
                counter++;
        }
        return counter;
    }


    //O(log n)
    public static boolean isPowerofTwo(long n){

        double d = (double) n;
        while(d>1 && d%1 == 0)
            d = d/2;

        if(d==1)
            return true;
        else
            return false;
        // Your code here
    }

    //O(1)
    // log (a) b = log (e) b / log (e) a
    // log (2) N = log (e) N / log (e) 2
    public static boolean isPowerofTwoOptimized(long n){
        return (Math.ceil((int) (Math.log(n) / Math.log(2)))) ==
                (Math.floor((int) ((Math.log(n) / Math.log(2)))));
        // Your code here
    }

    public static boolean isPowerofTwoOptimized2(long n){
        return n>0 && (n & n-1)==0;

        // Your code here
    }

    static int isPrime(int N){
        // code here
        if(N==2 || N==3)
            return 1;

        if(N<=1 || N%2==0 || N%3==0)
            return 0;

        for(int i=5; i<=Math.sqrt(N); i=i+6)
        {
            if(N%i==0 || N%(i+2)==0)
                return 0;
        }
        return 1;
    }

    static int convertfive(int num) {
        // Your code here
        int numNew = 0;
        int multiplier = 1;
        while(num>0)
        {
            if(num % 10==0)
                numNew = numNew + 5*multiplier;
            else
                numNew = numNew + (num%10)*multiplier;
            num = num/10;
            multiplier = multiplier*10;
        }
        return numNew;
    }
}
