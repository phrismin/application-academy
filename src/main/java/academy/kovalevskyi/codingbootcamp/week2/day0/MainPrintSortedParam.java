package academy.kovalevskyi.codingbootcamp.week2.day0;

public class MainPrintSortedParam {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
      return;
    }
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < args.length - 1; i++) {
        if (args[i].compareTo(args[i + 1]) > 0) {
          isSorted = false;
          String tempString = args[i + 1];
          args[i + 1] = args[i];
          args[i] = tempString;
        }
      }
    }
    for (String s : args) {
      System.out.println(s);
    }
  }
}
