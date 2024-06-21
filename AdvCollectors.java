import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AdvCollectors {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", new Department("HR"), 50000),
                new Employee("Eve", new Department("Finance"), 90000),
                new Employee("David", new Department("IT"), 80000),
                new Employee("Bob", new Department("IT"), 70000),
                new Employee("Charlie", new Department("HR"), 60000)

        );

        // Accumulate names into a List
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(list);

        // Accumulate names into a TreeSet
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);

        // Convert elements to strings and concatenate them, separated by commas
        // String joined = employees.stream()
        // .map(Object.getName::toString)
        // .collect(Collectors.joining(", "));
        // System.out.println(joined);

        // Compute sum of salaries of employee
        int total = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println(total);

        // Group employees by department
        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(byDept);

        Map<Department, Integer> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));
        System.out.println(totalByDept);
    }

}

class Employee {
    private String name;
    private Department department;
    private int salary;

    // Constructor
    public Employee(String name, Department department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}

class Department {
    private String name;

    // Constructor
    public Department(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Override equals and hashCode for proper functioning in HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
