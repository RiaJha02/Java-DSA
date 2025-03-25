package src.main.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays1 {

    // TC:O(N); SC:O(1)
    public List<Integer> prefixSum(List<Integer> arr) {
        List<Integer> prefix = new ArrayList<>();
        prefix.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            prefix.add(prefix.get(i - 1) + arr.get(i));
        }
        System.out.println("prefixSum: " + prefix);
        return prefix;
    }

    //TC:O(N+Q); SC:O(N)
    public int sumQuery(List<List<Integer>> queries, List<Integer> arr) {
        List<Integer> prefixSum = prefixSum(arr);
        for (List<Integer> query : queries) {
            int left = query.get(0);
            int right = query.get(1);
            if (left == 0) {
                return prefixSum.get(right);
            } else if (left > 0) {
                return prefixSum.get(right) - prefixSum.get(left - 1);
            } else {
                System.out.print("Wroong input");
                return -1;
            }
        }
        return -1;
    }

    //TC:O(N+N); SC:O(N)
    public int countPivots(List<Integer> arr) {
        int i, l, r;
        int n = arr.size();
        int count = 0;
        List<Integer> preSum = prefixSum(arr);
        for (i = 1; i < n-1; i++) {
            l = preSum.get(i - 1);
            r = preSum.get(n - 1) - preSum.get(i);
//            System.out.println("l:" + l + " r:" + r);
            if (l == r) {
                count++;
            }
        }
        count = (preSum.get(n - 1) - preSum.get(i)  == 0) ? count+1 : count; //0th index check
        count = (preSum.get(i - 1) == 0) ? count+1 : count; //last index check
        return count;
    }

    //TC: O(N+N); SC: O(N)
    public void printPrefixProdArr(List<Integer> arr) {
        List<Integer> prefix = prefixProd(arr);
        int suffix = 1, n = arr.size();
        int[] res = new int[n];
        Arrays.fill(res, 0);
        int i = n-1;
        while(i > 0){
//            System.out.println("suffix : " + suffix);
            res[i] = prefix.get(i-1) * suffix;
            suffix = suffix * arr.get(i);
            i--;
        }
        res[i] = suffix;
        System.out.println("printPrefixProdArr: " + Arrays.toString(res));
    }

    private List<Integer> prefixProd(List<Integer> arr) {
        List<Integer> prefix = new ArrayList<>();
        prefix.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            prefix.add(prefix.get(i - 1) * arr.get(i));
        }
        System.out.println("prefixProd: " + prefix);
        return prefix;
    }

}
