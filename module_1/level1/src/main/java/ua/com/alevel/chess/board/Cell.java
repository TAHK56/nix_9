package ua.com.alevel.chess.board;

public class Cell {

    private String chessNotation;
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.chessNotation = setChessNotation(x, y);
    }

    public String getChessNotation() {
        return chessNotation;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private   String setChessNotation(int horizontal, int vertical) {
        char firstPosition = 'a';
        int correctPosition = 1;

        char vert = (char) (horizontal + firstPosition);
        int hor = correctPosition + vertical;

        return String.valueOf(vert).concat(String.valueOf(hor));
    }
}
