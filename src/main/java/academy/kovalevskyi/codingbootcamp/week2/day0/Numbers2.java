package academy.kovalevskyi.codingbootcamp.week2.day0;

public class Numbers2 {
    public static char[][] generateTriplets() {
        char[][] chars = new char[7][3];
        for (int i = 0; i < 7; i++) {
            int digit = 0;
            for (int j = 0; j < 3; j++) {
                chars[i][j] = (char) digit++;
            }
        }
        for (char[] arr : chars) {
            for (char c : arr) {
                System.out.println(c);
            }
        }
        return chars;
    }
}