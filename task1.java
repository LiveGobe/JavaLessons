import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1)
        System.out.println("1)\n");
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        int triangleNumber = 0;
        for (int i = 1; i <= n; i++) {
            triangleNumber += i;
        }

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("n triangle: " + triangleNumber);
        System.out.println("n!: " + factorial);

        // 2)
        System.out.println("\n2)\n");
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }

        // 3)
        System.out.println("\n\n3)\n");
        double num1, num2, result;
        char operator;

        System.out.print("Enter first value: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter second value: ");
        num2 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Unknown operator");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

        scanner.close();
    }
}