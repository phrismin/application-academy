package academy.kovalevskyi.codingbootcamp.week1.day2;

import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;

public class StringUtils {
    public static boolean isAsciiUppercase(char ch) throws IllegalArgumentException {
        int charInt = ch;
        if (charInt > 127 || charInt < 32) {
            throw new IllegalArgumentException();
        }
        return charInt > 64 && charInt < 91;
    }

    public static boolean isAsciiLowercase(char ch) throws IllegalArgumentException {
        int charInt = ch;
        if (charInt > 127 || charInt < 32) {
            throw new IllegalArgumentException();
        }
        return charInt > 96 && charInt < 123;
    }

    public static boolean isAsciiNumeric(char ch) throws IllegalArgumentException {
        int charInt = ch;
        if (charInt > 127 || charInt < 32) {
            throw new IllegalArgumentException();
        }
        return charInt > 47 && charInt < 58;
    }

    public static boolean isAsciiAlphabetic(char ch) throws IllegalArgumentException {
        return isAsciiUppercase(ch) || isAsciiLowercase(ch);
    }

    public static char toAsciiUppercase(char ch) throws IllegalArgumentException {
        return isAsciiLowercase(ch) ? (char) (ch - 32) : ch;
    }

    public static char toAsciiLowercase(char ch) throws IllegalArgumentException {
        return isAsciiUppercase(ch) ? (char) (ch + 32) : ch;
    }

    public static StringBuilder makeUppercase(char[] input) throws IllegalArgumentException {
        char[] tempArray = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            if (isAsciiLowercase(input[i])) {
                tempArray[i] = toAsciiUppercase(input[i]);
            } else {
                tempArray[i] = input[i];
            }
        }
        StdString1 string1 = new StdString1(tempArray);
        return new StringBuilder(string1.toString());
    }

    public static StringBuilder makeLowercase(char[] input) throws IllegalArgumentException {
        char[] tempArray = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            if (isAsciiUppercase(input[i])) {
                tempArray[i] = toAsciiLowercase(input[i]);
            } else {
                tempArray[i] = input[i];
            }
        }
        StdString1 string1 = new StdString1(tempArray);
        return new StringBuilder(string1.toString());
    }

    public static StringBuilder makeCamel(char[] input) throws IllegalArgumentException {
        char[] tempArray = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            if (isAsciiNumeric(input[i])) {
                tempArray[i] = input[i];
            } else if (i % 2 == 0) {
                tempArray[i] = toAsciiLowercase(input[i]);
            } else {
                tempArray[i] = toAsciiUppercase(input[i]);
            }
        }
        StdString1 string1 = new StdString1(tempArray);
        return new StringBuilder(string1.toString());
    }

    public static boolean isStringAlphaNumerical(char[] input) throws IllegalArgumentException {
        int length = input.length;
        for (char c : input) {
            if (isAsciiAlphabetic(c) || isAsciiNumeric(c) || c == 32) {
                length--;
            }
        }
        return length == 0;
    }

    public static char[] concatStrings(char[][] input) throws IllegalArgumentException {
        int length = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if ((input[i][j]) > 127 || (input[i][j]) < 32) {
                    throw new IllegalArgumentException();
                }
                length++;
            }
        }
        char[] chars = new char[length];
        length = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                chars[length] = input[i][j];
                length++;
            }
        }
        return chars;
    }

    public static int toInt(char[] input) throws NumberFormatException, IllegalArgumentException {
        if (input.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean isNegative = false;
        char[] tempChar;
        if (input[0] == 45) {
            isNegative = true;
            tempChar = new char[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                tempChar[i - 1] = input[i];
            }
        } else {
            tempChar = new char[input.length];
            for (int i = 0; i < input.length; i++) {
                tempChar[i] = input[i];
            }
        }
        int tempInt = 0;
        int counter = 0;
        int factor = 0;
        for (int i = 0; i < tempChar.length; i++) {
            if (!isAsciiNumeric(tempChar[i])) {
                throw new NumberFormatException();
            }
            factor = (int) NumberUtils.power(10, tempChar.length - i - 1);
            counter = 0;
            for (int j = 48; j < 58; j++) {
                if (j == tempChar[i]) {
                    break;
                }
                counter++;
            }
            tempInt += factor * counter;
        }
        return isNegative ? tempInt * -1 : tempInt;
    }
}
