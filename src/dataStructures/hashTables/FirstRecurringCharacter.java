package src.dataStructures.hashTables;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        int[] numArray = new int[]{2,5,1,2,3,5,1,2,4};
        printFirstRecurringNumber(numArray);

        numArray = new int[]{2,1,1,2,3,5,1,2,4};
        printFirstRecurringNumber(numArray);

        numArray = new int[]{2,3,4,5};
        printFirstRecurringNumber(numArray);
    }

    private static void printFirstRecurringNumber(int[] numArray) {
        Set<Integer> intSet = new HashSet<>();

        for(int i=0; i<numArray.length;i++)
        {
            if(!intSet.add(numArray[i]))
            {
                System.out.println("First recurring Character:" + numArray[i]);
                return;
            }
        }
        System.out.println("Recurring Character not found");
    }
}
