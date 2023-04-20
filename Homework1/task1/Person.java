package Homework.Homework1.task1;

public class Person {
    String fullName;
    int age;

    void move() {
        System.out.println(fullName + " is moving.");
    }

    void talk() {
        System.out.println(fullName + " is talking");
    }

    public Person() {

    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }
}
