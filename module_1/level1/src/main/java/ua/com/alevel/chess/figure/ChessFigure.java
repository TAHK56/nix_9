package ua.com.alevel.chess.figure;

import ua.com.alevel.chess.board.Cell;

public abstract class ChessFigure {

    public abstract boolean isCanStep(Cell cell);

    public abstract void showStep(Cell cell);
}
