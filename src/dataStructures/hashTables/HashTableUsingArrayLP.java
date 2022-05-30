package src.dataStructures.hashTables;

import src.common.CommonUtil;
import src.dto.Employee;
import src.dto.HashedEmployee;

// Using linear probing when collision occurs
// increment index by 1 to put new element until new position found
class TestHashTableUsingArrayLPLP
{
    public static void main(String[] args) {

        HashTableUsingArrayLP hashTable = new HashTableUsingArrayLP();
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

public class HashTableUsingArrayLP
{
    HashedEmployee[] myArray = null;

    int defaultSize = 10;

    public HashTableUsingArrayLP()
    {
        myArray = new HashedEmployee[defaultSize];
    }

    public void put(String key, Employee employee)
    {
        int position = hashFunction(key);

        if(occupied(position))
        {
            int stopIndex= position;

            position = (position + 1) % myArray.length;

            while(occupied(position) && position != stopIndex)
            {
                position = (position+1) % myArray.length;
            }
        }

        if(occupied(position))
            System.out.println("Sorry employee already exists at this position");
        else
            myArray[position] = new HashedEmployee(key, employee);
    }

    public Employee get(String key)
    {
        int position = hashFunction(key);

        if (!keyMatchFound(key, position) && myArray[position] !=null)
        {
            int stopIndex = position;
            position = (position + 1) % myArray.length;

            // will stop probing at null to have good performance,
            // but that would cause problems at time of removing element.
            // So at time of remove element, need to rehash.
            while(myArray[position] !=null && !keyMatchFound(key, position) && position!=stopIndex )
            {
                position = (position + 1) % myArray.length;
            }
        }

        if(!keyMatchFound(key, position))
        {
            System.out.println("Sorry employee doesn't exists");
            return null;
        }
        else
            return myArray[position].getEmployee();
    }

    public Employee remove(String key)
    {
        int position = hashFunction(key);

        if (!keyMatchFound(key, position) && myArray[position] !=null)
        {
            int stopIndex = position;
            position = (position + 1) % myArray.length;

            while(!keyMatchFound(key, position) && position!=stopIndex && myArray[position] != null)
            {
                position = (position + 1) % myArray.length;
            }
        }

        if(!keyMatchFound(key, position))
        {
            System.out.println("Sorry employee doesn't exists");
            return null;
        }
        else
        {
            Employee temp = myArray[position].getEmployee();
            myArray[position] = null;
            rehash();
            return temp;
        }
    }

    private void rehash() {
        HashedEmployee[] oldArray = myArray;

        for(int i=0; i<oldArray.length; i++)
        {
            if(oldArray[i] !=null)
                put(oldArray[i].getKey(), oldArray[i].getEmployee());
        }
    }

    private int hashFunction(String key) {
        return key.length() % myArray.length;
    }

    private boolean occupied(int position)
    {
        return myArray[position] != null;
    }

    private boolean keyMatchFound(String key, int position)
    {
        return myArray[position] != null && key.equals(myArray[position].getKey());
    }

    public void display(){
        System.out.println(CommonUtil.printMyArray(myArray));

    }
}
