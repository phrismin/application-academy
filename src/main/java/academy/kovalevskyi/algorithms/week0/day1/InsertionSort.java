package academy.kovalevskyi.algorithms.week0.day1;

import academy.kovalevskyi.algorithms.week0.day0.Sort;

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
    }
}