package src.test;

import src.main.Practice.MeetingRooms;

public class MeetingRoomsTest {
    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        int[][] intervals = {{1, 5}, {2, 7}, {2, 7}, {3, 6}, {6, 8}, {4, 8}};
        System.out.println("count of rooms : " + meetingRooms.minMeetingRooms(intervals));
    }

}
