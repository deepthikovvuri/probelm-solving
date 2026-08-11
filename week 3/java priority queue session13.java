import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.getCGPA() != b.getCGPA())
                    return Double.compare(b.getCGPA(), a.getCGPA());

                int name = a.getName().compareTo(b.getName());

                if (name != 0)
                    return name;

                return Integer.compare(a.getID(), b.getID());
            }
        );

        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] p = event.split(" ");
                pq.add(new Student(
                    Integer.parseInt(p[3]),
                    p[1],
                    Double.parseDouble(p[2])
                ));
            } else {
                if (!pq.isEmpty())
                    pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty())
            result.add(pq.poll());

        return result;
    }
}
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}