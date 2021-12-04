package ua.com.alevel.util;

import ua.com.alevel.date.CalendarDate;
import ua.com.alevel.date.MyDate;
import ua.com.alevel.date.Time;

import java.math.BigInteger;

public class ConvertMillisecondsInTimeAndDate {

    private static final int DAY_IN_YEAR_MINIMUM = 365;

    public static MyDate addMilliseconds(BigInteger milliseconds, MyDate myDate) {
        BigInteger current = DateInMilliseconds.convertDate(myDate).add(milliseconds);
        return convertMillisecondsInDate(current);
    }

    public static MyDate addSeconds(int seconds, MyDate myDate) {
        return addMilliseconds(DateInMilliseconds.convertSeconds(seconds), myDate);
    }

    public static MyDate addMinutes(int minutes, MyDate myDate) {
        return addMilliseconds(DateInMilliseconds.convertMinutes(minutes), myDate);
    }

    public static MyDate addHours(int hours, MyDate myDate) {
        return addMilliseconds(DateInMilliseconds.convertHours(hours), myDate);
    }

    public static MyDate addDays(int days, MyDate myDate) {
        return addMilliseconds(DateInMilliseconds.convertDays(days + 1), myDate);
    }

    public static MyDate addYears(int year, MyDate myDate) {
        return addMilliseconds((DateInMilliseconds.convertYears(year)), myDate);
    }

    public static MyDate subtractMilliseconds(BigInteger milliseconds, MyDate myDate) {
        return convertMillisecondsInDate(DateInMilliseconds.convertDate(myDate).subtract(milliseconds));
    }

    public static MyDate subtractSeconds(int seconds, MyDate myDate) {
        return subtractMilliseconds(DateInMilliseconds.convertSeconds(seconds), myDate);
    }

    public static MyDate subtractMinutes(int minutes, MyDate myDate) {
        return subtractMilliseconds(DateInMilliseconds.convertMinutes(minutes), myDate);
    }

    public static MyDate subtractHours(int hours, MyDate myDate) {
        return subtractMilliseconds(DateInMilliseconds.convertHours(hours), myDate);
    }

    public static MyDate subtractDays(int days, MyDate myDate) {
        return subtractMilliseconds(DateInMilliseconds.convertDays(days + 1), myDate);
    }

    public static MyDate subtractYears(int year, MyDate myDate) {
        return subtractMilliseconds((DateInMilliseconds.convertYears(year)), myDate);
    }

    public static MyDate convertMillisecondsInDate(BigInteger millisecond) {

        BigInteger partMillisecond = millisecond.mod(BigInteger.valueOf(SizeTime.MILLISECONDS.getValue()));

        BigInteger partSecond = millisecond.subtract(partMillisecond);
        millisecond = partSecond.divide(BigInteger.valueOf(SizeTime.MILLISECONDS.getValue()));
        partSecond = millisecond.mod(BigInteger.valueOf(SizeTime.SECONDS.getValue()));

        BigInteger partMinute = millisecond.subtract(partSecond);
        millisecond = partMinute.divide(BigInteger.valueOf(SizeTime.SECONDS.getValue()));
        partMinute = millisecond.mod(BigInteger.valueOf(SizeTime.MINUTES.getValue()));

        BigInteger partHour = millisecond.subtract(partMinute);
        millisecond = partHour.divide(BigInteger.valueOf(SizeTime.MINUTES.getValue()));
        partHour = millisecond.mod(BigInteger.valueOf(SizeTime.HOURS.getValue()));

        Time time = new Time(partHour.intValue(), partMinute.intValue(), partSecond.intValue(), partMillisecond.intValue());

        BigInteger partDays = millisecond.subtract(partHour);
        millisecond = partDays.divide(BigInteger.valueOf(SizeTime.HOURS.getValue()));

        CalendarDate calendarDate = convertDay(millisecond);
        MyDate myDate = new MyDate(time, calendarDate);
        return myDate;
    }

    private static CalendarDate convertDay(BigInteger days) {
        CalendarDate calendarDate = new CalendarDate();
        int year = 0;
        int day = days.intValue();
        while (day >= DAY_IN_YEAR_MINIMUM) {
            if (DateInMilliseconds.isLeapYear(year)) {
                day -= DAY_IN_YEAR_MINIMUM + 1;
            } else {
                day -= DAY_IN_YEAR_MINIMUM;
            }
            year++;
        }
        calendarDate.setYear(year);
        int month = 1;
        day++;
        while (day > SizeMonth.FEBRUARY_MONTH.getSize()) {
            day -= getMonthValue(month, year);
            month++;
            if (isMonthFull(month, day, year)) {
                break;
            }
        }
        calendarDate.setMonth(month);
        calendarDate.setDay(day);
        return calendarDate;
    }

    private static int getMonthValue(int month, int year) {
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> SizeMonth.BIG_MONTH.getSize();
            case 2 -> DateInMilliseconds.isLeapYear(year) ? SizeMonth.FEBRUARY_MONTH_LEAP_YEAR.getSize() : SizeMonth.FEBRUARY_MONTH.getSize();
            case 4, 6, 9, 11 -> SizeMonth.SMALL_MONTH.getSize();
            default -> 0;
        };
        return days;
    }

    private static boolean isMonthFull(int month, int day, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> day == SizeMonth.BIG_MONTH.getSize();
            case 2 -> DateInMilliseconds.isLeapYear(year) ? day == SizeMonth.FEBRUARY_MONTH_LEAP_YEAR.getSize() : day == SizeMonth.FEBRUARY_MONTH.getSize();
            case 4, 6, 9, 11 -> day == SizeMonth.SMALL_MONTH.getSize();
            default -> false;
        };
    }
}
