package Homework.Homework1.task2;

public class PhoneTest {
    public static void main(String[] args) {
        Phone phone1 = new Phone("0049152901820", "iPhone 14 Pro", 206);
        System.out.println(phone1);
        phone1.receiveCall("Hanna");
        System.out.println(phone1.getNumber());
        System.out.println();

        Phone phone2 = new Phone("0049152901821", "iPhone SE", 144);
        System.out.println(phone2);
        phone2.receiveCall("Sergej");
        System.out.println(phone2.getNumber());
        System.out.println();

        Phone phone3 = new Phone("0049152901822", "iPhone 14", 172);
        System.out.println(phone3);
        phone3.receiveCall("Nadja");
        System.out.println(phone3.getNumber());
        System.out.println();
    }
}
