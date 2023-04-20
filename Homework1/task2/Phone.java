package Homework.Homework1.task2;

public class Phone {
    public String number;
    public String model;
    public double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public String toString() {
        return "Number: " + number + ", model: " + model + ", weight: " + weight;
    }

    public void receiveCall(String callersName) {
        System.out.println("Calling " + callersName);
    }

    public String getNumber() {
        return number;
    }
}


