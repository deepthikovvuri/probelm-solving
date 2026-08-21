import java.util.*;

public class Employee {
    String name;
    int maxTasks;
    int assignedTasks;

    Employee(String name, int maxTasks) {
        this.name = name;
        this.maxTasks = maxTasks;
        this.assignedTasks = 0;
    }

    boolean canTakeTask() {
        return assignedTasks < maxTasks;
    }

    void assignTask() {
        assignedTasks++;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter maximum tasks: ");
            int maxTasks = sc.nextInt();
            sc.nextLine();

            employees.add(new Employee(name, maxTasks));
        }

        System.out.print("Enter number of tasks: ");
        int m = sc.nextInt();
        sc.nextLine();

        String[] tasks = new String[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Enter task name: ");
            tasks[i] = sc.nextLine();
        }

        System.out.println("\nTask Assignments:");

        int employeeIndex = 0;

        for (String task : tasks) {

            boolean assigned = false;

            for (int i = 0; i < employees.size(); i++) {

                Employee emp =
                    employees.get((employeeIndex + i) % employees.size());

                if (emp.canTakeTask()) {

                    emp.assignTask();

                    System.out.println(
                        task + " -> " + emp.name
                    );

                    employeeIndex =
                        (employees.indexOf(emp) + 1)
                        % employees.size();

                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.println(task + " -> No employee available");
            }
        }

        System.out.println("\nFinal Workload:");

        for (Employee emp : employees) {
            System.out.println(
                emp.name + " : " +
                emp.assignedTasks + "/" +
                emp.maxTasks
            );
        }

        sc.close();
    }
}
