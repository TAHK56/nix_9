package ua.com.alevel.util;

import ua.com.alevel.date.MyDate;

import java.math.BigInteger;

public class DateInMilliseconds {

    private static final long SECOND_IN_MILLISECONDS = SizeTime.MILLISECONDS.getValue();
    private static final long MINUTE_IN_MILLISECONDS = SECOND_IN_MILLISECONDS * SizeTime.SECONDS.getValue();
    private static final long HOUR_IN_MILLISECONDS = MINUTE_IN_MILLISECONDS * SizeTime.MINUTES.getValue();
    private static final long DAY_IN_MILLISECONDS = HOUR_IN_MILLISECONDS * SizeTime.HOURS.getValue();
    private static final long YEAR_IN_MILLISECONDS = DAY_IN_MILLISECONDS * 365;

    public static BigInteger convertSeconds(int seconds) {
        return BigInteger.valueOf(seconds).multiply(BigInteger.valueOf(SECOND_IN_MILLISECONDS));
    }

    public static BigInteger convertMinutes(int minutes) {
        return BigInteger.valueOf(minutes).multiply(BigInteger.valueOf(MINUTE_IN_MILLISECONDS));
    }

    public static BigInteger convertHours(int hours) {
        return BigInteger.valueOf(hours).multiply(BigInteger.valueOf(HOUR_IN_MILLISECONDS));
    }

    public static BigInteger convertDays(int day) {
        day--;
        return BigInteger.valueOf(day).multiply(BigInteger.valueOf(DAY_IN_MILLISECONDS));
    }

    public static BigInteger convertMonths(int month, int year) {
        month--;
        if (month == 0) {
            return BigInteger.ZERO;
        }
        BigInteger result = switch (month) {
            case 1, 3, 5, 7, 8, 10 -> convertDays(SizeMonth.BIG_MONTH.getSize() + 1);
            case 2 -> isLeapYear(year) ? convertDays(SizeMonth.FEBRUARY_MONTH_LEAP_YEAR.getSize() + 1) : convertDays(SizeMonth.FEBRUARY_MONTH.getSize() + 1);
            case 4, 6, 9, 11 -> convertDays(SizeMonth.SMALL_MONTH.getSize() + 1);
            default -> BigInteger.ZERO;
        };
        return result.add(convertMonths(month, year));
    }

    public static BigInteger convertYears(int year) {
        int countLeapYears = year / 4 - year / 100 + year / 400;
        if (!isLeapYear(year)) {
            countLeapYears++;
        }
        if (year == 0) {
            return BigInteger.ZERO;
        }
        BigInteger one = BigInteger.valueOf(year).multiply(BigInteger.valueOf(YEAR_IN_MILLISECONDS));
        BigInteger two = BigInteger.valueOf(countLeapYears).multiply(BigInteger.valueOf(DAY_IN_MILLISECONDS));
        return one.add(two);
    }

    public static BigInteger convertDate(MyDate myDate) {
        BigInteger resultInMilliseconds = BigInteger.ZERO;

        resultInMilliseconds = resultInMilliseconds.add(BigInteger.valueOf(myDate.getTime().getMillisecond()));
        resultInMilliseconds = resultInMilliseconds.add(convertSeconds(myDate.getTime().getSecond()));
        resultInMilliseconds = resultInMilliseconds.add(convertMinutes(myDate.getTime().getMinute()));
        resultInMilliseconds = resultInMilliseconds.add(convertHours(myDate.getTime().getHour()));
        resultInMilliseconds = resultInMilliseconds.add(convertDays(myDate.getDate().getDay()));
        resultInMilliseconds = resultInMilliseconds.add(convertMonths(myDate.getDate().getMonth(), myDate.getDate().getYear()));
        resultInMilliseconds = resultInMilliseconds.add(convertYears(myDate.getDate().getYear()));
        return resultInMilliseconds;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}
