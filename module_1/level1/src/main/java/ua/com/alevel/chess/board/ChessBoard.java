package ua.com.alevel.chess.board;

public final class ChessBoard {

    private static final int HORIZONTAL = 8;
    private static final int VERTICAL = 8;
    private static ChessBoard instance;
    private  final Cell[][] cells = new Cell[HORIZONTAL][VERTICAL];

    private ChessBoard() {
        initializeBoard();
    }

    public static ChessBoard getInstance() {
        if (instance == null) {
            instance = new ChessBoard();
        }
        return instance;
    }

    private  void initializeBoard() {
        for (int i = 0; i < HORIZONTAL; i++) {
            for (int j = 0; j < VERTICAL; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell findByChessNotation(String chessNotation) {
        Cell find = null;
        for (Cell[] chessCells : cells) {
            for (Cell cell : chessCells) {
                if (cell.getChessNotation().equals(chessNotation)) {
                    find = cell;
                }
            }
        }
        return find;
    }
}
