package Homework.Homework3b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student("Alex", "Bobrov", 3, 4.5);
        Student student2 = new Student("John", "Smith", 5, 5.0);
        Student student3 = new Student("Elena", "Luchik", 1, 5.0);
        Student student4 = new Student("John", "Kartoshkin", 1,2.5);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println(students);

        deleteStudents1(students);
        System.out.println(students);

        deleteStudents2(students, "John");
        System.out.println(students);

    }
    public static void deleteStudents1(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student current = iterator.next();
            if (current.course < 3) {
                iterator.remove();
            }
        }
    }
    public static void deleteStudents2(List<Student> students, String name) {

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student current = iterator.next();
            if (current.name == name) {
                iterator.remove();
            }
        }
    }
}
