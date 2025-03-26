package src.test.Arrays;

import src.main.Arrays.Arrays1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest1 {
    Arrays1 arr1 = new Arrays1();
    List<Integer> arr = new ArrayList<>();
    public void executeCountPivotsTest() {

        arr = Arrays.asList(-2, 6, 3, 4);
        System.out.println("TestCase1: " + arr);
        System.out.println("countPivots: " + arr1.countPivots(arr));
        System.out.println("--------------------");

        arr = Arrays.asList(-7, 1, 5, 2, -4, 3, 0);
        System.out.println("TestCase2: " + arr);
        System.out.println("countPivots: " + arr1.countPivots(arr));
        System.out.println("--------------------");

        arr = Arrays.asList(1, 2, 3, 4);
        System.out.println("TestCase3: " + arr);
        arr1.printPrefixProdArr(arr);
        System.out.println("--------------------");

        System.out.println("TestCase3:");
        System.out.println("countOdds: " + arr1.countOdds(3, 7));
        System.out.println("--------------------");

        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("TestCase4:" + Arrays.toString(heights));
        System.out.println("countTrapWaterUnits: " + arr1.trappingRainWater(heights));
        System.out.println("--------------------");
    }
}
