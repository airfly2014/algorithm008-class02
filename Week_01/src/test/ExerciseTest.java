package test;

import org.junit.Before;
import org.junit.Test;

import training.Exercise;

public class ExerciseTest {

    private Exercise exercise;

    @Before
    public void setUp() throws Exception {
       exercise = new Exercise();
    }

    @Test
    public void removeDuplicates() {
    }

    @Test
    public void rotate() {
    }

    @Test
    public void reverseArray() {
    }

    @Test
    public void mergeTwoLists() {
        Exercise.ListNode node1 = new Exercise.ListNode(1);
        Exercise.ListNode node2 = new Exercise.ListNode(2);
        node1.next = node2;
        Exercise.ListNode node3 = new Exercise.ListNode(3);
        Exercise.ListNode node4 = new Exercise.ListNode(4);
        node3.next = node4;

        exercise.mergeTwoLists(node1, null);
    }
}