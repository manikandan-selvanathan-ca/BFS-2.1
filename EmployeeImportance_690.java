import java.util.*;

class EmployeeImportance_690 {

    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        if(employees == null || employees.size() ==0) return importance;

        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(int i = 0;i<employees.size();i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        Queue<Employee> queue = new LinkedList();
        queue.add(map.get(id));
        while(!queue.isEmpty()) {
            Employee employee = queue.poll();
            importance += employee.importance;
            for(Integer e: employee.subordinates) {
                queue.add(map.get(e));
            }
        }
        return importance;
    }

    public static void main(String[] args) {
        EmployeeImportance_690 employeeImportance_690 = new EmployeeImportance_690();
        List<Employee> employees = new Employee().getSampleEmployee();
        int importance = employeeImportance_690.getImportance(employees, 1);
        System.out.println("The importance of given employee is"+importance);
    }
}