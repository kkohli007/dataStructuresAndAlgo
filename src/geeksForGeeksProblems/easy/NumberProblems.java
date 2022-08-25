package src.geeksForGeeksProblems.easy;

import java.math.BigInteger;

public class NumberProblems {
    public static void main(String[] args) {

        // check if N is power of 2
        System.out.println("98 Is Power of 2:" + isPowerofTwo(32));
        System.out.println("98 Is Power of 2:" + isPowerofTwoOptimized(24));
        System.out.println("98 Is Power of 2:" + isPowerofTwoOptimized2(0));

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


}
