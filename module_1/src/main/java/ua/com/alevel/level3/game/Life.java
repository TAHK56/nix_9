package ua.com.alevel.level3.game;

import ua.com.alevel.level3.console.InputSizeBoard;

public class Life {

    public static void start() {
        Board board = new Board(InputSizeBoard.setSizeBoard(), InputSizeBoard.setSizeBoard());
        System.out.println("\n***************************************************");
        board.applyRules();
    }
}
