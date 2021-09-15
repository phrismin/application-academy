package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {
  public static char[] convertToCharArray(int number) {
    if (number == 0) {
      return new char[]{'0'};
    }
    int countChar = 0;
    int tempNumber = number;
    while (tempNumber != 0) {
      tempNumber /= 10;
      countChar++;
    }
    int remainder;
    char[] chars;
    int constAscii = 48;
    if (isNegative(number)) {
      chars = new char[++countChar];
      chars[0] = '-';
      for (int i = chars.length - 1; i > 0; i--) {
        remainder = (number % 10) * -1;
        chars[i] = (char) (remainder + constAscii);
        number /= 10;
      }
    } else {
      chars = new char[countChar];
      for (int i = chars.length - 1; i > -1; i--) {
        remainder = (number % 10);
        chars[i] = (char) (remainder + constAscii);
        number /= 10;
      }
    }
    return chars;
  }

  public static boolean isNegative(int number) {
    return number < 0;
  }

  public static int findIndexOfBiggestNumber(int[] numbers) {
    int index = 0;
    int bigNumber = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (bigNumber < numbers[i]) {
        bigNumber = numbers[i];
        index = i;
      }
    }
    return index;
  }

  public static int findBiggest(int[] numbers) {
    return numbers[findIndexOfBiggestNumber(numbers)];
  }

  public static int findBiggest(int left, int mid, int right) {
    return findBiggest(left, findBiggest(mid, right));
  }

  public static int findBiggest(int left, int right) {
    return left < right ? right :  left;
  }

  public static int[] generateNumbers() {
    int[] array = new int[100];
    for (int i = 0; i < 100; i++) {
      array[i] = i;
    }
    return array;
  }
}