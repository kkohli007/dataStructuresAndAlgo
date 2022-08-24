package src.common;

import src.dto.Employee;
import src.dto.HashedEmployee;

import java.util.ArrayList;
import java.util.LinkedList;

public class CommonUtil {

    public static String printMyArray(int[] unsortedArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int j =0; j < unsortedArray.length; j++)
        {
            sb.append(unsortedArray[j] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static String printMyArray(Integer[] unsortedArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int j =0; j < unsortedArray.length; j++)
        {
            sb.append(unsortedArray[j] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static String printMyArray(String[] unsortedArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int j =0; j < unsortedArray.length; j++)
        {
            sb.append(unsortedArray[j] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void swap(int[] myArray, int i, int j) {
        int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;
    }

    public static void swap(ArrayList<Integer> myList, int i, int j) {
        int temp = myList.get(i);
        myList.set(i, myList.get(j));
        myList.set(j, temp);
    }

    public static String printMyArrayList(ArrayList<Integer> bucket)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i: bucket)
        {
            sb.append(i + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static String printMyArrayListLong(ArrayList<Long> bucket)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (long i: bucket)
        {
            sb.append(i + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static String printMyArray(Employee[] empArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("----Printing my employee array----" + "\n");
        sb.append("{ \n");
        for (int j =0; j < empArray.length; j++)
        {
            sb.append(empArray[j] + "," +"\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n } \n");
        sb.append("----Printing my employee array----");
        return sb.toString();
    }

    public static String printMyArray(HashedEmployee[] empArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("----Printing my employee array----" + "\n");
        sb.append("{ \n");
        for (int j =0; j < empArray.length; j++)
        {
            sb.append((empArray[j]!=null? empArray[j].getEmployee() : null) + "," +"\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n } \n");
        sb.append("----Printing my employee array----");
        return sb.toString();
    }

    public static String printMyArray(LinkedList<HashedEmployee>[] empArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("----Printing my employee array----" + "\n");
        sb.append("{ \n");
        for (int j =0; j < empArray.length; j++)
        {
            sb.append(j + " --> ");
            if(empArray[j] !=null) {
                for (HashedEmployee hashedEmployee : empArray[j]) {
                    sb.append(hashedEmployee.getEmployee() + "-->");
                }
            }
            else
            {
                sb.append("null");
            }
            sb.append("\n");
        }
        sb.append("} \n");
        sb.append("----End Printing my employee array----");
        return sb.toString();
    }

    public static String printMyLinkedList(LinkedList<Employee> employeeList) {

        StringBuilder sb = new StringBuilder();
        sb.append("----Printing my employee list----" + "\n");
        sb.append("{ \n");
        for (int j =0; j < employeeList.size(); j++)
        {
            sb.append(j + " --> ");
            sb.append(employeeList.get(j));
            sb.append("\n");
        }
        sb.append("} \n");
        sb.append("----End Printing my employee list----");
        return sb.toString();
    }
}
