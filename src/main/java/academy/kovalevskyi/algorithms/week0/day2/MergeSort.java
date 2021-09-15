package academy.kovalevskyi.algorithms.week0.day2;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class MergeSort implements Sort {
  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    T[] newTarget = createSortedArray(target, comparator);
    System.arraycopy(newTarget, 0, target, 0, target.length);
  }

  @Override
  public <T> T[] createSortedArray(T[] target, Comparator<T> comparator) {
    T[] result = target.clone();
    mergeSort(target, result, comparator, 0, result.length - 1);
    return result;
  }

  private <T> void mergeSort(T[] target, T[] result, Comparator<T> comparator, int start, int end) {
    if (start >= end) {
      return;
    }
    int middle = start + (end - start) / 2;
    mergeSort(target, result, comparator, start, middle);
    mergeSort(target, result, comparator, middle + 1, end);
    merge(target, result, comparator, start, middle, middle + 1, end);
  }

  private <T> void merge(T[] target, T[] result, Comparator<T> comparator,
                         int leftStart, int leftEnd, int rightStart, int rightEnd) {

    for (int i = leftStart; i <= rightEnd; i++) {
      target[i] = result[i];
    }
    for (int i = leftStart; i <= rightEnd; i++) {
      if (leftStart > leftEnd) {
        result[i] = target[rightStart++];
      } else if (rightStart > rightEnd) {
        result[i] = target[leftStart++];
      } else if (comparator.compare(target[leftStart], target[rightStart]) < 0) {
        result[i] = target[leftStart++];
      } else {
        result[i] = target[rightStart++];
      }
    }
  }

  @Override
  public String complexityBest() {
    return "N*log(N)";
  }

  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  @Override
  public String complexityWorst() {
    return "N*log(N)";
  }
}
