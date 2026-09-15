package core_java_and_oop;

/**
 * Question: Implement exception handling using try, catch, and finally blocks 
 * to manage runtime errors like array bounds and arithmetic exceptions.
 * Also includes custom exceptions and multi-catch blocks.
 */

// Custom Exception Definition
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionHandlingDemo {

    // Method demonstrating throws keyword and custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is not eligible for driving license!");
        }
        System.out.println("Valid age: " + age + ". Eligible for driving license.");
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        JAVA EXCEPTION HANDLING DEMO             ");
        System.out.println("=================================================");

        // 1. Handling ArithmeticException (Division by zero)
        System.out.println("\n--- 1. Handling ArithmeticException ---");
        try {
            int numerator = 50;
            int denominator = 0;
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed after arithmetic check.");
        }

        // 2. Handling ArrayIndexOutOfBoundsException
        System.out.println("\n--- 2. Handling ArrayIndexOutOfBoundsException ---");
        try {
            int[] numbers = { 10, 20, 30 };
            System.out.println("Accessing index 5: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed after array access check.");
        }

        // 3. Multi-catch block and NullPointerException handling
        System.out.println("\n--- 3. Multiple Exception Handling ---");
        try {
            String text = null;
            System.out.println("Length of string: " + text.length());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.err.println("Caught Exception (Multi-Catch): " + e.getClass().getSimpleName() + " -> " + e.getMessage());
        } finally {
            System.out.println("Clean-up operations completed in finally.");
        }

        // 4. Custom Exception Demonstration
        System.out.println("\n--- 4. Handling Custom Exception ---");
        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.err.println("Custom Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Validation routine finished.");
        }
    }
}
