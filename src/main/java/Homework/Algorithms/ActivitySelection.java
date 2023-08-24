package Homework.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static ArrayList<Integer> maxActivities(int[][] activities) {
        Activity[] activityArray = new Activity[activities.length];
        for (int i = 0; i < activities.length; i++) {
            activityArray[i] = new Activity(activities[i][0], activities[i][1], i);
        }

        Arrays.sort(activityArray, new Comparator<Activity>() {
            public int compare(Activity a, Activity b) {
                return Integer.compare(a.end, b.end);
            }
        });

        ArrayList<Integer> selectedActivities = new ArrayList<>();
        int lastEndTime = -1;

        for (Activity activity : activityArray) {
            if (activity.start >= lastEndTime) {
                selectedActivities.add(activity.index);
                lastEndTime = activity.end;
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        int[][] activities = {
                {1, 4},
                {3, 5},
                {0, 6},
                {5, 7},
                {3, 8},
                {5, 9},
                {6, 10},
                {8, 11}
        };

        ArrayList<Integer> selectedActivities = maxActivities(activities);
        System.out.println("Selected activity indices: " + selectedActivities);
    }
}
