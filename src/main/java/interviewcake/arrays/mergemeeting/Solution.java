package interviewcake.arrays.mergemeeting;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Solution {

    public static class Meeting {

        int startTime;
        int endTime;

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

        // sorting meetings
        meetings.sort(Comparator.comparing(Meeting::getStartTime));
        List<Meeting> result = new ArrayList<>();
        result.add(meetings.get(0));
        for (int i = 1; i < meetings.size(); i++) {
            Meeting lastMeeting = result.get(result.size()-1);
            Meeting currentMeeting = meetings.get(i);
            Meeting meeting = merge2Meetings(lastMeeting, currentMeeting);
            if (meeting == null) {
                result.add(currentMeeting);
            } else {
                // merge the meeting // line 80
            }
        }

        return result;
    }

    public static Meeting merge2Meetings(Meeting meeting1, Meeting meeting2){
        // 1,3 -- 2, 5
        if(meeting2.startTime <= meeting1.getEndTime() && meeting1.endTime <= meeting2.endTime){
             meeting1.setEndTime(meeting2.endTime);
             return  meeting1;
        }

        // 1,8 -- 2,3
        if(meeting1.getStartTime() <= meeting2.getStartTime() && meeting2.endTime <= meeting1.endTime){
            return  meeting1;

        }

        return null;
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString() + "\n \n");

        }

        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }

        System.out.println(" Running Total test case " + result.getRunCount());
        System.out.println(" Failed test case " + result.getFailures().size());

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
}