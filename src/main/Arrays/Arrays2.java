package src.main.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays2 {

    //print subarr
    //TC:O(N^3); SC:O(1)
    public void printSubArr(List<Integer> arr) {
        int n = arr.size();
        for(int s = 0; s < n; s++) {
            for(int e = s; e < n; e++) {
                for(int i = s; i <= e; i++) {
                    System.out.print(arr.get(i)+ " ");
                }
                System.out.println();
            }
        }
    }

}
