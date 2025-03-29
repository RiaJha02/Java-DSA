package src.main.Practice;

import java.util.*;

public class GroupAnagrams {

    //TC:O(N*K); SC:O(N*K)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsList = new ArrayList<>();
        Map<String, List<String>> freqMap = new HashMap<>();
        for(String str : strs) {
            String freq = calculateFreq(str);
            List<String> anagrams = new ArrayList<>();
            if(freqMap.containsKey(freq)) {
                anagrams = freqMap.get(freq);
            }
            anagrams.add(str);
            freqMap.put(freq, anagrams);
        }
        for(Map.Entry<String, List<String>> entry : freqMap.entrySet()) {
            anagramsList.add(entry.getValue());
        }
        return anagramsList;
    }

    private String calculateFreq(String str) {
        int[] letterMap = new int[26];
        Arrays.fill(letterMap, 0);
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            letterMap[idx]++;
        }
        StringBuilder freqStr = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(letterMap[i] != 0) {
                freqStr.append(letterMap[i]).append((char)('a'+i));
            }
        }
        System.out.println(str + ":" + freqStr);
        return freqStr.toString();
    }
}
