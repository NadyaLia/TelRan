package Homework.Homework1.task1;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.move();
        person1.talk();

        Person person2 = new Person("Bob", 32);
        person2.move();
        person2.talk();
    }
}
