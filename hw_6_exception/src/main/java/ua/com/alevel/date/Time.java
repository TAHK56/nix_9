package ua.com.alevel.date;

import ua.com.alevel.exception.MyDateException;

import java.util.Objects;

public class Time {

    private int hour;
    private int minute;
    private int second;
    private int millisecond;

    public Time() {
    }

    public Time(int hour, int minute, int second, int millisecond) throws MyDateException {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(int millisecond) {
        this.millisecond = millisecond;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                ", millisecond=" + millisecond +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute && second == time.second && millisecond == time.millisecond;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second, millisecond);
    }
}
