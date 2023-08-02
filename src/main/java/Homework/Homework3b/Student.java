package Homework.Homework3b;

public class Student {
    String name;
    String surname;
    int course;
    double score;

    public Student(String name, String surname, int course, double score) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student name: " + name + " " + surname + " course: " + course + " score: " + score;
    }
}
