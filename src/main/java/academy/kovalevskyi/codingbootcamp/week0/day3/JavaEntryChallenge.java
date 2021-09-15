package academy.kovalevskyi.codingbootcamp.week0.day3;

public class JavaEntryChallenge {
  public static int sumOfTwoNumbers(int a, int b) {
    return a + b;
  }

  public static int convertMinToSec(int minutes) {
    return minutes * 60;
  }

  public static void compareTwoNumbers(int a, int b) {
    if (a > b) {
      System.out.print("Result: a is bigger");
    } else if (a < b) {
      System.out.print("Result: b is bigger");
    } else {
      System.out.print("Result: numbers are equal");
    }
  }

  public static void concatTwoStrings(String firstName, String lastName) {
    System.out.print(firstName + ' ' + lastName);
  }

  public static int remainder(int a, int b) {
    return a % b;
  }

  public static boolean divisibleBy5(int num) {
    return num % 5 == 0;
  }

  public static int firstElementOfArray(int[] arr) {
    return arr[0];
  }

  public static int smallestElementOfArray(int[] arr) {
    int smallElement = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (smallElement > arr[i]) {
        smallElement = arr[i];
      }
    }
    return smallElement;
  }

  public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
    if (quick) {
      if (reliable) {
        if (efficient) {
          System.out.print("Result of work: excellent, but you are dreaming");
        } else {
          System.out.print("Result of work: poor, but fast enough");
        }
      } else if (!efficient) {
        System.out.print("Pick at least two");
      } else {
        System.out.print("Result of work: excellent, but pricey");
      }
    } else if (reliable) {
      if (efficient) {
        System.out.print("Result of work: good, but tired of waiting");
      } else {
        System.out.print("Pick at least two");
      }
    } else {
      System.out.print("Pick at least two");
    }
  }

  public static void printHello() {
    System.out.println("Hello World");
  }

  static void main(String[] args) {
    printHello();
  }
}
