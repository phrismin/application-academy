package academy.kovalevskyi.algorithms.week0.day2;

import java.util.OptionalInt;

public class Tasks {
    public static OptionalInt findIndex(int[] sortedArray, int target) {
        int start = 0;
        int end = sortedArray.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < sortedArray[middle]) {
                end = middle + 1;
            } else if (target > sortedArray[middle]) {
                start = middle + 1;
            } else {
                return OptionalInt.of(middle);
            }
        }
        return OptionalInt.empty();
    }
}