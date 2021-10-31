package ua.com.alevel.level1.chess.figure;

import ua.com.alevel.level1.chess.board.Cell;

public abstract class ChessFigure {

    public abstract boolean isCanStep(Cell cell);

    public abstract void showStep(Cell cell);
}
