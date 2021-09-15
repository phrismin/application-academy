package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting {
  public static <T> void sort(T[] target, Comparator<T> comparator) throws NullPointerException {
    if (target.length == 0) {
      throw new NullPointerException();
    }
    int result;
    T temp;
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < target.length - 1; i++) {
        result = comparator.compare(target[i], target[i + 1]);
        if (result > 0) {
          isSorted = false;
          temp = target[i];
          target[i] = target[i + 1];
          target[i + 1] = temp;
        }
      }
    }
  }

  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator)
      throws NullPointerException {
    if (target.length == 0) {
      throw new NullPointerException();
    }
    int result;
    T temp;
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < target.length - 1; i++) {
        result = comparator.compare(target[i], target[i + 1]);
        if (result < 0) {
          isSorted = false;
          temp = target[i];
          target[i] = target[i + 1];
          target[i + 1] = temp;
        }
      }
    }
  }
}
