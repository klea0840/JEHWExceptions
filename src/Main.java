import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 1 number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter the 2 number: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter the operation:");
        String operation = sc.next();



        Calculator calculator = new Calculator(num1, num2);

        switch(operation) {
            case "+":
                calculator.add(num1, num2);
                break;
            case "-":
                calculator.sub(num1, num2);
                break;
            case "/":
                calculator.div(num1,num2);
                break;
            case "*":
                calculator.mul(num1, num2);
                break;
            default:
                System.out.println("Incorrect operation symbol. Please try again.");
        }

    }
}
