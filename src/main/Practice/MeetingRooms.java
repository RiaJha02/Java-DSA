package src.main.Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        int numOfRooms = 1;
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty()) {
                if(minHeap.peek() > interval[0]) {
                    numOfRooms++;
                } else {
                    minHeap.poll();
                }
            }
            minHeap.offer(interval[1]);
        }
        return numOfRooms;
    }
}
