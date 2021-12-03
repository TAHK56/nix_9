package ua.com.alevel.util;

import ua.com.alevel.date.MyDate;

import java.math.BigInteger;

public class DifferenceBetweenTwoDate {

    private static final int MIN_DAY_IN_YEAR = 365;

    public static BigInteger findDifferenceInMilliseconds(MyDate first, MyDate second) {
        return DateInMilliseconds.convertDate(first).subtract(DateInMilliseconds.convertDate(second)).abs();
    }

    public static BigInteger findDifferenceInSeconds(MyDate first, MyDate second) {
        return findDifferenceInMilliseconds(first, second).divide(DateInMilliseconds.convertSeconds(1));
    }

    public static BigInteger findDifferenceInMinutes(MyDate first, MyDate second) {
        return findDifferenceInMilliseconds(first, second).divide(DateInMilliseconds.convertMinutes(1));
    }

    public static BigInteger findDifferenceInHours(MyDate first, MyDate second) {
        return findDifferenceInMilliseconds(first, second).divide(DateInMilliseconds.convertHours(1));
    }

    public static BigInteger findDifferenceInDays(MyDate first, MyDate second) {
        return findDifferenceInMilliseconds(first, second).divide(DateInMilliseconds.convertDays(2));
    }

    public static BigInteger findDifferenceInYears(MyDate first, MyDate second) {
        return findDifferenceInDays(first, second).divide(BigInteger.valueOf(MIN_DAY_IN_YEAR));
    }
}
