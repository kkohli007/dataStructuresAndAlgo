package src.dataStructures.hashTables;

import src.common.CommonUtil;
import src.dto.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class RemoveDuplicateFromLinkedList {

    public static void main(String[] args) {
        LinkedList<Employee> employeeList = new  LinkedList<>();
        employeeList.add(new Employee("Virat", "Kohli", 31));
        employeeList.add(new Employee("Harshal", "Patel", 30));
        employeeList.add(new Employee("Rajat", "Patidar", 24));
        employeeList.add(new Employee("Faf", "Plessis", 34));
        employeeList.add(new Employee("Virat", "Kohli", 31));
        employeeList.add(new Employee("Harshal", "Patel", 22));

        System.out.println("Original list"+ CommonUtil.printMyLinkedList(employeeList));
        employeeList = removeDuplicateElements(employeeList);
        System.out.println("Duplicate removed list"+ CommonUtil.printMyLinkedList(employeeList));
    }

    private static LinkedList<Employee> removeDuplicateElements(LinkedList<Employee> employeeList) {

        Map<Integer, Employee> empMap = new HashMap<>();

        for(Employee emp: employeeList)
        {
            empMap.put(emp.hashCode(), emp);
        }

        employeeList = new LinkedList<>();

        for(Employee employee: empMap.values())
        {
            employeeList.add(employee);
        }

        return employeeList;
    }
}
