package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Alphabet {
    public static char[] generateReversedAlphabet() {
        char[] array = new char[26];
        int j = 122;
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) j;
            j--;
        }
        return array;
    }

    public static char[] generateAlphabet() {
        char[] array = new char[26];
        int j = 97;
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) j;
            j++;
        }
        return array;
    }
}
