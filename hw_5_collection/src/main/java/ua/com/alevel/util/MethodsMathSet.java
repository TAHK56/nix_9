package ua.com.alevel.util;

import ua.com.alevel.Main;
import ua.com.alevel.MathSet;

import java.util.Arrays;

public class MethodsMathSet {

    private static MathSet<Number> numberMathSet = Main.getMathSet();

    public static void workWithMethods() {
        runNavigation();
        String answer = UserInput.chooseUser();
        switch (answer) {
            case "0" -> System.out.println("Maybe next time...");
            case "1" -> {
                runNavigationWorkWithElements();
                System.out.println("Choose method: ");
                String chooseUser = UserInput.chooseUser();
                runMethodsChosenUser(chooseUser);
            }
            case "2" -> {
                runNavigationSort();
                System.out.println("Choose method: ");
                String chooseUser = UserInput.chooseUser();
                runMethodsChosenUserSort(chooseUser);
            }
            case "3" -> {
                runNavigationGetMethods();
                System.out.println("Choose method: ");
                String chooseUser = UserInput.chooseUser();
                runMethodsChosenUserGetMethods(chooseUser);
            }
            case "4" -> {
                System.out.println("Methods: ");
                System.out.println("Number[] toArray() - 1");
                System.out.println("Number[] toArray(int firstIndex, int lastIndex) - 2");
                String chooseUser = UserInput.chooseUser();
                if (chooseUser.equals("1")) {
                    System.out.println(Arrays.deepToString(numberMathSet.toArray()));
                }
                if (chooseUser.equals("2")) {
                    System.out.println("Please input firstIndex: ");
                    int firstIndex = UserInput.getIntegerRange();
                    System.out.println("Please input lastIndex: ");
                    int lastIndex = UserInput.getIntegerRange();
                    System.out.println(Arrays.deepToString(numberMathSet.toArray(firstIndex, lastIndex)));
                }
            }
            case "5" -> {
                System.out.println("Only one method: MathSet<Number>cut(int firstIndex, int lastIndex)");
                System.out.println("Please input firstIndex: ");
                int firstIndex = UserInput.getIntegerRange();
                System.out.println("Please input lastIndex: ");
                int lastIndex = UserInput.getIntegerRange();
                ConstructorMathSet.getMathSets().add(numberMathSet.cut(firstIndex, lastIndex));
                System.out.println("Our MathSet last");
                ConstructorMathSet.showCreatedConstructors();
            }
            case "6" -> {
                System.out.println("Methods: ");
                System.out.println("clear() - 1");
                System.out.println("clear(Numbers[] numbers) - 2");
                String chooseUser = UserInput.chooseUser();
                if (chooseUser.equals("1")) {
                    numberMathSet.clear();
                    System.out.println(numberMathSet);
                }
                if (chooseUser.equals("2")) {
                    System.out.println("Please input an array of numbers: ");
                    numberMathSet.clear(UserInput.getArrayFromUser());
                }
            }
            default -> System.out.println("All..");
        }

    }

    private static void runNavigation() {
        System.out.println("Methods divide by group: ");
        System.out.println("Work with elements(add, join, intersection)  - 1");
        System.out.println("Sort(sortAsc, sortDesc) - 2");
        System.out.println("Get smth(getMax, getAverage...) - 3");
        System.out.println("Get arrays - 4");
        System.out.println("Cut - 5");
        System.out.println("Clear - 6");
        System.out.println("EXIT - 0");
        System.out.println();
    }

    private static void runMethodsChosenUser(String answer) {
        switch (answer) {
            case "0" -> System.out.println("Finish...");
            case "1" -> {
                System.out.println("Please input number do you want to add");
                String number = UserInput.checkOnNullAndEmpty();
                numberMathSet.add(UserInput.checkInput(number));
                System.out.println(numberMathSet);
            }
            case "2" -> {
                System.out.println("Please array of numbers do you want to add");
                numberMathSet.add(UserInput.getArrayFromUser());
                System.out.println(numberMathSet);
            }
            case "3" -> {
                System.out.println("Please choose MathSet we created");
                ConstructorMathSet.showCreatedConstructors();
                numberMathSet.join(getCreated());
                System.out.println(numberMathSet);
            }
            case "4" -> {
                System.out.println("Please choose MathSet we created");
                ConstructorMathSet.showCreatedConstructors();
                System.out.println("Input how many do you want to input MathSets:");
                int numberArray = UserInput.getIntegerRange();
                while (numberArray > 0) {
                    numberMathSet.join(getCreated());
                    numberArray--;
                }
                System.out.println(numberMathSet);
            }

            case "5" -> {
                System.out.println("Please choose MathSet we created");
                ConstructorMathSet.showCreatedConstructors();
                numberMathSet.intersection(getCreated());
                System.out.println(numberMathSet);
            }
            case "6" -> {
                System.out.println("Please choose MathSet we created");
                ConstructorMathSet.showCreatedConstructors();
                System.out.println("Input how many do you want to input MathSets:");
                int numberArray = UserInput.getIntegerRange();
                while (numberArray > 0) {
                    numberMathSet.intersection(getCreated());
                    numberArray--;
                }
                System.out.println(numberMathSet);
            }
            default -> System.out.println("You have inputted something wrong");
        }
    }

