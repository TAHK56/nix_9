package ua.com.alevel.level3.game;

public enum State {
    LIVE(1), DEAD(0);

     State(final int val) {
        this.val = val;
    }

    private int val;

    public int getVal() {
        return val;
    }
}
