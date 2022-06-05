package academy.kovalevskyi.codingbootcamp.week2.day0;

public class Calculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide 3 input arguments, example: 2 + 3");
            return;
        }
        long result;
        try {
            long first = Integer.parseInt(args[0]);
            long second = Integer.parseInt(args[2]);
            result = switch (args[1].trim().charAt(0)) {
                case '+' -> first + second;
                case '-' -> first - second;
                case '/' -> first / second;
                case '*' -> first * second;
                case '%' -> first % second;
                default -> throw new IllegalArgumentException();
            };
            System.out.println("result: " + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is impossible!");
        }
    }
}
