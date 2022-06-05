package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import academy.kovalevskyi.algorithms.week0.day1.InsertionSort;

import java.util.Comparator;

public class QuickSort implements Sort {

    @Override
    public <T> void sort(T[] target, Comparator<T> comparator) {
        quickSort(target, 0, target.length - 1, comparator);
    }

    private <T> void quickSort(T[] target, int low, int high, Comparator<T> comparator) {
        if (high - low < 33) {
            new InsertionSort().sort(target, comparator);
            return;
        }
        int sepIndex = separation(target, low, high, comparator);
        quickSort(target, low, sepIndex, comparator);
        quickSort(target, sepIndex + 1, high, comparator);
    }

    private <T> int separation(T[] target, int low, int high, Comparator<T> comparator) {
        T supportElement = target[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (comparator.compare(target[i], supportElement) < 0) {
                swap(target, i, j++);
            }
        }
        swap(target, low, j);
        return j;
    }

    private <T> void swap(T[] target, int i, int j) {
        T temp = target[i];
        target[i] = target[j];
        target[j] = temp;
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
        return "N^2";
    }
}
