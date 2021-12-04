package ua.com.alevel.util;

import ua.com.alevel.date.MyDate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDates {

    public static List<MyDate> sort(List<MyDate> dates, boolean choice) {

        List<MyDate> result = dates;
        if (choice) {
          result =  dates.stream().map(DateInMilliseconds::convertDate)
                    .sorted().map(ConvertMillisecondsInTimeAndDate::convertMillisecondsInDate).collect(Collectors.toList());

        } else {
          result = dates.stream().map(DateInMilliseconds::convertDate)
                    .sorted(Comparator.reverseOrder())
                    .map(ConvertMillisecondsInTimeAndDate::convertMillisecondsInDate)
                    .collect(Collectors.toList());
        }
        return result;
    }
}
