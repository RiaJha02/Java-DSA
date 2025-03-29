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
                System.out.print("Wrong input");
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

    //TC: O(N+N); SC: O(1)
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

    //Leetcode-1532
    // TC:O(1); SC:O(1);
    public int countOdds(int low, int high) {
        System.out.println("low = " + low + " high = " + high);
        int range = high - low + 1;
        int res = range/2;
        if((high%2 != 0) && (low%2 != 0)) {
            return res + 1;
        }
        return res;
    }

    //Leetcode-42
    //TC:O(N+N+N); SC:O(N+N)
    public int trappingRainWater(int[] height) {
        int res = 0;
        int n = height.length;
        int[] prefixMax = getPrefixMax(height, n);
        int[] suffixMax = getSuffixMax(height, n);
        for(int i = 1; i < n-1; i++) {
            System.out.println("left: " + prefixMax[i-1] + " ele: " + height[i] +" right: " + suffixMax[i+1]);
            int amt = Math.min(prefixMax[i-1], suffixMax[i+1]) - height[i];
            res += Math.max(amt, 0);
        }
        return res;
    }

    private static int[] getSuffixMax(int[] height, int n) {
        int[] suffixMax = new int[n];
        suffixMax[n -1] = height[n -1];
        for(int i = n -2; i > 0; i--) {
            suffixMax[i] = Math.max(height[i], suffixMax[i+1]);
        }
        System.out.println("suffixMax:" + Arrays.toString(suffixMax));
        return suffixMax;
    }

    private static int[] getPrefixMax(int[] height, int n) {
        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(height[i], prefixMax[i-1]);
        }
        System.out.println("prefixMax:" + Arrays.toString(prefixMax));
        return prefixMax;
    }

}
