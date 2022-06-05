package academy.kovalevskyi.codingbootcamp.week2.day1;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

import java.util.Scanner;

public class BoxGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String width = scanner.nextLine().trim();
            checkNumber(width);
            String high = scanner.nextLine().trim();
            checkNumber(high);
            String site = scanner.nextLine().trim();
            String corner = scanner.nextLine().trim();
        }
    }

    private static void checkNumber(String numberString) {
        char[] chars = new char[numberString.length()];
        StdString1 stdString1 = new StdString1();
        stdString1.toCharArray(numberString)
        int numberInt = StringUtils.toInt(chars);
    }
}
