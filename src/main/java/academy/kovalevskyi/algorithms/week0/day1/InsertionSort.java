package academy.kovalevskyi.algorithms.week0.day1;

import academy.kovalevskyi.algorithms.week0.day0.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    for (int i = 1; i < target.length; i++) {
      T temp = target[i];
      int j = i;
      while (j > 0 && comparator.compare(temp, target[j - 1]) < 0) {
        target[j] = target[j - 1];
        j--;
      }
      target[j] = temp;
    }
    System.out.println(Arrays.toString(target));;
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[]{0, 1, 2, 1, 3, 0};
    Sort sort = new InsertionSort();

    sort.sort(arr, Integer::compareTo);
  }


  @Override
  public String complexityBest() {
    return "N";
  }

  @Override
  public String complexityAverage() {
    return "N^2";
  }

  @Override
  public String complexityWorst() {
    return "N^2";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N";
  }

}