package ua.com.alevel.level1.uniquenumber;

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
