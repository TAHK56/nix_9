package ua.com.alevel.level3.game;

public class Board {

    private final static int RANDOM_DEFAULT_FACTOR = 2;
    private final Cell[][] grid;
    private int height;
    private int width;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        grid = new Cell[height][width];
        initializeDefault();
        show();
    }

    private void initializeDefault() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int state = (int) (Math.random() * RANDOM_DEFAULT_FACTOR);
                if (state == State.LIVE.getVal()) {
                    grid[i][j] = new Cell(State.LIVE);
                } else {
                    grid[i][j] = new Cell(State.DEAD);
                }
            }
        }
    }

    private void show() {
        for (Cell[] cells : grid) {
            System.out.println();
            for (Cell cell : cells) {
                System.out.print(cell + " ");
            }
        }
    }

    private int countNeighbours(int row, int col) {
        int sum = 0;

        if (row != 0 && col != 0) {
            if (grid[row - 1][col - 1].getState() == State.LIVE) {
                sum++;
            }
        }

        if (row != 0) {
            if (grid[row - 1][col].getState() == State.LIVE) {
                sum++;
            }
        }

        if (row != 0 && col != width - 1) {
            if (grid[row - 1][col + 1].getState() == State.LIVE) {
                sum++;
            }
        }

        if (col != 0) {
            if (grid[row][col - 1].getState() == State.LIVE) {
                sum++;
            }
        }

        if (col != width - 1) {
            if (grid[row][col + 1].getState() == State.LIVE) {
                sum++;
            }
        }

        if (row != height - 1 && col != 0) {
            if (grid[row + 1][col - 1].getState() == State.LIVE) {
                sum++;
            }
        }

        if (row != height - 1) {
            if (grid[row + 1][col].getState() == State.LIVE) {
                sum++;
            }
        }

        if (row != height - 1 && col != width - 1) {
            if (grid[row + 1][col + 1].getState() == State.LIVE) {
                sum++;
            }
        }
        return sum;
    }

    public void applyRules() {
        final int TWO_NEIGHBOURS = 2;
        final int THREE_NEIGHBOURS = 3;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int neighbours = countNeighbours(i, j);
                if (grid[i][j].getState() == State.LIVE) {
                    if (neighbours < TWO_NEIGHBOURS) {
                        grid[i][j].setState(State.DEAD);
                    }
                    if (neighbours == TWO_NEIGHBOURS || neighbours == THREE_NEIGHBOURS) {
                        grid[i][j].setState(State.LIVE);
                    }
                    if (neighbours > THREE_NEIGHBOURS) {
                        grid[i][j].setState(State.DEAD);
                    }
                } else if (grid[i][j].getState() == State.DEAD && neighbours == THREE_NEIGHBOURS) {
                    grid[i][j].setState(State.LIVE);
                }
            }
        }

        show();
    }

}
