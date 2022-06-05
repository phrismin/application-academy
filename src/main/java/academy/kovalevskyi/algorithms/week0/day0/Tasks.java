package academy.kovalevskyi.algorithms.week0.day0;

public class Tasks implements Sort {
    public static boolean sameCharactersSorting(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Sort sort = new Tasks();
        String[] leftArray = left.split("");
        sort.sort(leftArray);
        String[] rightArray = right.split("");
        sort.sort(rightArray);
        return "".formatted(leftArray).equals("".formatted((rightArray)));
    }

    public static boolean sameCharactersO1(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        int leftInt = 0;
        int rightInt = 0;
        int length = left.length();
        for (int i = 0; i < length; i++) {
            leftInt += left.charAt(i) * left.charAt(i);
            rightInt += right.charAt(i) * right.charAt(i);
        }
        return leftInt == rightInt;
    }
}