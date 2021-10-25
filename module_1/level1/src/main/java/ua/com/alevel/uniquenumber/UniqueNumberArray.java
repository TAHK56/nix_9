package ua.com.alevel.uniquenumber;

import java.util.*;

public class UniqueNumberArray {

    public static int countUniqueElements(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int el : numbers) {
            set.add(el);
        }

        return set.size();
    }
}
