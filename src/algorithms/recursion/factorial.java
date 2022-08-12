package src.algorithms.recursion;

public class factorial {
    public static void main(String[] args) {
        int number = 10;

        int factorial = findFactorialIterative(number);
        System.out.println("Factorial iterative:" + factorial);

        factorial = findFactorialRecursive(number);
        System.out.println("Factorial recursive:" + factorial);
    }

    private static int findFactorialRecursive(int number)
    {
        if(number == 1)
            return 1;
        return number * findFactorialRecursive(number - 1);
    }

    private static int findFactorialIterative(int number)
    {
        int factorial = 1;
        while(number > 0)
        {
            factorial = factorial*number;
            number--;
        }
        return factorial;
    }
}
