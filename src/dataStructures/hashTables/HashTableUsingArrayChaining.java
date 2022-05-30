package src.dataStructures.hashTables;

import src.common.CommonUtil;
import src.dto.Employee;
import src.dto.HashedEmployee;

import java.util.Iterator;
import java.util.LinkedList;

// Using chaining for collision
// maintain linked list for each array position
class TestHashTableUsingArrayChaining
{
    public static void main(String[] args) {
        HashTableUsingArrayChaining hashTable = new HashTableUsingArrayChaining();
        Employee employee1 = new Employee("Virat", "Kohli", 32);
        hashTable.put(employee1.getLastName(), employee1);
        Employee employee2 = new Employee("Dinesh", "Karthik", 35);
        hashTable.put(employee2.getLastName(), employee2);
        Employee employee3 = new Employee("Wanindu", "Hasaranga", 26);
        hashTable.put(employee3.getLastName(), employee3);
        Employee employee4 = new Employee("Rajat", "Patidaar", 29);
        hashTable.put(employee4.getLastName(), employee4);
        hashTable.display();

        System.out.println(hashTable.get("Karthik"));
        Employee employee5 = new Employee("Harshal", "Patel", 32);
        hashTable.put(employee5.getLastName(), employee5);

        Employee employee6 = new Employee("Josh", "Hazelwood", 34);
        hashTable.put(employee6.getLastName(), employee6);

        hashTable.display();
        System.out.println(hashTable.get("Kohli"));
        System.out.println(hashTable.get("Patel"));
        System.out.println(hashTable.get("Hasaranga"));
        System.out.println(hashTable.get("Hazelwood"));

        hashTable.remove("Kohli");
        hashTable.display();

        System.out.println(hashTable.get("Kohli"));
        System.out.println(hashTable.get("Patel"));
    }
}

public class HashTableUsingArrayChaining
{
    LinkedList<HashedEmployee>[] myArray;

    int defaultSize = 10;

    public HashTableUsingArrayChaining()
    {
        myArray =  new LinkedList[defaultSize];
    }

    public void put(String key, Employee employee)
    {
        int position = hashFunction(key);

        if(myArray[position] == null)
        {
            myArray[position] = new LinkedList<>();
        }

        myArray[position].add(new HashedEmployee(key, employee));
    }

    public Employee get(String key)
    {
        int position = hashFunction(key);

        if(myArray[position] == null)
        {
            System.out.println("No employee found with the key");
            return null;
        }

        for (HashedEmployee hashedEmployee : myArray[position]) {
            if(hashedEmployee.getKey().equals(key))
                return hashedEmployee.getEmployee();
        }

        System.out.println("No employee found with the key");
        return null;
    }

    public Employee remove(String key)
    {
        int position = hashFunction(key);

        if(myArray[position] == null)
        {
            System.out.println("No employee found with the key");
            return null;
        }

        Iterator<HashedEmployee> employeeIterator = myArray[position].iterator();

        while(employeeIterator.hasNext())
        {
            HashedEmployee hashedEmployee = employeeIterator.next();
            if(hashedEmployee.getKey().equals(key))
            {
                employeeIterator.remove();
                return hashedEmployee.getEmployee();
            }
        }

        System.out.println("No employee found with the key");
        return null;
    }

    private int hashFunction(String key) {
        return key.length() % myArray.length;
    }

    public void display(){
        System.out.println(CommonUtil.printMyArray(myArray));
    }
}
