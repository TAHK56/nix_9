package ua.com.alevel;

import ua.com.alevel.chess.board.Cell;
import ua.com.alevel.chess.board.ChessBoard;
import ua.com.alevel.chess.figure.Horse;
import ua.com.alevel.geomfigure.Triangle;
import ua.com.alevel.uniquenumber.UniqueNumberArray;
import ua.com.alevel.validinput.InputArray;
import ua.com.alevel.validinput.InputCell;
import ua.com.alevel.validinput.InputUser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        runNavigation();
        String userInput = InputUser.checkInput();

        switch (checkNumber(userInput)) {
            case "1" :
                System.out.println("The unique number in array is "
                        + UniqueNumberArray.countUniqueElements(InputArray.create()));
                break;
            case "2" :
                System.out.println("Input coordinate for all tops using enter(Every top will be mark ****) ");
                System.out.println("The area of a triangle is " + new Triangle().computeArea());
                break;
            case "3" :
                System.out.println("Input position of knight:(using chess notation)");
                String userChessNotation = InputCell.checkInputNotation();
                Horse horse = new Horse(ChessBoard.getInstance().findByChessNotation(userChessNotation));
                while (true) {
                    System.out.println("Input your step of knight:");
                    String stepKnight = InputCell.checkInputNotation();
                    Cell cell = ChessBoard.getInstance().findByChessNotation(stepKnight);
                    horse.showStep(cell);
                    System.out.println("Do you want continue  a step horse?");
                    System.out.println("Input Y");
                    Scanner scanner = new Scanner(System.in);
                    if (scanner.next().equalsIgnoreCase("Y")) {
                        System.out.println("Do you want a previous position or that was? Please input Y if a new position");
                        if (scanner.next().equalsIgnoreCase("Y")) {
                            horse.setCell(cell);
                        }
                    } else {
                        break;
                    }
                }
            default:
                break;
        }

        System.out.println("Do you want to go on ? Choose Y");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equalsIgnoreCase("Y")) {
            main(args);
        }
        System.out.println("Goodbye...");
    }

    private static void runNavigation() {
        System.out.println("Hello. This is level 1 of the first module.\n" +
                "Please, choose something from my preview.\n" +
                "1-Unique numbers in an array\n" +
                "2-Triangle area\n" +
                "3-Horse on the chessboard\n");
    }

    private static String checkNumber(String userInput) {
        while (!userInput.matches("[1-3]")) {
            System.out.println("Unfortunately you have chosen the incorrect symbol\n" +
                    "Try again");
            userInput = InputUser.checkInput();
        }
        return userInput;
    }

}
