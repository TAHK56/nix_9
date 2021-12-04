package ua.com.alevel.util;

public enum SizeMonth {
    BIG_MONTH(31), SMALL_MONTH(30), FEBRUARY_MONTH(28), FEBRUARY_MONTH_LEAP_YEAR(29);
    private int size;

    public int getSize() {
        return size;
    }

    SizeMonth(int size) {
        this.size = size;
    }
}
