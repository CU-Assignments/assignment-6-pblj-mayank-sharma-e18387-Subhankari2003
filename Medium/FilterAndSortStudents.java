package Medium;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }
}

public class FilterAndSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 82.5),
            new Student("Jane", 68.0),
            new Student("Mike", 91.0),
            new Student("Sara", 77.5)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
