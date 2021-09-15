package academy.kovalevskyi.algorithms.week0.day0;

import java.util.Arrays;
import java.util.Comparator;

public interface Sort {
  default <T extends Comparable<? super T>> void sort(final T[] target) {
    sort(target, T::compareTo);
  }

  default <T> void sort(final T[] target, final Comparator<T> comparator) {
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < target.length - 1; i++) {
        if (comparator.compare(target[i], target[i + 1]) > 0) {
          isSorted = false;
          T temp = target[i];
          target[i] = target[i + 1];
          target[i + 1] = temp;
        }
      }
    }
  }

  default <T> T[] createSortedArray(final T[] target, final Comparator<T> comparator) {
    T[] array = Arrays.copyOf(target, target.length);
    sort(array, comparator);
    return array;
  }

  default String complexityBest() {
    return "N";
  }

  default String complexityAverage() {
    return "N^2";
  }

  default String complexityWorst() {
    return "N^2";
  }

  default String spaceComplexityWorst() {
    return "N";
  }
}
