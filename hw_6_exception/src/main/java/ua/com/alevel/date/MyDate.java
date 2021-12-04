package ua.com.alevel.date;

import java.util.Objects;

public class MyDate {

    private Time time;
    private CalendarDate date;

    public MyDate(Time time, CalendarDate date) {
        this.time = time;
        this.date = date;
    }

    public MyDate(int hour, int minute, int second, int millisecond, int year, int month, int day) {
        time = new Time(hour, minute, second, millisecond);
        date = new CalendarDate(year, month, day);
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public CalendarDate getDate() {
        return date;
    }

    public void setDate(CalendarDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "time=" + time +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(time, myDate.time) && Objects.equals(date, myDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, date);
    }
}
