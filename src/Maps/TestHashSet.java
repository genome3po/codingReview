package Maps;

/**
 * Created by Jeprox on 12/5/17.
 */

import java.util.*;

public class TestHashSet {
    public static void main(String[] args) {
        // Create HashSet
        Set<String> set = new HashSet<>();

        // Add strings to the set
        set.add("London");
        set.add("Paris ");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        System.out.println(set);

        for (String s: set) System.out.print(s.toUpperCase() + " ");

    }
}
