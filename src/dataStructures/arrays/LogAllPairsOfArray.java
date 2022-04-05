package src.dataStructures.arrays;

public class LogAllPairsOfArray {

    private static int[] myArray = {1,2,3,4,5};

    public static void main(String[] args) {

        for(int i=0; i<myArray.length; i++)
        {
            for(int j=0; j< myArray.length; j++)
            {
                System.out.println("Print pair: {" + myArray[i] + "," + myArray[j] +"}");
            }
        }
    }

    // nˆ2 complexity
}
