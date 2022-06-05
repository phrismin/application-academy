package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;

import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        Integer[] integers = {4, 5, 7, 0, 6, -2};
        Sort sort = new HeapSort();
        sort.sort(integers, Integer::compareTo);
    }
}

public class HeapSort implements Sort {
    @Override
    public <T> void sort(T[] target, Comparator<T> comparator) {
        heapify(target, 0, target.length, comparator);
    }

    private <T> void heapify(T[] target, int current, int size, Comparator<T> comparator) {
        int largest = current;
        int left = current * 2 + 1;
        int right = current * 2 + 2;

        if (left < size) {
            largest = left;
        }
        if (right < size) {
            largest = size;
        }
//    if (largest != size) {
//      swap(target, current, );
//    }


        heapify(target, largest, size, comparator);
    }

    private <T> void swap(T[] target, int i, int j) {
        T temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}
