package ua.com.alevel;

public class Main {

    private MathSet<Number> mathSet = new MathSet<>();

    public static void main(String[] args) {
        System.out.println("Welcome to MathSet class");
        System.out.println("Please choose some options");
        runNavigation();
        UserInput userInput = new UserInput();
        String answer = userInput.checkInput();

        while (answer != null) {
            if (answer.equals("0")) {
                System.exit(0);
            }
        }

    }

    private static void runNavigation() {
        System.out.println();
        System.out.println("Create object MathSet  - 1");
        System.out.println("Use created object by default: - 2");
        System.out.println("EXIT - 0");
        System.out.println();
    }

    private static boolean checkNumber(String src) {
        return src.matches("[0-3]");
    }

    private static void createMathset(String choice) {
        System.out.println("Choose one of the given constructors to create object:");
        System.out.println("Constructor without parameters - 1");
        System.out.println("Constructor with a parameter - 2");

    }
}
