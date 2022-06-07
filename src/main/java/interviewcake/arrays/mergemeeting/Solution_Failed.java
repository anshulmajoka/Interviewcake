package interviewcake.arrays.mergemeeting;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Solution_Failed {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Meeting)) {
                return false;
            }
            final Meeting meeting = (Meeting) o;
            return startTime == meeting.startTime && endTime == meeting.endTime;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + startTime;
            result = result * 31 + endTime;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // merge meetings ranges

//        HashSet<Meeting> result = new HashSet<>();
        // sorting meetings
        Set<Meeting> result = new LinkedHashSet<>();

        for (int i = 0; i < meetings.size() -1; i++) {
            Meeting first = meetings.get(i);
            Meeting second = meetings.get(i+1);
            Meeting meeting = merge2Meetings(first, second);
            if (meeting == null) {
                result.add(first);
                result.add(second);
            } else {
                result.add(meeting);
            }
        }

        List<Meeting> meetingList = new ArrayList<>();
        meetingList.addAll(result);
        return meetingList;
    }

    public static Meeting merge2Meetings(Meeting meeting1, Meeting meeting2){
        int s1 = meeting1.getStartTime();
        int s2 = meeting2.getStartTime();

        // meeting that starts earlier is first meeting
        if (s2 >= s1) {
            // do nothing
        } else {
            Meeting temp = meeting1;
            meeting1 = meeting2;
            meeting2 = temp;
        }

        // 1,3 -- 2, 5
        if(meeting2.startTime <= meeting1.getEndTime() && meeting1.endTime <= meeting2.endTime){
            return new Meeting(meeting1.getStartTime(), meeting2.getEndTime());
        }

        // 1,8 -- 2,3
        if(meeting1.getStartTime() <= meeting2.getStartTime() && meeting2.endTime <= meeting1.endTime){
            return new Meeting(meeting1.getStartTime(), meeting2.getEndTime());

        }

        return null;
    }



    /**
     * Test Cases
     */

    // tests
    @Test
    public void meetingsOverlapTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(2, 4));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 4));
        assertEquals(expected, actual);
    }

    @Test
    public void  meetingsTouchTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(5, 6), new Meeting(6, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(5, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingContainsOtherMeetingTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 8), new Meeting(2, 5));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsStaySeparateTest() {
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(4, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(
            new Meeting(1, 3), new Meeting(4, 8)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void multipleMergedMeetingsTest() {
        final List<Meeting> meetings = Arrays.asList(
            new Meeting(1, 4), new Meeting(2, 5), new Meeting (5, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 8));
        assertEquals(expected, actual);
    }

    @Test
    public void meetingsNotSortedTest() {
        final List<Meeting> meetings = Arrays.asList(
            new Meeting(5, 8), new Meeting(1, 4), new Meeting(6, 8));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(
            new Meeting(1, 4), new Meeting(5, 8)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void oneLongMeetingContainsSmallerMeetingsTest() {
        final List<Meeting> meetings = Arrays.asList(
            new Meeting(1, 10), new Meeting(2, 5), new Meeting(6, 8),
            new Meeting(9, 10), new Meeting(10, 12)
        );
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(
            new Meeting(1, 12)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void sampleInputTest() {
        List<Meeting> meetings = Arrays.asList(new Meeting(0, 1), new Meeting(3, 8), new Meeting(9, 12));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(
            new Meeting(0, 1), new Meeting(3, 8), new Meeting(9, 12)
        );
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution_Failed.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString() + "\n \n");

        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }

        System.out.println(" Running Total test case " + result.getRunCount());
        System.out.println(" Failed test case " + result.getFailures().size());

    }
}