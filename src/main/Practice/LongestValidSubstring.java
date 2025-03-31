package src.main.Practice;

import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class LongestValidSubstring {

    public int longestValidSubstring(String word, List<String> forbidden) {
        if(word == null || word.length() == 0) {
            return 0;
        }
        if(forbidden == null || forbidden.size() == 0) {
            return word.length();
        }
        int l = 0, r = 0;
        int n = word.length();
        int longestLen = Integer.MIN_VALUE;
        Set<String> forbiddenSet = new HashSet<>(forbidden);
        int k = 0;
        for(String str : forbidden) {
            k = Math.max(k, str.length());
        }
        while(r < n) {
            for(int i = r; (i >= l) && i > (r-k); i--) {
                String subStr = word.substring(i, r + 1);
                if(forbiddenSet.contains(subStr)) {
                    l = i+1;
                    break;
                }
                 System.out.println("subStr: " + subStr);
            }
            longestLen = Math.max(longestLen, r-l+1);
            r++;
        }
        return longestLen;
    }

    public int longestValidSubstringBruteForce(String word, List<String> forbidden) {
        int n = word.length();
        int longestlen = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                String str = word.substring(i, j+1);
                boolean valid = false;
                for(String substr : forbidden) {
                    valid = !str.contains(substr) && !substr.contains(str);
                }
                if(valid) {
                    longestlen = Math.max(longestlen, str.length());
                }
            }
        }
        return longestlen;
    }
}
