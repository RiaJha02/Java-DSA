package src.main.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays1 {
    List<Integer> arr = new ArrayList<>();

    public List<Integer> prefixSum() {
        List<Integer> prefix = new ArrayList<>();
        prefix.add(arr.get(0));
        for(int i = 1; i < arr.size(); i++) {
            prefix.add(prefix.get(i-1)+arr.get(0));
        }
        return prefix;
    }

}
