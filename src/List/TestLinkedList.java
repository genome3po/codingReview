package List;

/**
 * Created by Jeprox on 12/6/17.
 */

import java.util.LinkedList;

public class TestLinkedList {

    public static void main(String[] args) {

        // Create  a list for strings
        LinkedList<String> list = new LinkedList<>();

        // Add elements to the list
        list.add("America"); // Add it to the list
        System.out.println("(1)" + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2)" + list);

        list.add("Russia"); // Add it to the end of the list
        System.out.println("(3)" + list);

        list.addLast("France"); // Add it to the end of the list
        System.out.println("(4)" + list);

        list.add(2, "Germany"); // Add it to the list at index 2
        System.out.println("(5)" + list);

        list.add(5, "Norway"); // Add it to the list at index 5
        System.out.println("(6)" + list);

        

    }
}