    private static void runNavigationWorkWithElements() {
        System.out.println("Methods: ");
        System.out.println("add(Number n) - 1");
        System.out.println("add(Number... n) - 2");
        System.out.println("join(MathSet<Number> ms) - 3");
        System.out.println("join(MathSet<Number>... ms) - 4");
        System.out.println("intersection(MathSet<Number> ms) - 5");
        System.out.println("intersection(MathSet<Number>... ms) - 6");
        System.out.println("EXIT - 0");
    }

    private static MathSet<Number> getCreated() {
        System.out.println("Choose index: ");
        int choice = UserInput.getIntegerRange();
        MathSet<Number> userChoice = ConstructorMathSet.getMathSets().get(0);
        if (choice < ConstructorMathSet.getMathSets().size()) {
            userChoice = ConstructorMathSet.getMathSets().get(choice);
        } else {
            System.out.println("Incorrect index, so we use first...");
        }
        return userChoice;
    }

    private static void runNavigationSort() {
        System.out.println("Methods: ");
        System.out.println("sortDesc() - 1");
        System.out.println("sortDesc(int firstIndex, int lastIndex) - 2");
        System.out.println("sortDesc(Number value) - 3");
        System.out.println("sortAsc() - 4");
        System.out.println("sortAsc(int firstIndex, int lastIndex) - 5");
        System.out.println("sortAsc(Number value) - 6");
        System.out.println("EXIT - 0");
    }

    private static void runMethodsChosenUserSort(String answer) {
        switch (answer) {
            case "0" -> System.out.println("Finish...");
            case "1" -> {
                numberMathSet.sortDesc();
                System.out.println(numberMathSet);
            }
            case "2" -> {
                System.out.println("Please input firstIndex: ");
                int firstIndex = UserInput.getIntegerRange();
                System.out.println("Please input lastIndex: ");
                int lastIndex = UserInput.getIntegerRange();
                numberMathSet.sortDesc(firstIndex, lastIndex);
                System.out.println(numberMathSet);
            }
            case "3" -> {
                System.out.println("Please input number: ");
                Number num = UserInput.checkInput(UserInput.checkOnNullAndEmpty());
                numberMathSet.sortDesc(num);
                System.out.println(numberMathSet);
            }
            case "4" -> {
                numberMathSet.sortAsc();
                System.out.println(numberMathSet);
            }

            case "5" -> {
                System.out.println("Please input firstIndex: ");
                int firstIndex = UserInput.getIntegerRange();
                System.out.println("Please input lastIndex: ");
                int lastIndex = UserInput.getIntegerRange();
                numberMathSet.sortAsc(firstIndex, lastIndex);
                System.out.println(numberMathSet);
            }
            case "6" -> {
                System.out.println("Please input number: ");
                Number num = UserInput.checkInput(UserInput.checkOnNullAndEmpty());
                numberMathSet.sortAsc(num);
                System.out.println(numberMathSet);
            }
            default -> System.out.println("You have inputted something wrong");
        }
    }

    private static void runNavigationGetMethods() {
        System.out.println("Methods: ");
        System.out.println("Number get(int index)  - 1");
        System.out.println("Number getMax() - 2");
        System.out.println("Number getMin() - 3");
        System.out.println("Number getAverage() - 4");
        System.out.println("Number getMedian() - 5");
        System.out.println("Show our MathSet - 6");
        System.out.println("EXIT - 0");
    }

    private static void runMethodsChosenUserGetMethods(String answer) {
        switch (answer) {
            case "0" -> System.out.println("Finish...");
            case "1" -> {
                System.out.println("Input index number");
                int index = UserInput.getIntegerRange();
                System.out.println(numberMathSet.get(index));
            }
            case "2" -> {
                System.out.println(numberMathSet.getMax());
            }
            case "3" -> {
                System.out.println(numberMathSet.getMin());
            }
            case "4" -> {
                System.out.println(numberMathSet.getAverage());
            }

            case "5" -> {
                System.out.println(numberMathSet.getMedian());
            }
            case "6" -> {
                System.out.println(numberMathSet);
            }
            default -> System.out.println("You have inputted something wrong");
        }
    }

}
