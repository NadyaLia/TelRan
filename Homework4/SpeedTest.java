package Homework.Homework4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SpeedTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100_000_000; i++) {
            list.add(i);
        }

        long beforeForeach = System.currentTimeMillis();
        for (Integer value : list) {
            int temp = value;
        }
        long afterForeach = System.currentTimeMillis();
        System.out.println("Time execution of for-each loop = " + (afterForeach - beforeForeach));

        long beforeFor_i = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
        }
        long afterFor_i = System.currentTimeMillis();
        System.out.println("Time execution of for-i loop = " + (afterFor_i - beforeFor_i));

        long beforeFor_i2 = System.currentTimeMillis();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            int temp = list.get(i);
        }
        long afterFor_i2 = System.currentTimeMillis();
        System.out.println("Time execution of for-i loop 2 = " + (afterFor_i2 - beforeFor_i2));

        long beforeFor_i3 = System.currentTimeMillis();
        int length2 = list.size();
        for (int i = length2 - 1; i > 0; i--) {
            int temp = list.get(i);
        }
        long afterFor_i3 = System.currentTimeMillis();
        System.out.println("Time execution of for-i loop 3 = " + (afterFor_i3 - beforeFor_i3));

        long beforeIterator = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
        }
        long afterIterator = System.currentTimeMillis();
        System.out.println("Time execution of Iterator = " + (afterIterator - beforeIterator));

        long beforeListIterator = System.currentTimeMillis();
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            int temp = listIterator.next();
        }
        long afterListIterator = System.currentTimeMillis();
        System.out.println("Time execution of ListIterator = " + (afterListIterator - beforeListIterator));
    }
}
