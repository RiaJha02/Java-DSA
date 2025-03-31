package src.test;

import src.main.Practice.*;
import java.util.Arrays;
import java.util.List;

public class PracticeTest {

    public static void main(String[] args) {
//        lruTest();
//        numOfIslandsTest();
//        meetingRoomsTest();
//        groupAnagramsTest();
        findLongestValidSubstring();
    }

    private static void findLongestValidSubstring() {
        LongestValidSubstring validSubstr = new LongestValidSubstring();
        String word = "leetcode";
        List<String> forbidden = Arrays.asList("le", "e", "de");
        System.out.println("word: " + word);
        System.out.println("forbidden: " + forbidden);
        System.out.println("validSubStrlen: " + validSubstr.longestValidSubstring(word, forbidden));
    }

    private static void groupAnagramsTest() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams anagrams = new GroupAnagrams();
        System.out.println("anagrams group list: " + anagrams.groupAnagrams(strs));
    }

    private static void meetingRoomsTest() {
        MeetingRooms meetingRooms = new MeetingRooms();
        int[][] intervals = {{1, 5}, {2, 7}, {2, 7}, {3, 6}, {6, 8}, {4, 8}};
        System.out.println("count of rooms : " + meetingRooms.minMeetingRooms(intervals));
    }

    private static void numOfIslandsTest() {
        NumberOfIslands islands = new NumberOfIslands();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(Arrays.deepToString(grid));
        System.out.println("***************************");
        System.out.println("numOfIslands : " + islands.numIslandsDFS(grid));
        System.out.println(Arrays.deepToString(grid));
        System.out.println("***************************");
        System.out.println("numOfIslands : " + islands.numIslandsBFS(grid));
        System.out.println("***************************");
    }

    private static void lruTest() {
        System.out.println("LRUCacheTest...");
        LRUCache lruCache = new LRUCache(4);
        lruCache.putKey(2, 6);
        lruCache.putKey(4, 7);
        lruCache.putKey(8, 11);
        lruCache.putKey(7, 10);
        System.out.println(lruCache.getKey(2));
        System.out.println(lruCache.getKey(8));
        lruCache.putKey(5, 6);
        lruCache.putKey(10, 6);
        lruCache.putKey(11, 9);
        System.out.println(lruCache.getKey(7));
        lruCache.putKey(5, 7);
    }

}
