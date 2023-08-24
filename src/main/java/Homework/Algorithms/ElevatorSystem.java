package Homework.Algorithms;

import java.util.HashMap;
import java.util.Map;

public class ElevatorSystem {
    private Map<String, Integer> elevatorPositions = new HashMap<>();

    public ElevatorSystem() {
        elevatorPositions.put("A", 0);
        elevatorPositions.put("B", 8);
        elevatorPositions.put("C", 7);
    }

    public String callElevator(int floor) {
        String closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : elevatorPositions.entrySet()) {
            String elevator = entry.getKey();
            int position = entry.getValue();
            int distance = Math.abs(floor - position);

            if (distance < minDistance) {
                closestElevator = elevator;
                minDistance = distance;
            }
        }

        return closestElevator;
    }

    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem();
        String closestElevator = system.callElevator(1);
        System.out.println("Отправляем лифт: " + closestElevator);
    }
}
