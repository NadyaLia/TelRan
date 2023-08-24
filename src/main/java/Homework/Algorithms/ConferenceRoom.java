package Homework.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConferenceRoom {
    public static class Activity {
        int start;
        int end;
        int benefit;

        public Activity(int start, int end, int benefit) {
            this.start = start;
            this.end = end;
            this.benefit = benefit;
        }
    }

    public static int calculateBenefit(int start, int end) {
        if (end <= 13) return 1;
        if (start >= 13) return 2;
        return start < 13 && end > 13 ? 1 : 2;
    }

    public static List<Integer> maxBenefitActivities(List<Activity> activities) {
        Collections.sort(activities, (a, b) -> Integer.compare(a.end, b.end));
        int n = activities.size();
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; ++i) {
            Activity act = activities.get(i);
            dp[i] = act.benefit;

            for (int j = 0; j < i; ++j) {
                if (activities.get(j).end <= act.start) {
                    if (dp[i] < dp[j] + act.benefit) {
                        dp[i] = dp[j] + act.benefit;
                        prev[i] = j;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int maxIdx = 0;

        for (int i = 1; i < n; ++i) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        for (int i = maxIdx; i != -1; i = prev[i]) {
            result.add(i);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
                new Activity(9, 12, calculateBenefit(9, 12)),
                new Activity(11, 14, calculateBenefit(11, 14)),
                new Activity(13, 16, calculateBenefit(13, 16)),
                new Activity(15, 17, calculateBenefit(15, 17)),
                new Activity(9, 13, calculateBenefit(9, 13)),
                new Activity(12, 16, calculateBenefit(12, 16))
        );

        List<Integer> selectedActivities = maxBenefitActivities(activities);
        System.out.println("Selected activity indices: " + selectedActivities);
    }
}
