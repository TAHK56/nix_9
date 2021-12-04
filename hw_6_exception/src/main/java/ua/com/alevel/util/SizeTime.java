package ua.com.alevel.util;

public enum SizeTime {
    MILLISECONDS(1000), SECONDS(60), MINUTES(60), HOURS(24);
    private int value;

    SizeTime(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
