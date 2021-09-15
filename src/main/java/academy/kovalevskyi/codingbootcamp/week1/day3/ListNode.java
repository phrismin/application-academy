package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode<T> {
  private ListNode<T> prev;
  private ListNode<T> next;
  private T value;

  public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
    this.prev = prev;
    this.next = next;
    this.value = value;
  }

  public void setPrev(ListNode<T> prev) {
    this.prev = prev;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  public ListNode<T> getNext() {
    return next;
  }

  public ListNode<T> getPrev() {
    return prev;
  }

  public T getValue() {
    return value;
  }

  public String toString() {
    T prevThis = (prev == null) ? null : prev.value;
    T nextThis = (next == null) ? null : next.value;
    return "Node{prevValue=" + prevThis + ", nextValue=" + nextThis + ", thisValue=" + value + "}";
  }
}