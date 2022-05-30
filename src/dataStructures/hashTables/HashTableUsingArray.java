package src.dataStructures.hashTables;

import src.common.CommonUtil;
import src.dto.Employee;

class TestHashTableUsingArray
{
    public static void main(String[] args) {

        HashTableUsingArray hashTable = new HashTableUsingArray();
        Employee employee1 = new Employee("Virat", "Kohli", 32);
        hashTable.put(employee1.getLastName(), employee1);
        Employee employee2 = new Employee("Dinesh", "Karthik", 35);
        hashTable.put(employee2.getLastName(), employee2);
        Employee employee3 = new Employee("Wanindu", "Hasarangaa", 26);
        hashTable.put(employee3.getLastName(), employee3);
        Employee employee4 = new Employee("Harshal", "Pateel", 29);
        hashTable.put(employee4.getLastName(), employee4);
        hashTable.display();

        System.out.println(hashTable.get("Karthik"));
    }

}

public class HashTableUsingArray
{
    Employee[] myArray = null;

    int defaultSize = 10;

    public HashTableUsingArray()
    {
        myArray = new Employee[defaultSize];
    }

    public void put(String key, Employee employee)
    {
        int position = hashFunction(key);
        if(myArray[position]!=null)
            myArray[position] = employee;
        else
            System.out.println("Sorry employee already exists at this position");
    }

    public Employee get(String key)
    {
        int position = hashFunction(key);
        return myArray[position];
    }

    private int hashFunction(String key) {
        return key.length() % myArray.length;
    }

    public void display(){
        System.out.println(CommonUtil.printMyArray(myArray));

    }
}
