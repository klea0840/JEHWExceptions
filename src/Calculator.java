public class Calculator {

    double num1, num2;

    Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    double add(double num1, double num2) {
        System.out.println("The sum is " + (num1 + num2));
        return num1 + num2;
    }

    double sub(double num1, double num2) {
        System.out.println("The subtraction is " + (num1 - num2));
        return num1 - num2;
    }

    double mul(double num1, double num2) {
        System.out.println("The multiplication is " + (num1 * num2));
        return num1 * num2;
    }

    double div(double num1, double num2) {

        // TODO: сделать без приведения к int

        if(num2 == 0) {

            try {
                double value = num1 / num2;
                boolean isInfinite = Double.isInfinite(value);
                throw new Exception("by zero");
            } catch (Exception e) {
                System.out.println("Exception processing...");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("The division is " + (num1 / num2));
        }

        System.out.println("Life goes on");
        return num1 / num2;
    }
}
