import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee() {

    }

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public List<Employee> getSampleEmployee() {
        Employee employee2 = new Employee(2, 3, new ArrayList<Integer>());
        Employee employee3 = new Employee(3, 3, new ArrayList<Integer>());
        List<Integer> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(2);
        listOfEmployees.add(3);
        Employee employee1 = new Employee(1, 5, listOfEmployees);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3); 
        return employees;
    }
};