import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.io.File;

public class PostfixExpression {

    public static void main(String[] args) {
        System.out.println("Hello! This is a postfix expression calculator.");
        System.out.println();

        try {
            File file = new File("/home/bhargavreddy1994u/prog-datastru/Assignment-4/in.dat");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println("The value of " + "\"" + line + "\" is " + evaluate(line));
            }
            input.close();
            System.out.println();
            //System.out.println("Bye - bye !");
        } catch (Exception ex) {
            ex.printStackTrace();
        } System.out.println("Bye - bye !");
    }

    public static double evaluate(String s)
    {
        Scanner input = new Scanner(s);
        Stack<Double> numbers = new Stack<Double>( );
        Stack<Character> operations = new Stack<Character>( );
        String next;
        char first;

        while (input.hasNext( )) {
            if (input.hasNext(UNSIGNED_DOUBLE)) {
                next = input.findInLine(UNSIGNED_DOUBLE);
                numbers.push(new Double(next));
            } else {
                next = input.findInLine(CHARACTER);
                first = next.charAt(0);

                switch (first) {
                    case '+': // Addition
                    case '-': // Subtraction
                    case '*': // Multiplication
                    case '/': // Division
                    case '_': // Negation
                    case '^': // Exponent
                    case '#': // Square Root
                        operations.push(first);
                        evaluateStackTops(numbers, operations);
                        break;
                    default: // Illegal character
                        throw new IllegalArgumentException("Illegal character");
                }
            }
        }
        if (numbers.size( ) != 1)
            throw new IllegalArgumentException("Illegal input expression");
        return numbers.pop( );
    }


    public static void evaluateStackTops(Stack<Double> numbers, Stack<Character> operations)
    {
        double operand1, operand2;
        switch (operations.pop()) {
            case '+':
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                numbers.push(operand1 + operand2);
                break;
            case '-':
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                numbers.push(operand1 - operand2);
                break;
            case '*':
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                numbers.push(operand1 * operand2);
                break;
            case '/': // Note: A division by zero results in POSTIVE_INFINITY or
                // NEGATIVE_INFINITY.
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                numbers.push(operand1 / operand2);
                break;
            case '^':
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                numbers.push(Math.pow(operand1, operand2));
                break;
            case '_':
                operand2 = numbers.pop();
                numbers.push(operand2 * -1);
                break;
            case '#':
                operand2 = numbers.pop();
                numbers.push(Math.sqrt(operand2));
                break;
            default:
                throw new IllegalArgumentException("Illegal operation");
        }
    }
    // These patterns are from Appendix B of Data Structures and Other Objects.
    // They may be used in hasNext and findInLine to read certain patterns
    // from a Scanner.
    public static final Pattern CHARACTER =
            Pattern.compile("\\S.*?");
    public static final Pattern UNSIGNED_DOUBLE =
            Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
}

