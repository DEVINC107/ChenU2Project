import java.util.Scanner;

public class LinearEquationLogic {
    Scanner scan;
    LinearEquation eq;
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }
    public void start() {
        getEquation();
        if (!eq.valid()) {
            System.out.println("Bad equation. Do not enter the same x coordinate for both pairs.");
        } else {
            System.out.println(eq.lineInfo());
        }
        supplyXCoordinates();
    }

    public void getEquation() {
        System.out.println("Welcome to the linear equation calculator.");
        System.out.print("Enter the first coordinate pair: ");
        String first = scan.nextLine();
        System.out.print("Enter the second coordinate pair: ");
        String second = scan.nextLine();
        eq = new LinearEquation(LinearEquation.parse(first), LinearEquation.parse(second));
    }

    public void supplyXCoordinates() {
        if (eq.valid()) {
            System.out.print("Enter an x coordinate: ");
            double x = scan.nextDouble();
            scan.nextLine();
            System.out.println(eq.coordinateForX(x));
        }
        System.out.print("Continue(y/n)?");
        String option = scan.nextLine();
        if (option.equals("y")) {
            start();
        }
    }
}
