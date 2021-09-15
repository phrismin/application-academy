package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper {

  public static <T> int length(ListNode<T> someNode) throws NullPointerException {
    if (someNode == null) {
      throw new NullPointerException();
    }
    if (someNode.getPrev() == null && someNode.getNext() == null) {
      return 1;
    }
    ListNode<T> next = someNode.getNext();
    int length = 0;
    while (next != null) {
      next = next.getNext();
      length++;
    }
    ListNode<T> prev = someNode.getPrev();
    while (prev != null) {
      prev = prev.getPrev();
      length++;
    }
    return length + 1;
  }

  private static <T> int rightLength(ListNode<T> someNode) {
    ListNode<T> next = someNode.getNext();
    int length = 0;
    while (next != null) {
      next = next.getNext();
      length++;
    }
    return length;
  }

  private static <T> int leftLength(ListNode<T> someNode) {
    ListNode<T> prev = someNode.getPrev();
    int length = 0;
    while (prev != null) {
      prev = prev.getPrev();
      length++;
    }
    return length;
  }

  public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue)
      throws NullPointerException {
    if (someNode == null) {
      throw new NullPointerException();
    }
    ListNode<T> tempNode = someNode;
    while (tempNode.getNext() != null) {
      tempNode = tempNode.getNext();
    }
    ListNode<T> newNode = new ListNode<>(null, null, newValue);
    tempNode.setNext(newNode);
    newNode.setPrev(tempNode);
    return newNode;
  }

  public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    ListNode<T> tempNode = someNode;
    while (tempNode.getPrev() != null) {
      tempNode = tempNode.getPrev();
    }
    ListNode<T> newNode = new ListNode<>(null, null, newValue);
    tempNode.setPrev(newNode);
    newNode.setNext(tempNode);
    return newNode;
  }

  public static <T> boolean contains(ListNode<T> someNode, T value) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    if (someNode.getValue().equals(value)) {
      return true;
    }
    while (someNode.getPrev() != null) {
      someNode = someNode.getPrev();
      if (someNode.getValue().equals(value)) {
        return true;
      }
    }
    while (someNode.getNext() != null) {
      someNode = someNode.getNext();
      if (someNode.getValue().equals(value)) {
        return true;
      }
    }
    return false;
  }

  public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    while (someNode.getPrev() != null) {
      someNode = someNode.getPrev();
    }
    ListNode<R> newNode = new ListNode<>(null, null, mapFunction.apply(someNode.getValue()));
    while (someNode.getNext() != null) {
      someNode = someNode.getNext();
      addToEnd(newNode, mapFunction.apply(someNode.getValue()));
    }
    return newNode;
  }

  public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
    if (prev == null) {
      throw new NullPointerException();
    }
    ListNode<T> newNode = new ListNode<>(null, null, newValue);
    if (prev.getNext() == null) {
      prev.setNext(newNode);
      newNode.setPrev(prev);
    } else {
      newNode.setPrev(prev);
      newNode.setNext(prev.getNext());
      prev.getNext().setPrev(newNode);
      prev.setNext(newNode);
    }
    return newNode;
  }

  public static <T> void insertAfter(ListNode<T> prev, T[] newValues) throws NullPointerException {
    if (prev == null) {
      throw new NullPointerException();
    }
    for (T value : newValues) {
      prev = insertAfter(prev, value);
    }
  }

  public static <T> T delete(ListNode<T> current) throws NullPointerException {
    if (current == null) {
      throw new NullPointerException();
    } else if (current.getNext() == null && current.getPrev() == null) {
      current.setNext(null);
      current.setPrev(null);
    } else if (current.getPrev() == null && current.getNext() != null) {
      current.getNext().setPrev(null);
    } else if (current.getPrev() != null && current.getNext() == null) {
      current.getPrev().setNext(null);
    } else {
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
    }
    current.setPrev(null);
    current.setNext(null);
    return current.getValue();
  }
}