package src.algorithms.recursion;

public class fibonacci {
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21,34,55...
        int index = 47;

        int Fibonacci = findFibonacciIterative(index);
        System.out.println("Fibonacci iterative:" + Fibonacci);

        Fibonacci = findFibonacciRecursive(index);
        System.out.println("Fibonacci recursive:" + Fibonacci);
    }

    private static int findFibonacciRecursive(int index)
    {
        if(index == 0)
            return 0;
        else if(index <= 2)
            return 1;
        else
            return findFibonacciRecursive(1, 1, --index);
    }

    private static int findFibonacciRecursive(int num1, int num2, int index)
    {
        if(index <= 2)
            return num1+num2;

        return findFibonacciRecursive(num2, num1+num2, --index);
    }

    private static int findFibonacciIterative(int index)
    {
        if(index < 2)
            return index;

        int num1 = 1;
        int num2 = 1;

        int nextFibonacciNumber = 0;
        while(index > 2)
        {
            nextFibonacciNumber = num1+num2;
            num1 = num2;
            num2 = nextFibonacciNumber;
            index --;
        }

        return nextFibonacciNumber;
    }
}
