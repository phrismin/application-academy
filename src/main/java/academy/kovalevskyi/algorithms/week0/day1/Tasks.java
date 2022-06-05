package academy.kovalevskyi.algorithms.week0.day1;

public class Tasks {

    public static class Node {
        public Node next;
        public int value;
    }

    public static int findMiddleInOneGo(Node start) {
        Node temp = start;
        Node middle = start;
        int length = 0;
        while (temp.next != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next;
            }
            temp = temp.next;
        }
        return length % 2 == 0 ? middle.value : middle.next.value;
    }

    public static boolean hasCycle(Node start) {
        Node next = start;
        while (next.next != null && next.next.next != null) {
            start = start.next;
            next = next.next.next;
            if (start == next) {
                return true;
            }
        }
        return false;
    }
}