package ua.com.alevel.chess.figure;

import ua.com.alevel.chess.board.Cell;

public class Horse extends ChessFigure {

    public static final  String KNIGHT = "N";
    private Cell cell;

    public Horse(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public boolean isCanStep(Cell cell) {
        final int TWO_CELL = 2;
        final int ONE_CELL = 1;

        boolean isUpDownTwoCell = (this.cell.getX() + TWO_CELL == cell.getX()) || (this.cell.getX() - TWO_CELL == cell.getX());
        boolean isUpDownOneCell = (this.cell.getY() + ONE_CELL == cell.getY()) || (this.cell.getY() - ONE_CELL == cell.getY());

        boolean isLeftRightTwoCell = (this.cell.getY() + TWO_CELL == cell.getY()) || (this.cell.getY() - TWO_CELL == cell.getY());
        boolean isLeftRightOneCell = (this.cell.getX() + ONE_CELL == cell.getX()) || (this.cell.getX() - ONE_CELL == cell.getX());

        return (isUpDownTwoCell && isUpDownOneCell) || (isLeftRightOneCell && isLeftRightTwoCell);
    }

    @Override
    public void showStep(Cell cell) {
        if (isCanStep(cell)) {
            System.out.println("Your step is " + Horse.KNIGHT + "" + cell.getChessNotation());
        } else {
            System.out.println("You cannot go here");
        }
    }
}
