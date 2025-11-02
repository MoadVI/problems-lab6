package dev.um6p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] originalArray = new String[] {"First", "Second", "Third"};
        List<String> originalList = Arrays.asList(originalArray);

        originalList.set(0, "one");
        System.out.println("list: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder());
        System.out.println("sorted array: " + Arrays.toString(originalArray));

        List<String> resizable = new ArrayList<>(originalList);
        resizable.add("fourth");
        System.out.println("Resizable copy: " + resizable);

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println("New list: " + newList);
    }
}

