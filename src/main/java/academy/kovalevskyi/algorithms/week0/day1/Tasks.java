package academy.kovalevskyi.algorithms.week0.day1;

public class Tasks {

  public static class Node<T> {
    public Node<T> next;
    public T value;
  }

  public static <T> Node<T> findMiddleInOneGo(Node<T> start) {
    Node<T> temp = start;
    Node<T> middle = start;
    int length = 0;
    while (temp.next != null) {
      length++;
      if (length % 2 == 0) {
        middle = middle.next;
      }
      temp = temp.next;
    }
    return length % 2 == 0 ? middle : middle.next;
  }


  public static <T> boolean hasCycle(Node<T> start) {
    Node<T> next = start;
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