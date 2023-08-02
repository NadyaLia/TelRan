package Homework.Homework25;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task1Test {
    private int[] array1;
    private int[] array2;
    @Before
    public void init() {
        array1 = new int[] {1, 2, 5, 5, 8, 9, 7, 10};
        array2 = new int[] {1, 0, 6, 15, 6, 4, 7, 0};
    }

    @Test
    public void checkFindCommonElements() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 7));
        Set<Integer> actual = Task1.findCommonElements(array1, array2);
        assertEquals(expected, actual);
    }

    @Test
    public void checkArraysWithNoCommonElements() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        Set<Integer> expected = new HashSet<>();
        Set<Integer> actual = Task1.findCommonElements(arr1, arr2);
        assertEquals(expected, actual);
    }

    @Test
    public void checkNotNull() {
        assertNotNull(array1);
        assertNotNull(array2);
    }

}