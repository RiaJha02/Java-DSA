package src.main.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays2 {

    private final Arrays1 arr1 = new Arrays1();

    //print subarr
    //TC:O(N^3); SC:O(1)
    public void printSubArr(List<Integer> arr) {
        int n = arr.size();
        for(int s = 0; s < n; s++) {
            for(int e = s; e < n; e++) {
                System.out.print("[");
                for(int i = s; i <= e; i++) {
                    System.out.print(arr.get(i)+ " ");
                }
                System.out.print("], ");
            }
        }
        System.out.println();
    }

    //print subarr sum
    //TC:O(N^2); SC:O(N)
    public void getSubArrSum(List<Integer> arr) {
        int n = arr.size();
        List<Integer> preSum = arr1.prefixSum(arr);
        for(int s = 0; s < n; s++) {
            for(int e = s; e < n; e++) {
                if(s == 0) {
                    System.out.print(preSum.get(e) + ", ");
                }
                else {
                    System.out.print(preSum.get(e)-preSum.get(s-1) + ", ");
                }
            }
        }
        System.out.println();
    }

}
