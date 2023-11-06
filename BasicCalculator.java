import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            try {
                // Display a welcome message
                displayWelcomeMessage();

                // Prompt the user to enter an expression
                String expression = promptForExpression(inputScanner);

                if (isValidExpression(expression)) {
                    double result = calculateExpression(expression);
                    displayResult(result);
                } else {
                    handleInvalidExpression();
                }

                if (!askToContinue(inputScanner)) {
                    break;
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                handleException(e);
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("Basic Calculator\n");
    }

    private static String promptForExpression(Scanner inputScanner) {
        System.out.println("Enter an expression (e.g: '5 + 10'):");
        return inputScanner.nextLine();
    }

    private static boolean isValidExpression(String expression) {
        String[] parts = expression.split(" ");
        return parts.length == 3 && "+-*/".contains(parts[1]) && isDouble(parts[0]) && isDouble(parts[2]);
    }

    private static double calculateExpression(String expression) {
        String[] parts = expression.split(" ");
        double num1 = Double.parseDouble(parts[0]);
        String operation = parts[1];
        double num2 = Double.parseDouble(parts[2]);

        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by 0 is not allowed.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Entered operator is invalid. Valid operators are: '+', '-', '/', '*'");
        }
    }

    private static boolean askToContinue(Scanner inputScanner) {
        System.out.println("\nDo you want to continue the calculation? (Enter 'Y' to continue or any key to exit)");
        String continueResponse = inputScanner.nextLine().toLowerCase();
        return continueResponse.equals("y");
    }

    private static void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    private static void handleInvalidExpression() {
        throw new IllegalArgumentException("\nInvalid expression. Enter Again");
    }

    private static void handleException(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
