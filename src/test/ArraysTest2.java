package src.test;

import src.main.Arrays.Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest2 {
    Arrays2 arrays2 = new Arrays2();
    List<Integer> arr = new ArrayList<>();

    private void subarrays() {
        arr = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Input arr: " + arr);
        arrays2.printSubArr(arr);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        //subarray Concept Questions
        ArraysTest2 arrTest2 = new ArraysTest2();
        arrTest2.subarrays();
    }
}
